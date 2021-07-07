package com.demo.algorithm.牛客网.华为;

import java.io.*;
import java.util.*;
import java.lang.String;

/**


 TODO  题意太长

 * */
public class 自动售货系统 {

    public static void main(String[] args)throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        while((str = br.readLine()) != null){
            char[] sc = str.toCharArray();
            int nb = sc.length;
            int state = 0;
            Num num = new Num();
            int i = 0;
            int pAll = 0;
            int p = 0;
            int q = 0;
            int b = 0;
            String[] sstr = str.split(" ");
            String str1 = sstr[1];
            String[] sstr1 = str1.split("-");
            num.setaOne(Integer.parseInt(sstr1[0]));
            num.setaTwo(Integer.parseInt(sstr1[1]));
            num.setaThree(Integer.parseInt(sstr1[2]));
            num.setaFour(Integer.parseInt(sstr1[3]));
            num.setaFive(Integer.parseInt(sstr1[4]));
            num.setaSix(Integer.parseInt(sstr1[5]));
            String str2 = sstr[2];
            String[] sstr2 = str2.split("-");
            num.setOne(Integer.parseInt(sstr2[0]));
            num.setTwo(Integer.parseInt(sstr2[1]));
            num.setFive(Integer.parseInt(sstr2[2]));
            num.setTen(Integer.parseInt(sstr2[3].split(";")[0]));
            System.out.println("S001:Initialization is successful");
            while(i < nb){
                if(sc[i] == 'p'){
                    state = 1;
                    i = i + 2;
                }
                if(sc[i] == 'b'){
                    state = 2;
                    i = i + 2;
                }
                if(sc[i] == 'c'){
                    state = 3;
                }
                if(sc[i] == 'q'){
                    state = 4;
                    i = i + 1;
                }
                if(state == 1){//p
                    if(sc[i + 1] == ';'){
                        p = p * 10 + sc[i] - '0';
                        pAll += p;
                        if(p != 1 && p != 2 && p != 5 && p != 10){
                            System.out.println("E002:Denomination error");
                        }else if(p != 1 && p != 2 && (num.getOne() + num.getTwo() * 2) < p){
                            System.out.println("E003:Change is not enough, pay fail");
                            pAll = pAll - p;
                            p = 0;
                        }else{
                            if(p > 10){
                                System.out.println("E004:Pay the balance is beyond the scope biggest");
                            }else{
                                if((num.getaOne() + num.getaTwo() + num.getaThree() + num.getaFour() + num.getaFive() + num.getaSix()) == 0){
                                    System.out.println("E005:All the goods sold out");
                                }else{
                                    System.out.println("S002:Pay success,balance=" + pAll);
                                    if(p == 1){
                                        num.setOne(num.getOne() + 1);
                                    }else if(p == 2){
                                        num.setTwo(num.getTwo() + 1);
                                    }else if(p == 5){
                                        num.setFive(num.getFive() + 1);
                                    }else if(p == 10){
                                        num.setTen(num.getTen() + 1);
                                    }
                                }
                            }
                        }
                        state = 0;
                        p = 0;
                    }else{
                        p = p * 10 + sc[i] - '0';
                    }
                }else if(state == 2){//b
                    if(i + 1 >= nb){
                        break;
                    }
                    if(sc[i] == 'A'){
                        if(sc[i + 1] == '1'){
                            b = num.getaOne();
                            if(b <= 0){
                                System.out.println("E007:The goods sold out");
                            }else{
                                if(2 > pAll){
                                    System.out.println("E008:Lack of balance");
                                }else{
                                    pAll = pAll - 2;
                                    System.out.println("S003:Buy success,balance=" + pAll);
                                }
                            }
                        }else if(sc[i + 1] == '2'){
                            b = num.getaTwo();
                            if(b <= 0){
                                System.out.println("E007:The goods sold out");
                            }else{
                                if(3 > pAll){
                                    System.out.println("E008:Lack of balance");
                                }else{
                                    pAll = pAll - 3;
                                    System.out.println("S003:Buy success,balance=" + pAll);
                                }
                            }
                        }else if(sc[i + 1] == '3'){
                            b = num.getaThree();
                            if(b <= 0){
                                System.out.println("E007:The goods sold out");
                            }else{
                                if(4 > pAll){
                                    System.out.println("E008:Lack of balance");
                                }else{
                                    pAll = pAll - 4;
                                    System.out.println("S003:Buy success,balance=" + pAll);
                                }
                            }
                        }else if(sc[i + 1] == '4'){
                            b = num.getaFour();
                            if(b <= 0){
                                System.out.println("E007:The goods sold out");
                            }else{
                                if(5 > pAll){
                                    System.out.println("E008:Lack of balance");
                                }else{
                                    pAll = pAll - 5;
                                    System.out.println("S003:Buy success,balance=" + pAll);
                                }
                            }
                        }else if(sc[i + 1] == '5'){
                            b = num.getaFive();
                            if(b <= 0){
                                System.out.println("E007:The goods sold out");
                            }else{
                                if(8 > pAll){
                                    System.out.println("E008:Lack of balance");
                                }else{
                                    pAll = pAll - 8;
                                    System.out.println("S003:Buy success,balance=" + pAll);
                                }
                            }
                        }else if(sc[i + 1] == '6'){
                            b = num.getaSix();
                            if(b <= 0){
                                System.out.println("E007:The goods sold out");
                            }else{
                                if(6 > pAll){
                                    System.out.println("E008:Lack of balance");
                                }else{
                                    pAll = pAll - 6;
                                    System.out.println("S003:Buy success,balance=" + pAll);
                                }
                            }
                        }else{
                            System.out.println("E006:Goods does not exist");
                        }
                    }else{
                        System.out.println("E006:Goods does not exist");
                    }
                    state = 0;
                    b = 0;
                }else if(state == 3){//c
                    num.setPAll(pAll);
                    tuibi(num);
                    pAll = num.getPAll();
                    state = 0;
                }else if(state == 4){//q
                    if(sc[i] != ' '){
                        System.out.print("E010:Parameter error");
                        state = 0;
                        q = 0;
                        i = i + 1;
                    }
                    if(i + 1 >= nb){
                        break;
                    }
                    if(sc[i + 1] == ';'){
                        q = q * 10 + sc[i] - '0';
                        if(q == 0){
                            System.out.println("A1 2 " + num.getaOne());
                            System.out.println("A2 3 " + num.getaTwo());
                            System.out.println("A3 4 " + num.getaThree());
                            System.out.println("A4 5 " + num.getaFour());
                            System.out.println("A5 8 " + num.getaFive());
                            System.out.println("A6 6 " + num.getaSix());
                        }else if(q == 1){
                            System.out.println("1 yuan coin number=" + num.getOne());
                            System.out.println("2 yuan coin number=" + num.getTwo());
                            System.out.println("5 yuan coin number=" + num.getFive());
                            System.out.println("10 yuan coin number=" + num.getTen());
                        }else{
                            System.out.println("E010:Parameter error");
                        }
                        state = 0;
                        q = 0;
                    }else{
                        q = q * 10 + sc[i] - '0';
                    }
                }
                i ++;
            }
        }
    }
    public static void tuibi(Num num){
        int pAll = num.getPAll();
        if(pAll > 0){
            int one = num.getOne();
            int two = num.getTwo();
            int five = num.getFive();
            int ten = num.getTen();
            int one1 = 0;
            int two1 = 0;
            int five1 = 0;
            int ten1 = 0;
            while(pAll > 0){
                if(pAll >= 10){
                    ten --;
                    pAll = pAll - 10;
                    ten1 ++;
                }else if(pAll >= 5){
                    five --;
                    pAll = pAll - 5;
                    five1 ++;
                }else if(pAll >= 2){
                    two --;
                    pAll = pAll - 2;
                    two1 ++;
                }else if(pAll >= 1){
                    one --;
                    pAll = pAll - 1;
                    one1 ++;
                }
                if(ten < 0){
                    one1 = 0;
                    two1 = 0;
                    five1 = 0;
                    ten1 = 0;
                    break;
                }else{
                    num.setTen(ten);
                }
                if(five < 0){
                    one1 = 0;
                    two1 = 0;
                    five1 = 0;
                    ten1 = 0;
                    break;
                }else{
                    num.setFive(five);
                }
                if(two < 0){
                    one1 = 0;
                    two1 = 0;
                    five1 = 0;
                    ten1 = 0;
                    break;
                }else{
                    num.setTwo(two);
                }
                if(one < 0){
                    one1 = 0;
                    two1 = 0;
                    five1 = 0;
                    ten1 = 0;
                    break;
                }else{
                    num.setOne(one);
                }
            }
            if(pAll == 0){
                System.out.println("1 yuan coin number=" + one1);
                System.out.println("2 yuan coin number=" + two1);
                System.out.println("5 yuan coin number=" + five1);
                System.out.println("10 yuan coin number=" + ten1);
                num.setPAll(0);
            }
        }else{
            System.out.print("E009:Work failure");
        }
    }
}

