/*
Navicat MySQL Data Transfer

Source Server         : default
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : movie_db

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2017-06-10 04:55:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for maoyan_cinema
-- ----------------------------
DROP TABLE IF EXISTS `maoyan_cinema`;
CREATE TABLE `maoyan_cinema` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `area` varchar(255) DEFAULT NULL,
  `addr` varchar(255) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of maoyan_cinema
-- ----------------------------
INSERT INTO `maoyan_cinema` VALUES ('1166', 'UME国际影城(玄武门店)', '鼓楼区', '鼓楼区中央路201号南京国际广场购物中心6楼北区（近童家巷）', '24');
INSERT INTO `maoyan_cinema` VALUES ('1175', '金逸影城(大观店)', '鼓楼区', '鼓楼区建宁路300号大观天地MALL3楼', '23');
INSERT INTO `maoyan_cinema` VALUES ('1178', '卢米埃影城(紫峰店)', '鼓楼区', '鼓楼区中山北路6号绿地中心紫峰购物广场5-6楼（近湖南路）', '24');
INSERT INTO `maoyan_cinema` VALUES ('1187', '和平影视娱乐城', '鼓楼区', '鼓楼区中山北路110号', '29');
INSERT INTO `maoyan_cinema` VALUES ('1188', 'SFC上影影城(新城市广场店)', '鼓楼区', '鼓楼区草场门大街99号新城市置业广场3楼（近江东北路）', '24');
INSERT INTO `maoyan_cinema` VALUES ('6278', '金逸影城(玉桥店)', '鼓楼区', '鼓楼区建宁路8号玉桥商业广场9楼', '23');
INSERT INTO `maoyan_cinema` VALUES ('13082', '星美国际影商城(环宇城店)', '鼓楼区', '鼓楼区清凉门大街1号（中海环宇城4楼）', '34');
INSERT INTO `maoyan_cinema` VALUES ('14676', '幸福蓝海国际影城(世茂滨江店)', '鼓楼区', '鼓楼区南通路118号茂悦港4号楼2楼', '28');
INSERT INTO `maoyan_cinema` VALUES ('16515', 'DFC影城(南京马台街店)', '鼓楼区', '鼓楼区马台街99号4楼', '20');

-- ----------------------------
-- Table structure for maoyan_movie
-- ----------------------------
DROP TABLE IF EXISTS `maoyan_movie`;
CREATE TABLE `maoyan_movie` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `director` varchar(255) DEFAULT NULL,
  `star` varchar(255) DEFAULT NULL,
  `3d` int(11) DEFAULT NULL,
  `imax` int(11) DEFAULT NULL,
  `imgUrl` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of maoyan_movie
-- ----------------------------
INSERT INTO `maoyan_movie` VALUES ('38977', '迷失Z城', '探秘亚马逊，失踪无处寻', '詹姆士·格雷', '查理·汉纳姆,罗伯特·帕丁森,西耶娜·米勒', '0', '0', 'http://p0.meituan.net/165.220/movie/771d86af04b8d2ac9ee3999ba0815c79902502.jpg');
INSERT INTO `maoyan_movie` VALUES ('78888', '异形：契约', '天堂实假象，险象险中还', '雷德利·斯科特', '迈克尔·法斯宾德,凯瑟琳·沃特斯顿,比利·克鲁德普', '0', '1', 'http://p1.meituan.net/165.220/movie/732d8d3f60ae22fbeaa0f5b9cbb32a84391769.jpg');
INSERT INTO `maoyan_movie` VALUES ('246012', '加勒比海盗5：死无对证', '亡灵要复仇，船长好发愁', '乔阿吉姆·罗恩尼,艾斯彭·山德伯格', '约翰尼·德普,哈维尔·巴登,布兰顿·思怀兹', '1', '1', 'http://p0.meituan.net/165.220/movie/ee5e691b425292f455c3eac5c628cfc7904509.png');
INSERT INTO `maoyan_movie` VALUES ('246316', '奔跑吧！兄弟', '跑男再出发，集体游三亚', '胡笳,岑俊义', '杨颖,王宝强,李晨', '0', '0', 'http://p0.meituan.net/165.220/movie/85f0d9a604e26be5523a848269346697296774.jpg');
INSERT INTO `maoyan_movie` VALUES ('246360', '“吃吃”的爱', '康永脑洞开，群星浪起来', '蔡康永', '徐熙娣,林志玲,金世佳', '0', '0', 'http://p1.meituan.net/165.220/movie/2dcbf613194280eec7345f0b19371dc9935368.jpg');
INSERT INTO `maoyan_movie` VALUES ('246591', '大鱼海棠', '北冥有鱼鲲，海棠掌乾坤', '梁旋,张春', '季冠霖,苏尚卿,许魏洲', '1', '0', 'http://p1.meituan.net/165.220/movie/a607ab45bcc9e8486328b39bff0132a4420994.jpg');
INSERT INTO `maoyan_movie` VALUES ('246594', '精灵王座', '征途多灾难，爱情过难关', '宋岳峰', '王梓,沈达威,陶典', '1', '0', 'http://p1.meituan.net/165.220/movie/10a824f984f9289c0e82ad8513da9d361046719.jpg');
INSERT INTO `maoyan_movie` VALUES ('247731', '神奇女侠', '神力女超人，救世又圈粉', '派蒂·杰金斯', '盖尔·加朵,克里斯·派恩,罗宾·怀特', '1', '1', 'http://p1.meituan.net/165.220/movie/f013c57e9506cd2e7c609397c8da04d9213647.jpg');
INSERT INTO `maoyan_movie` VALUES ('248700', '速度与激情8', '车王要黑化，家族被击垮', 'F·加里·格雷', '范·迪塞尔,杰森·斯坦森,道恩·强森', '1', '1', 'http://p1.meituan.net/165.220/movie/af297f59e363ce96290dfea22f6fea0c153020.jpg');
INSERT INTO `maoyan_movie` VALUES ('248818', '潜艇总动员之时光宝盒', '潜艇携萌宠，寻宝大乱斗', '何子力', '范楚绒,洪海天,谢元真', '1', '0', 'http://p0.meituan.net/165.220/movie/a245ede7c09b5b6903bd0543e3e71743722294.png');
INSERT INTO `maoyan_movie` VALUES ('249895', '新木乃伊', '阿汤又上阵，情迷古公主', '艾里克斯·库兹曼', '汤姆·克鲁斯,索菲亚·波多拉,罗素·克劳', '1', '1', 'http://p1.meituan.net/165.220/movie/4185bf22758d232e15c5bf52f89a7553867763.png');
INSERT INTO `maoyan_movie` VALUES ('338486', '荡寇风云', '战神戚继光，海战谁更强', '陈嘉上', '赵文卓,洪金宝,万茜', '0', '0', 'http://p1.meituan.net/165.220/movie/cc7402daf3cc47719e08ecd773930992712461.png');
INSERT INTO `maoyan_movie` VALUES ('341148', '梦幻佳期', '三闺蜜相亲，争宠真闹心', '王凯阳,章俊夫', '昆凌,钱枫,蒲巴甲', '0', '0', 'http://p1.meituan.net/165.220/movie/914e98e1d6e3594f0eb24f660a1549af812946.jpg');
INSERT INTO `maoyan_movie` VALUES ('341753', '三只小猪2', '小猪学功夫，跟怪狼比武', '刘炜', '王晓彤,李晔,洪海天', '1', '0', 'http://p0.meituan.net/165.220/movie/a5ad631b75ff046a1f90725e6b37f27d797864.png');
INSERT INTO `maoyan_movie` VALUES ('342177', '走出尘埃', '摇滚老司机，重新找自己', '谢晓东', '秦勇,冯波,齐志', '0', '0', 'http://p1.meituan.net/165.220/movie/2f73262d8cc882dd8d53aa08a1630a81932942.png');
INSERT INTO `maoyan_movie` VALUES ('345719', '异星觉醒', '宇宙外来物，样本来揭秘', '丹尼尔·伊斯皮诺萨', '杰克·吉伦哈尔,丽贝卡·弗格森,瑞安·雷诺兹', '0', '0', 'http://p1.meituan.net/165.220/movie/cc0e89d4db9c01c505bc0387d9e4522d370864.png');
INSERT INTO `maoyan_movie` VALUES ('345992', '美好的意外', '人生有假如，陈坤变主夫', '何蔚庭', '桂纶镁,王景春,欧阳娜娜', '0', '0', 'http://p0.meituan.net/165.220/movie/388490e2742d6985a26da2a0d7d345b11035540.jpg');
INSERT INTO `maoyan_movie` VALUES ('346102', '借眼', '误换阴阳眼，恶鬼来缠身', '张洋', '陈浩民,薛佳凝,罗兰', '1', '0', 'http://p0.meituan.net/165.220/movie/53979865c884276ca522a817dc0bcb95429019.png');
INSERT INTO `maoyan_movie` VALUES ('346287', '内心引力', '一路披荆棘，创业追梦记', '施秋荣,胡弦', '庄崧冽,毛继鸿,钱小华', '0', '0', 'http://p0.meituan.net/165.220/movie/cdcede0f1785330096eeadababf306e4199278.jpg');
INSERT INTO `maoyan_movie` VALUES ('346362', '我心雀跃', '暗恋刚刚好，少女心不老', '刘紫微', '孙伊涵,宋宁,周楚楚', '0', '0', 'http://p0.meituan.net/165.220/movie/750001122b5c505314e9a7e183f6d64519527786.jpg');
INSERT INTO `maoyan_movie` VALUES ('367742', '失恋399年', '穿越回明清，情郎挽芳心', '吴吞', '葛秋谷,郑文蓉,董向荣', '0', '0', 'http://p0.meituan.net/165.220/movie/5491a21cbec2d66a6917f7b59c82eda2125849.jpg');
INSERT INTO `maoyan_movie` VALUES ('490367', '重返·狼群', '女人救小狼，千里送故乡', '亦风', '亦风,李微漪', '0', '0', 'http://p0.meituan.net/165.220/movie/d9ca94c8bd0386038cb1ae4281ef3848660148.png');
INSERT INTO `maoyan_movie` VALUES ('588362', '摔跤吧！爸爸', '为圆摔跤梦，女儿不心疼', '尼特什·提瓦瑞', '阿米尔·汗,萨卡诗·泰瓦,法缇玛·萨那·纱卡', '0', '0', 'http://p0.meituan.net/165.220/movie/aeb864fa21d578d845b9cefc056e40cb2874891.jpg');
INSERT INTO `maoyan_movie` VALUES ('1132343', '碟仙之毕业照', '前任坠崖亡，现任遭了秧', '陆诗雨', '陈圆,刘俐儿,宋伟', '0', '0', 'http://p0.meituan.net/165.220/movie/adf68d56594eccc4b33d714dbc1ae3521024750.jpg');
INSERT INTO `maoyan_movie` VALUES ('1142976', '此情此刻', '一个照相馆，四段关系现', '黄国辉', '林家栋,陈静,孙耀威', '0', '0', 'http://p1.meituan.net/165.220/movie/7efa093f33b48de4e290373be7ef91ea3311727.jpg');
INSERT INTO `maoyan_movie` VALUES ('1181776', '李雷和韩梅梅——昨日重现', '忆起校园事，情归少年时', '杨永春', '张子枫,张逸杰,成梓宁', '0', '0', 'http://p1.meituan.net/165.220/movie/0879eb8e787dd4cede7ee206d43b95b6564255.png');
INSERT INTO `maoyan_movie` VALUES ('1183351', '哆啦A梦：大雄的南极冰冰凉大冒险', '大雄又冒险，勇闯南极地', '高桥敦史', '水田山葵,山新,大原惠美', '0', '0', 'http://p0.meituan.net/165.220/movie/f8518634d7357eca5496b7e7d690dca5760722.jpg');
INSERT INTO `maoyan_movie` VALUES ('1197558', '猪猪侠之英雄猪少年', '猪猪侠归来，再战大反派', '陆锦明,钟裕', '易烊千玺,陈志荣,彭雨菲', '1', '0', 'http://p1.meituan.net/165.220/movie/a7b1c628181c0185e1745d4c80c9aba6164580.jpg');
INSERT INTO `maoyan_movie` VALUES ('1203458', '忠爱无言', '国产小八公，无言情更重', '谈宜之', '高强,于月仙,李玉峰', '0', '0', 'http://p1.meituan.net/165.220/movie/609292d7d5db83c43f9c048c22c6aa6210795120.jpg');
INSERT INTO `maoyan_movie` VALUES ('1204621', '我的爸爸是国王', '公主带老爹，同闯新世界', '刘骏,牛志远', '吕豆,禹祥,绿绮', '1', '0', 'http://p0.meituan.net/165.220/movie/ba3cde77f7b3e1a0bc90ad2de522983d947078.jpg');
INSERT INTO `maoyan_movie` VALUES ('1205281', '异兽来袭', '雪场放烟花，惊醒哥斯拉', '陈海帆', '甘于晓雪,于博宁,杨祖青', '0', '0', 'http://p0.meituan.net/165.220/movie/dec094a89880628bd89f214b8b174271425481.png');
INSERT INTO `maoyan_movie` VALUES ('1205313', '麻辣学院', '学渣战假教，整蛊又爆笑', '李金瀚', '蒋欣,九孔,秦沛', '0', '0', 'http://p0.meituan.net/165.220/movie/859e73527d9d8208f9125faba4f0db5e705561.png');
INSERT INTO `maoyan_movie` VALUES ('1205521', '诡异酒楼', '一日一破产，一夜一惊魂', '蒋国权', '赵东昊,欧阳鑫紫,李璐兵', '0', '0', 'http://p0.meituan.net/165.220/movie/28f2e5bcebe79763a446936a69b5e23e370397.png');
INSERT INTO `maoyan_movie` VALUES ('1206163', '神农溪之恋漂洋过海来爱你', '日本富家女，爱中国渔夫', '童江南', '水原碧衣,杨钧承,刘伟', '0', '0', 'http://p1.meituan.net/165.220/movie/5d62815557f8b57787d2b762c63e2c303120628.jpg');
