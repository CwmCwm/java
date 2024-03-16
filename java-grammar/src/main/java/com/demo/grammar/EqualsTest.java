package com.demo.grammar;


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * equals 和 hashCode
 *
 * java对equals()的要求。有以下几点：
 *   1. 对称性：如果x.equals(y)返回是"true"，那么y.equals(x)也应该返回是"true"。
 *   2. 反射性：x.equals(x)必须返回是"true"。
 *   3. 类推性：如果x.equals(y)返回是"true"，而且y.equals(z)返回是"true"，那么z.equals(x)也应该返回是"true"。
 *   4. 一致性：如果x.equals(y)返回是"true"，只要x和y内容一直不变，不管你重复x.equals(y)多少次，返回都是"true"。
 *   5. 非空性，x.equals(null)，永远返回是"false"；x.equals(和x不同类型的对象)永远返回是"false"。
 *
 *
 * 规范定义（符合Java后续一些规范，形成自洽）
 * Object类就有equals方法和hashCode方法（见源码）
 *
 * 为什么重写 equals方法 时必须重写 hashCode方法？
 *   equals方法和hashCode方法没有直接关系，它们的关系是在将该对象放入Hash集合时才有关系。
 *   equals方法内不需要使用hashCode方法，重写equals方法的示例（见String的equals方法）
 *   hashCode方法的作用是获取哈希码，它实际上是返回一个int整数。就是只在需要hash时才会用，所以常见场景是将对象放入HashMap，Hashtable，HashSet。hashCode在散列表中才有用，在其它情况下没用。
 *     当你把对象加入 HashSet时，HashSet会先计算对象的 hashcode 值来判断对象加入的位置，同时也会与其他已经加入的对象的 hashcode 值作比较，
 *     如果没有相符的 hashcode，HashSet会假设对象没有重复出现。
 *     如果发现有相同 hashcode 值的对象，这时会调用equals()方法来检查 hashcode相等的对象是否真的相同。如果两者相同，HashSet就不会让其加入操作成功。如果不同的话，就会重新散列到其他位置。
 *     （见HashMap的put方法和HashSet的add方法）
 *
 */
public class EqualsTest {

    public static void main(String[] args) {
        A1 a1_1 = new A1(1, 1D, new BigDecimal("1"), "1");
        A1 a1_2 = new A1(1, 1D, new BigDecimal("1"), "1");
        System.out.println(a1_1.equals(a1_2));
        System.out.println(a1_1.hashCode());
        System.out.println(a1_2.hashCode());
        System.out.println("=================================");

        Set<A1> a1Set = new HashSet<>();
        a1Set.add(a1_1);
        a1Set.add(a1_2);
        for (A1 a1 : a1Set) {
            System.out.println(a1.hashCode());
        }
    }

    static class A1 {
        private Integer int1;
        private Double double1;
        private BigDecimal bigDecimal1;
        private String string1;

        public A1 (Integer int1, Double double1, BigDecimal bigDecimal1, String string1) {
            this.int1 = int1;
            this.double1 = double1;
            this.bigDecimal1 = bigDecimal1;
            this.string1 = string1;
        }

        //重写equals方法就要重写hashCode方法
        public boolean equals(Object anObject) {
            //对象的内存地址是同一个，那必然相等
            if (this == anObject) {
                return true;
            }

            //同一个类的实例
            if (anObject instanceof A1) {
                A1 anotherA1 = (A1)anObject;
                if (anotherA1.int1.equals(this.int1)
                        && anotherA1.double1.equals(this.double1)
                        && anotherA1.bigDecimal1.equals(this.bigDecimal1) ) {
                    return true;
                }
            }

            return false;
        }

        //不重写hashCode方法就用Object.hashCode方法（基于该对象内存地址的哈希值，两个不同内存地址的对象必然有不同的hashCode）
        //重写hashCode方法要求：
        //  如果两个对象相等equals返回true，那么它们的hashCode()值一定相同。
        //  如果两个对象hashCode相等，它们并不一定相等equals不一定返回true。
        public int hashCode() {
            //最简单的hashCode实现，就是将一个属性（Java已重写的类的hashCode）作为hashCode的实现
            //如这里上面4个属性都可以，当然也可以组合
            //return int1.hashCode();
            return int1.hashCode() ^ double1.hashCode() ^ bigDecimal1.hashCode() ^ string1.hashCode();
        }
    }

}
