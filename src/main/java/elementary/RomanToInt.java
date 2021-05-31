package elementary;

public class RomanToInt {
    /*
        罗马数字转整数
     */

    /*
        暴力解法
     */
    private int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                throw new IllegalArgumentException();
        }
    }
    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int result = 0,
                last = Integer.MAX_VALUE;
        for (char temp : chars) {
            int val = getValue(temp);
            result += val;
            if (last < val) {
                result -= last * 2;
            }
            last = val;
        }
        return result;
    }

}
