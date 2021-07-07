package com.demo.algorithm.牛客网.华为;

import java.util.Scanner;

/**

 题目描述
 考试题目和要点：
 1、中文大写金额数字前应标明“人民币”字样。中文大写金额数字应用壹、贰、叁、肆、伍、陆、柒、捌、玖、拾、佰、仟、万、亿、元、角、分、零、整等字样填写。（30分）
 2、中文大写金额数字到“元”为止的，在“元”之后，应写“整字，如￥ 532.00应写成“人民币伍佰叁拾贰元整”。在”角“和”分“后面不写”整字。（30分）
 3、阿拉伯数字中间有“0”时，中文大写要写“零”字，阿拉伯数字中间连续有几个“0”时，中文大写金额中间只写一个“零”字，如￥6007.14，应写成“人民币陆仟零柒元壹角肆分“。（40分）


 输入描述:
 输入一个double数

 输出描述:
 输出人民币格式

 示例1
 输入
 151121.15
 输出
 人民币拾伍万壹仟壹佰贰拾壹元壹角伍分

 * */
public class 人民币转换 {

    static String[] china = {"壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
    static String[] shi = {"", "拾", "佰", "仟"};
    static String[] wang = {"", "万", "亿"};

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String input = scanner.nextLine();
            String[] arr = input.split("\\.");
            String sb_right = xiaoshu(arr[1]);
            String sb_left = zhengshu(arr[0]);
            StringBuilder sb = new StringBuilder();
            sb.insert(0, sb_right);
            if(!sb_left.equals("")){
                sb.insert(0, "元");
            }
            sb.insert(0, sb_left);
            sb.insert(0, "人民币");
            System.out.println(sb.toString());
        }
    }

    // 整数
    public static String zhengshu(String input){
        if("0".equals(input)) return "";
        StringBuilder sb = new StringBuilder();
        int len = input.length();
        int index = len - 1;
        int k = 0;
        while(index >= 0 && index - 3 >= 0){
            String temp = siweishu(input.substring(index - 3, index + 1));
            if(!"零".equals(temp)){
                sb.insert(0, wang[k]);
            }
            sb.insert(0, temp);
            index = index - 4;
            k++;
        }
        if(index != -1){
            String temp = siweishu(input.substring(0, index + 1));
            sb.insert(0, wang[k]);
            sb.insert(0, temp);
        }
        return sb.toString();
    }

    // 十位
    public static String siweishu(String input){
        StringBuilder sb = new StringBuilder();
        int temp = Integer.valueOf(input);
        if(temp == 0) return "零";
        int index = 0;
        boolean flag = false;
        while(temp / 10 != 0){
            int a = temp % 10;
            if(a == 0){
                if(!flag && index != 0){
                    sb.insert(0, "零");
                    flag = true;
                }
            }else{
                sb.insert(0, shi[index]);
                sb.insert(0, china[a - 1]);
            }

            index++;
            temp = temp / 10;
        }
        if(index == 1 && temp == 1){
            sb.insert(0, shi[index]);
        }else{
            sb.insert(0, shi[index]);
            sb.insert(0, china[temp % 10 - 1]);
        }
        return sb.toString();
    }

    // 小数
    public static String xiaoshu(String input){
        StringBuilder sb = new StringBuilder();
        if(input.charAt(0) == '0' && input.charAt(1) == '0'){
            sb.append("整");
        }else{
            if(input.charAt(0) != '0'){
                sb.append(china[Integer.valueOf(input.substring(0, 1)) - 1] + "角");
            }
            if(input.charAt(1) != '0'){
                sb.append(china[Integer.valueOf(input.substring(1, 2)) - 1] + "分");
            }
        }
        return sb.toString();
    }

}
