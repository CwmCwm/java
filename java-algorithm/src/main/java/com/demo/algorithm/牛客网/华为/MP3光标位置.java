package com.demo.algorithm.牛客网.华为;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 https://www.nowcoder.com/practice/eaf5b886bd6645dd9cfb5406f3753e15?tpId=37&&tqId=21287&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking


 TODO  放着先
 * */
public class MP3光标位置 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Scanner sc = new Scanner(System.in);
        String str = null;
        while ((str = br.readLine()) != null) {
            String str2 = br.readLine();
            int num = Integer.parseInt(str);

            char[] array = str2.toCharArray();
            int current = 1;
            int start = 1;
            for (char one : array) {
                if (num <= 4) {
                    if(one == 'U') {
                        if(current == 1) {
                            current = num;
                        }else {
                            current--;
                        }

                    }
                    else if(one == 'D') {
                        if(current == num) {
                            current = 1;
                        }else {
                            current++;
                        }

                    }
                }
                if(num > 4) {
                    if(one == 'U') {
                        if(current == 1) {
                            current = num;
                            start = num-3;
                        }else if(current == start) {
                            current--;
                            start--;
                        }else {
                            current--;
                        }
                    }else if(one == 'D') {
                        if(current == num) {
                            current = 1;
                            start = 1;
                        }else if(current == start+3) {
                            current++;
                            start++;
                        }else {
                            current++;
                        }
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            for(int i=1;i<=4;i++) {
                if(num >=i) {
                    sb.append(start + i -1).append(" ");
                }
            }
            System.out.println(sb.toString().trim());
            System.out.println(current);
        }
    }


}
