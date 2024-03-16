package com.demo.algorithm.牛客网.华为;

import java.util.*;

/**
 https://www.nowcoder.com/practice/03ba8aeeef73400ca7a37a5f3370fe68?tpId=37&&tqId=21250&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking


 （1）需要判断多组数据，这个把我坑坏了！
 （2）需要兄弟单词可以有重复的
 （3）需要判断 查找单词的索引不能大于兄弟字典的大小

 * */
public class 查找兄弟单词 {




    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            //获取并保存字典
            int N = sc.nextInt();
            String[] str = new String[N];
            for (int i=0; i<N; i++) {
                str[i]=sc.next();
            }

            //要查找兄弟单词和第k位
            String findStr = sc.next();
            int k = sc.nextInt();

            ArrayList<String> list = new ArrayList<>();//用于存储匹配到的兄弟单词
            for (int i=0; i<N; i++) {
                if(checkBrother(findStr, str[i])){
                    list.add(str[i]);
                }
            }

            //输出匹配到的兄弟单词的个数
            System.out.println(list.size());
            //匹配到兄弟单词按照字典顺序排序，然后查找第k个兄弟单词，没有符合第k个的话则不用输出
            Collections.sort(list);
            if (list.size() >= k) {
                System.out.println(list.get(k-1));
            }
        }

    }


    //str1 和 str2 是否为兄弟单词，true是兄弟单词，false不是兄弟单词
    //交换该单词字母顺序（注：可以交换任意次），而不添加、删除、修改原有的字母就能生成的单词。
    //兄弟单词要求和原来的单词不同。例如： ab 和 ba 是兄弟单词。 ab 和 ab 则不是兄弟单词。
    public static boolean checkBrother(String str1, String str2) {
        //字符串长度不同肯定不是兄弟单词
        if (str1.length() != str2.length()) {
            return false;
        }

        //字符串完全相同也不是兄弟单词
        if (str1.equals(str2)) {
            return false;
        }

        //如果 str1 和 str2 是兄弟单词，那么arr数组结果全为0
        //用26位数组来表示a至z，str1和str2的字符对应下标的加和减，如果最后arr数组全为0，就证明str1和str2拥有一样的字母且对应字母个数相同
        int[] arr = new int[26];
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        for (int i=0; i<ch1.length; i++) {
            arr[ch1[i]-'a']++;
            arr[ch2[i]-'a']--;
        }
        for (int i=0; i<26; i++) {
            if (arr[i]!=0) {
                return false;
            }
        }

        return true;
    }

}
