package com.atguigu.p2.util;

import java.util.*;

/**
 *CMUtility工具类
 * 将不同的功能封装为方法，直接通过调用方法来使用功能。
 */
public class CMUtility {
    private static Scanner scanner = new Scanner(System.in);

    /**
    * @Description: 用于界面菜单的选择，读取键盘输入字符。
    * @Param: []
    * @return: char
    */
    public static char readMenuSelection() {
        char c;
        for ( ; ; ) {
            String str = readKeyBoard(1, false);
            c = str.charAt(0);
            if (c != '1' && c != '2' && c != '3' && c != '4' && c != '5') {
                System.out.println("选择错误，请重新输入：");
            } else break;

        }
        return c;
    }
    
    /**
    * @Description: 从键盘读取一个字符，并将其作为方法的返回值。
    * @Param: []
    * @return: char
    */
    public static char readChar() {
        String str = readKeyBoard(1, false);
        return str.charAt(0);
    }

    /**
    * @Description: 从键盘读取一个字符，并将其作为方法的返回值。
    * @Param: [defaultValue] 默认的返回值，对应用户不输入字符。
    * @return: char
    */
    public static char readChar(char defaultValue) {
        String str = readKeyBoard(1, true);
        return (str.length() == 0) ? defaultValue : str.charAt(0);
    }

    /**
    * @Description: 从键盘读取一个长度不超过 2 位的整数，并将其作为方法返回值。
    * @Param: []
    * @return: int
    */
    public static int readInt() {
        int n;
        for ( ; ; ) {
            String str = readKeyBoard(2, false);
            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.print("数字输入错误，请重新输入：");
            }
        }
        return n;
    }

    /**
    * @Description: 从键盘读取一个长度不超过 2 位的整数，并将其作为方法返回值。
    * @Param: [defaultValue] 默认的返回值，对应用户不输入字符。
    * @return: int
    */
    public static int readInt(int defaultValue) {
        int n;
        for ( ; ; ) {
            String str = readKeyBoard(2, true);
            if (str.equals("")) {
                return defaultValue;
            }
            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.print("数字输入错误，请重新输入：");
            }
        }
        return n;
    }

    /**
    * @Description: 从键盘读取一个长度不超过 limit 的字符串，并将其作为方法的返回值。
    * @Param: [limit] 最大长度。
    * @return: java.lang.String
    */
    public static String readString(int limit) {
        return readKeyBoard(limit, false);
    }

    /**
    * @Description: 从键盘读取一个长度不超过 limit 的字符串，并将其作为方法的返回值。
    * @Param: [limit, defaultValue] [最大长度，默认返回值]
    * @return: java.lang.String
    */
    public static String readString(int limit, String defaultValue) {
        String str = readKeyBoard(limit, true);
        return str.equals("") ? defaultValue : str;
    }

    /**
    * @Description: 用于确认选择的输入，并将其作为方法的返回值。
    * @Param: []
    * @return: char
    */
    public static char readConfirmSelection() {
        char c;
        for ( ; ; ) {
            String str = readKeyBoard(1, false).toUpperCase();
            c = str.charAt(0);
            if (c == 'Y' || c == 'N') {
                break;
            } else {
                System.out.print("选择错误，请重新输入：");
            }
        }
        return c;
    }

    private static String readKeyBoard(int limit, boolean blankReturn) {
        String line = "";
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.length() == 0) {
                if (blankReturn) return line;
                else continue;
            }
            if (line.length() < 1 || line.length() > limit) {
                System.out.println("输入长度（不大于" + limit + "）错误，请重新输入！");
                continue;
            }
            break;
        }
        return line;
    }
}
