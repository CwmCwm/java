package com.demo.grammar;
public class OuterClass{
    private float f=1.0f;

    private final class InnerClass{ }

    // public class InnerClass{  static float func(){return f;} }

    // class InnerClass{ public static float func(){return f;} }

    // abstract class InnerClass{ public abstract float func(){} }

    // static class InnerClass{ protected static float func(){return f;} }
}