package service;

import java.util.List;

/**
 * Created by lois on 2017/7/8.
 */
public interface MaoyanService {

    public List getComments(String movieId);

    public void saveComments(String movieId);

}
