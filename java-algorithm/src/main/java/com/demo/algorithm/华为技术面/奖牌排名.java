package com.demo.algorithm.华为技术面;

import java.util.*;

/**
 * 亚运会奖牌榜排名，现在我们假设奖牌榜的排名规则如下：
 *   1、首先gold medal数量多的排在前面；
 *   2、其次silver medal数量多的排在前面；
 *   3、然后bronze medal数量多的排在前面；
 *   4、若以上三个条件仍无法区分名次，则以国家名称的字典序排定。
 *
 *   输入
 *   每行包含一个字符串Namei表示每个国家的名称，和三个整数Gi、Si、Bi表示每个获得的gold medal、silver medal、bronze medal的数量，以空格隔开，如(China 51 20 21)，
 *   具体见样例输入。
 *   输出
 *   输出奖牌榜的依次顺序，只输出国家名称，各占一行，具体见样例输出。
 *
 *   样例
 *   输入样例 1
 *   China 32 28 34
 *   HongKong 12 34 22
 *   TaiWan 23 33 2
 *   Japan 12 34 25
 *   Korea 23 43 0
 *   输出样例 1
 *   China
 *   Korea
 *   TaiWan
 *   Japan
 *   HongKong
 */
public class 奖牌排名 {

    public static void main(String[] args) {
        JiangPai China = new JiangPai("China", 32,28,34);
        JiangPai HongKong = new JiangPai("HongKong", 12,34,22);
        JiangPai TaiWan = new JiangPai("TaiWan", 23,33,2);
        JiangPai Japan = new JiangPai("Japan", 12,34,25);
        JiangPai Korea = new JiangPai("Korea", 23,43,0);

        List<JiangPai> jiangPaiList = new ArrayList<>();
        jiangPaiList.add(China);
        jiangPaiList.add(HongKong);
        jiangPaiList.add(TaiWan);
        jiangPaiList.add(Japan);
        jiangPaiList.add(Korea);
        jiangPaiList.sort(new Comparator<JiangPai>() {
            @Override
            public int compare(JiangPai o1, JiangPai o2) {
                //比较金牌数
                if (o1.gold > o2.gold) {
                    return -1;
                }
                else if (o1.gold < o2.gold) {
                    return 1;
                }

                //金牌数相等，比较银牌数
                if (o1.silver > o2.silver) {
                    return -1;
                }
                else if (o1.silver < o2.silver) {
                    return 1;
                }

                //银牌数相等，比较铜牌数
                if (o1.bronze > o2.bronze) {
                    return -1;
                }
                else if (o1.bronze < o2.bronze) {
                    return 1;
                }

                //所有奖牌数都相等，名称按字典升序
                return o1.name.compareTo(o2.name)*-1;
            }
        });

        System.out.println(jiangPaiList);
    }


    static class JiangPai {
        String name;
        Integer gold;
        Integer silver;
        Integer bronze;

        public JiangPai(String name, Integer gold, Integer silver, Integer bronze) {
            this.name = name;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        @Override
        public String toString() {
            return "JiangPai{" +
                    "name='" + name + '\'' +
                    ", gold=" + gold +
                    ", silver=" + silver +
                    ", bronze=" + bronze +
                    '}';
        }
    }

}
