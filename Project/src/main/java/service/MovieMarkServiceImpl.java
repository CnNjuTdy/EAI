package service;

import org.ansj.domain.Result;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tondiyee on 2017/7/8.
 */
@Service
public class MovieMarkServiceImpl {
    private List<String> positiveWords = new ArrayList<String>();
    private List<String> negativeWords = new ArrayList<String>();

    private List<String> extremes = new ArrayList<String>();
    private List<String> verys = new ArrayList<String>();
    private List<String> mores = new ArrayList<String>();
    private List<String> ishs = new ArrayList<String>();

    List<String> antis = new ArrayList<String>();

    public MovieMarkServiceImpl() {
        init();
        System.out.println(antis.size());
        System.out.println(positiveWords.size());
        System.out.println(negativeWords.size());
        System.out.println(extremes.size());
        System.out.println(verys.size());
        System.out.println(mores.size());
        System.out.println(ishs.size());
    }

    private void init() {
        try {
            File file = new File("dic/anti.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = reader.readLine()) != null) {
                antis.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            File file = new File("dic/positive.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = reader.readLine()) != null) {
                positiveWords.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            File file = new File("dic/negative.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = reader.readLine()) != null) {
                negativeWords.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            File file = new File("dic/extreme.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = reader.readLine()) != null) {
                extremes.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            File file = new File("dic/very.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = reader.readLine()) != null) {
                verys.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            File file = new File("dic/more.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = reader.readLine()) != null) {
                mores.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            File file = new File("dic/ish.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = reader.readLine()) != null) {
                ishs.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public int getMark(String movieComment) {
        List<String> markWords = getWords(movieComment);
        int pre = 0;
        int mark = 0;
        for (int i = 0; i < markWords.size(); i++) {
            String markWord = markWords.get(i);
            int emotion = findEmotion(markWord);
            if (emotion != 0) {
                int ratio = getRatio(markWords, i, pre);
                pre = i;
                mark += emotion * ratio;
            }

        }
        return mark;
    }

    //分词
    private List<String> getWords(String movieComment) {
        String str = movieComment;
        Result result = ToAnalysis.parse(str); //分词结果的一个封装，主要是一个List<Term>的terms

        List<Term> terms = result.getTerms(); //拿到terms
        List<String> words = new ArrayList<String>();
        for (int i = 0; i < terms.size(); i++) {
            String word = terms.get(i).getName(); //拿到词
            words.add(word);
        }
        return words;
    }

    private int findEmotion(String word) {
        if (positiveWords.contains(word)) {
            return 1;
        } else if (negativeWords.contains(word)) {
            return -1;
        }
        return 0;
    }

    private int getRatio(List<String> markWords, int current, int pre) {
        if (current > markWords.size()) {
            return 0;
        }
        int ratio = 0;
        for (int i = pre; i < current; i++) {
            String word = markWords.get(i);
            if (extremes.contains(word)) {
                ratio = ratio + 4;
            } else if (verys.contains(word)) {
                ratio = ratio + 3;
            } else if (mores.contains(word)) {
                ratio = ratio + 2;
            } else if (ishs.contains(word)) {
                ratio = ratio + 1;
            }
        }
        if (ratio == 0) {
            ratio = 1;
        }
        for (int i = pre; i < current; i++) {
            String word = markWords.get(i);
            if (antis.contains(word)) {
                ratio = ratio * -1;
            }
        }
        return ratio;
    }

    public static void main(String[] args) {
        MovieMarkServiceImpl movieMark = new MovieMarkServiceImpl();
        System.out.println(movieMark.getMark("电影还行，不过看来看去感觉都是一个套路，没有惊喜"));
        System.out.println(movieMark.getMark("这个电影很不错"));
    }
}
