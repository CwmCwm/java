package com.demo.algorithm.牛客网.华为;


import java.util.*;

/**

 题目描述
 信息社会，有海量的数据需要分析处理，比如公安局分析身份证号码、 QQ 用户、手机号码、银行帐号等信息及活动记录。
 采集输入大数据和分类规则，通过大数据分类处理程序，将大数据分类输出。

 输入描述:
 ﻿一组输入整数序列I和一组规则整数序列R，I和R序列的第一个整数为序列的个数（个数不包含第一个整数）；整数范围为0~0xFFFFFFFF，序列个数不限

 输出描述:
 ﻿从R依次中取出R<i>，对I进行处理，找到满足条件的I<j>：

 I<j>整数对应的数字需要连续包含R<i>对应的数字。比如R<i>为23，I<j>为231，那么I<j>包含了R<i>，条件满足 。

 按R<i>从小到大的顺序:
 (1)先输出R<i>；
 (2)再输出满足条件的I<j>的个数；
 (3)然后输出满足条件的I<j>在I序列中的位置索引(从0开始)；
 (4)最后再输出I<j>。

 附加条件：
 (1)R<i>需要从小到大排序。相同的R<i>只需要输出索引小的以及满足条件的I<j>，索引大的需要过滤掉
 (2)如果没有满足条件的I<j>，对应的R<i>不用输出
 (3)最后需要在输出序列的第一个整数位置记录后续整数序列的个数(不包含“个数”本身)

 序列I：15,123,456,786,453,46,7,5,3,665,453456,745,456,786,453,123（第一个15表明后续有15个整数）
 序列R：5,6,3,6,3,0（第一个5表明后续有5个整数）
 输出：30, 3,6,0,123,3,453,7,3,9,453456,13,453,14,123,6,7,1,456,2,786,4,46,8,665,9,453456,11,456,12,786

 说明：
 30----后续有30个整数
 3----从小到大排序，第一个R<i>为0，但没有满足条件的I<j>，不输出0，而下一个R<i>是3
 6--- 存在6个包含3的I<j>
 0--- 123所在的原序号为0
 123--- 123包含3，满足条件

 示例1
 输入
 15 123 456 786 453 46 7 5 3 665 453456 745 456 786 453 123                             序列I
 5 6 3 6 3 0                                                                            序列R
 输出
 30 3 6 0 123 3 453 7 3 9 453456 13 453 14 123 6 7 1 456 2 786 4 46 8 665 9 453456 11 456 12 786
 说明
 将序列R：5,6,3,6,3,0（第一个5表明后续有5个整数）排序去重后，可得0,3,6。
 第1位的"30"表示后面共30项
 序列I没有包含0的元素。所以不会输出0的相关项。
 序列I中包含3的元素有：I[0]的值为123、I[3]的值为453、I[7]的值为3、I[9]的值为453456、I[13]的值为453、I[14]的值为123。
 第2位的"3"就是R的元素3，"6"是3在序列I中匹配到的个数，"0 123 3 453 7 3 9 453456 13 453 14 123"就是匹配到的在序列I中下标和值
 序列I中包含6的元素有：I[1]的值为456、I[2]的值为786、I[4]的值为46、I[8]的值为665、I[9]的值为453456、I[11]的值为456、I[12]的值为786。
 "6 7 1 456 2 786 4 46 8 665 9 453456 11 456 12 786"同上


 TODO  题意读起来太累了


 * */
public class 数据分类处理 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            //获取并存储I序列
            int INum = sc.nextInt();
            String[] IArray = new String[INum];
            for (int i=0; i<INum; i++) {
                IArray[i] = sc.next();
            }

            //获取并存储R序列（去重排序）
            int RNum = sc.nextInt();
            TreeSet<Integer> RSet = new TreeSet<Integer>();
            for (int i=0; i<RNum; i++) {
                RSet.add(sc.nextInt());
            }


            StringBuffer stringBuffer = new StringBuffer();
            Iterator<Integer> iterator = RSet.iterator();
            while (iterator.hasNext()) {
                String RItem = iterator.next().toString();
                stringBuffer.append(getRes(RItem, IArray));
            }
            System.out.println(stringBuffer.toString().split(" ").length + " " + stringBuffer);
        }
    }

    public static StringBuffer getRes(String RItem, String[] IArray) {
        StringBuffer res = new StringBuffer();
        LinkedHashMap<Integer, String> map = new LinkedHashMap<Integer, String>();
        for (int IIndex=0; IIndex<IArray.length; IIndex++) {
            if (IArray[IIndex].contains(RItem)) {
                map.put(IIndex, IArray[IIndex]);
            }
        }
        if (map.size()>0) {
            res.append(RItem + " " + map.size() + " ");
        }
        for (Map.Entry entry : map.entrySet()) {
            res.append(entry.getKey() + " " + entry.getValue() + " ");
        }
        return res;
    }

}
