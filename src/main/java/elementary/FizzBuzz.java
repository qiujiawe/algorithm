package elementary;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    /*
        Fizz Buzz
            写一个程序，输出从 1 到 n 数字的字符串表示。

            1. 如果n是3的倍数，输出“Fizz”；

            2. 如果n是5的倍数，输出“Buzz”；

            3.如果n同时是3和5的倍数，输出 “FizzBuzz”。
     */

    /*
        暴力解法
     */
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                result.add("FizzBuzz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else {
                result.add(String.valueOf(i));
            }
        }
        return result;
    }

    /*
        大佬解法
     */
    public List<String> fizzBuzz1(int n) {
        return new AbstractList<>() {
            @Override
            public String get(int index) {
                int val = index + 1;
                switch ((val % 5 == 0 ? 1 : 0) + (val % 3 == 0 ? 2 : 0)) {
                    case 1:
                        return "Buzz";
                    case 2:
                        return "Fizz";
                    case 3:
                        return "FizzBuzz";
                    default:
                        return String.valueOf(val);
                }
            }

            @Override
            public int size() {
                return n;
            }
        };
    }

}