class Num{
    public int A1;

    public int A2;

    public int A3;

    public int A4;

    public int A5;

    public int A6;

    public int one;

    public int two;

    public int five;

    public int ten;

    public int pAll;

    public void setaOne(int A1){
        this.A1 = A1;
    }
    public int getaOne(){
        return A1;
    }
    public void setaTwo(int A2){
        this.A2 = A2;
    }
    public int getaTwo(){
        return A2;
    }
    public void setaThree(int A3){
        this.A3 = A3;
    }
    public int getaThree(){
        return A3;
    }
    public void setaFour(int A4){
        this.A4 = A4;
    }
    public int getaFour(){
        return A4;
    }
    public void setaFive(int A5){
        this.A5 = A5;
    }
    public int getaFive(){
        return A5;
    }
    public void setaSix(int A6){
        this.A6 = A6;
    }
    public int getaSix(){
        return A6;
    }
    public void setOne(int one){
        this.one = one;
    }
    public int getOne(){
        return one;
    }
    public void setTwo(int two){
        this.two = two;
    }
    public int getTwo(){
        return two;
    }
    public void setFive(int five){
        this.five = five;
    }
    public int getFive(){
        return five;
    }
    public void setTen(int ten){
        this.ten = ten;
    }
    public int getTen(){
        return ten;
    }

    public void setPAll(int pAll){
        this.pAll = pAll;
    }
    public int getPAll(){
        return pAll;
    }

}
