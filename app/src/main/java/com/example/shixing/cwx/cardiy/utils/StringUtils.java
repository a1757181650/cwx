package com.example.shixing.cwx.cardiy.utils;

import android.text.TextUtils;

import java.text.NumberFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 类说明： 字符串操作类
 */
public class StringUtils {
    /**
     * 判断给定字符串是否空白串。<br>
     * 空白串是指由空格、制表符、回车符、换行符组成的字符串<br>
     * 若输入字符串为null或空字符串，返回true
     *
     * @param input
     * @return boolean
     */
    public static boolean isBlank(String input) {
        if (input == null || "".equals(input)) {
            return true;
        }

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != ' ' && c != '\t' && c != '\r' && c != '\n') {
                return false;
            }
        }
        return true;
    }

    public static final String arrTest[] = {"[br]", "[/b]", "[/i]", "[/u]", "[/size]", "[/color]", "[/align]", "[/url]", "[/email]", "[/img]"};
    public static final String arrParam[] = {"\\[br\\]", "\\[b\\](.+?)\\[/b\\]", "\\[i\\](.+?)\\[/i\\]", "\\[u\\](.+?)\\[/u\\]", "\\[size=(.+?)\\](.+?)\\[/size\\]", "\\[color=(.+?)\\](.+?)\\[/color\\]", "\\[align=(.+?)\\](.+?)\\[/align\\]", "\\[url=(.+?)\\](.+?)\\[/url\\]", "\\[email=(.+?)\\](.+?)\\[/email\\]," + "\\[img=(.+?)\\](.+?)\\[/img\\]"};
    public static final String arrCode[] = {"<br>", "<b>$1</b>", "<i>$1</i>", "<u>$1</u>", "<font size=\"$1\">$2</font>", "<font color=\"$1\">$2</font>", "<div align=\"$1\">$2</div>", "<a href=\"$1\" target=\"_blank\">$2</a>", "<a href=\"email:$1\">$2</a>", "<img src=\"$1\" border=0>$2</img>"};

    public static int getInt(String content) {
        int intContent;
        try {
            intContent = Integer.parseInt(content);
        } catch (Exception e) {
            intContent = 0;
        }
        return intContent;
    }

    public static long getLong(String content) {
        long lngContent;
        try {
            lngContent = Long.parseLong(content);
        } catch (Exception e) {
            lngContent = 0L;
        }
        return lngContent;
    }

    /**
     * 将指定的对象转换为String类型
     *
     * @param curObject 传入对象参数
     * @return String
     */
    public static String getString(Object curObject) {
        if (null == curObject) {
            throw new NullPointerException("The input object is null.");
        } else {
            return curObject.toString();
        }
    }

    /**
     * 转换字符,用于替换提交的数据中存在非法数据:"'"
     */
    public static String replaceChar(String content) {
        String newstr = "";
        newstr = content.replaceAll("\'", "''");
        return newstr;
    }

    /**
     * 对标题""转换为中文“”采用对应转换
     */
    public static String replaceSymbol(String content) {
        int intPlaceNum = 0;
        int Num = 0;
        String strContent = content;
        while (true) {
            // 判断是否还存在"
            intPlaceNum = strContent.indexOf("\"");
            if (intPlaceNum < 0) {
                break;
            } else {
                if (Num % 2 == 0) {
                    strContent = strContent.replaceFirst("\"", "“");
                } else {
                    strContent = strContent.replaceFirst("\"", "”");
                }
                Num = Num + 1;
            }
        }
        return strContent;
    }

    /**
     * 替换HTML标记
     */
    public static String replaceCharToHtml(String content) {
        String strContent = content;
        strContent = strContent.replaceAll("<", "&lt;");
        strContent = strContent.replaceAll(">", "&gt;");
        strContent = strContent.replaceAll("\"", "&quot;");
        return strContent;
    }

    public static String replaceHtmlToChar(String content) {
        String strContent = content;
        strContent = strContent.replaceAll("&lt;", "<");
        strContent = strContent.replaceAll("&gt;", ">");
        strContent = strContent.replaceAll("&quot;", "\"");
        return strContent;
    }

    // 数据库替换
    public static String replaceCharToSql(String content) {
        String strContent = content;
        strContent = strContent.replaceAll("%", "\\\\%");
        return strContent;
    }

    public static String toHtmlValue(String value) {
        if (null == value) {
            return null;
        }
        char a = 0;
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < value.length(); i++) {
            a = value.charAt(i);
            switch (a) {
                // 双引号
                case 34:
                    buf.append("&#034;");
                    break;
                // &号
                case 38:
                    buf.append("&amp;");
                    break;
                // 单引号
                case 39:
                    buf.append("&#039;");
                    break;
                // 小于号
                case 60:
                    buf.append("&lt;");
                    break;
                // 大于号
                case 62:
                    buf.append("&gt;");
                    break;
                default:
                    buf.append(a);
                    break;
            }
        }
        return buf.toString();
    }

    /**
     * 标题中含有特殊字符替换 如:●▲@◎※ 主要在标题中使用
     */
    public static String replaceSign(String content) {
        String strContent = "";
        strContent = content.replaceAll("\\*", "");
        strContent = strContent.replaceAll("\\$", "");
        strContent = strContent.replaceAll("\\+", "");
        String arrStr[] = {":", "：", "●", "▲", "■", "@", "＠", "◎", "★", "※", "＃", "〓", "＼", "§", "☆", "○", "◇", "◆", "□", "△", "＆", "＾", "￣", "＿", "♂", "♀", "Ю", "┭", "①", "「", "」", "≮", "§", "￡", "∑", "『", "』", "⊙", "∷", "Θ", "の", "↓", "↑", "Ф", "~", "Ⅱ", "∈", "┣", "┫", "╋", "┇", "┋", "→", "←", "!", "Ж", "#"};
        for (int i = 0; i < arrStr.length; i++) {
            if ((strContent.indexOf(arrStr[i])) >= 0) {
                strContent = strContent.replaceAll(arrStr[i], "");
            }
        }

        return strContent;
    }

    /**
     * 替换所有英文字母
     */
    public static String replaceLetter(String content) {
        String strMark = "[^[A-Za-z]+$]";
        String strContent = "";
        strContent = content.replaceAll(strMark, "");
        return strContent;
    }

    /**
     * 替换所有数字
     */
    public static String replaceNumber(String content) {
        String strMark = "[^[0-9]+$]";
        String strContent = "";
        strContent = content.replaceAll(strMark, "");
        return strContent;
    }

    /**
     * 将/n转换成为回车<br>
     * ,空格转为&nbsp;
     */
    public static String replaceBr(String content) {
        if (content == null) {
            return "";
        }
        String strContent = "";

        // String strMark ="[/\n\r\t]";

        // strContent = content.replaceAll(strMark,"<br>");

        strContent = content.replaceAll("\n\r\t", "<br>");
        strContent = strContent.replaceAll("\n\r", "<br>");
        strContent = strContent.replaceAll("\r\n", "<br>");
        strContent = strContent.replaceAll("\n", "<br>");
        strContent = strContent.replaceAll("\r", "<br>");
        strContent = strContent.replaceAll(" ", "&nbsp;");
        return strContent;
    }

    /**
     * 清除所有<>标记符号 主要在搜索中显示文字内容 而不显示样式
     */
    public static String replaceMark(String content) {
        String strContent = "";
        String strMark = "<\\s*[^>]*>";
        strContent = content.trim();
        strContent = strContent.replaceAll("\"", "");
        strContent = strContent.replaceAll("\'", "");
        // 删除所有<>标记
        strContent = strContent.replaceAll(strMark, "");
        strContent = strContent.replaceAll("&nbsp;", "");
        strContent = strContent.replaceAll(" ", "");
        strContent = strContent.replaceAll("　", "");
        strContent = strContent.replaceAll("\r", "");
        strContent = strContent.replaceAll("\n", "");
        strContent = strContent.replaceAll("\r\n", "");
        return strContent;
    }

    /**
     * 清楚WOrd垃圾代码
     */
    public static String clearWord(String content) {
        String strContent = "";
        strContent = content.trim();
        strContent = strContent.replaceAll("x:str", "");
        // Remove Style attributes
        strContent = strContent.replaceAll("<(\\w[^>]*) style=\"([^\"]*)\"", "<$1");
        // Remove all SPAN tags
        strContent = strContent.replaceAll("<\\/?SPAN[^>]*>", "");
        // Remove Lang attributes
        strContent = strContent.replaceAll("<(\\w[^>]*) lang=([^ |>]*)([^>]*)", "<$1$3");
        // Remove Class attributes
        strContent = strContent.replaceAll("<(\\w[^>]*) class=([^ |>]*)([^>]*)", "<$1$3");
        // Remove XML elements and declarations
        strContent = strContent.replaceAll("<\\\\?\\?xml[^>]*>", "");
        // Remove Tags with XML namespace declarations: <o:p></o:p>
        strContent = strContent.replaceAll("<\\/?\\w+:[^>]*>", "");
        return strContent;
    }

    /**
     * 对组ID信息进行处理 转换为标准ID组 并过滤重复的信息
     */
    public static String checkTeamId(String teamId) {
        String strTeamId = "";
        String strTempId = "";
        String strTemp = "";
        String[] arrTeamId = teamId.split(",");
        for (int num = 0; num < arrTeamId.length; num++) {
            strTemp = arrTeamId[num].trim();
            if ((!strTemp.equals("")) && (!strTemp.equals("0"))) {
                if ((strTempId.indexOf("," + strTemp + ",")) >= 0) { // 表示已经保存过了
                } else {
                    if (strTeamId.equals("")) {
                        strTeamId = strTemp;
                        strTempId = strTempId + "," + strTemp + ",";
                        ;
                    } else {
                        strTeamId = strTeamId + "," + strTemp;
                        strTempId = strTempId + strTemp + ",";
                    }
                }
            }
        }
        return strTeamId;
    }

    /**
     * 对象转整数
     *
     * @param obj
     * @return 转换异常返回 0
     */
    public static int toInt(Object obj) {
        if (obj == null) {
            return 0;
        }
        return toInt(obj.toString(), 0);
    }

    /**
     * 字符串转整数
     */
    public static int toInt(String str, int defValue) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
        }
        return defValue;
    }

    /**
     * 字符串转整数
     */
    public static double toDouble(Object obj) {
        if (obj == null) {
            return 0;
        }
        return toDouble(obj.toString(), 0);
    }

    /**
     * 字符串转整数
     */
    public static double toDouble(String str, double defValue) {
        try {
            return Double.parseDouble(str);
        } catch (Exception e) {
        }
        return defValue;
    }

    public static String replaceUbb(String content) {
        String strContent = content;
        try {
            for (int num = 0; num < arrTest.length; num++) {
                if ((strContent.indexOf(arrTest[num])) >= 0) {
                    try {
                        strContent = strContent.replaceAll(arrParam[num], arrCode[num]);
                    } catch (Exception ex) {
                    }
                }
            }
        } catch (Exception e) {
            // System.out.println("UBB CODE 错误"+e);
        }
        return strContent;
    }

    /**
     * 判断传入的字符串如果为null则返回"",否则返回其本身
     *
     * @return String
     */
    public static String convertNull(String string, String instant) {
        return isNull(string) ? instant : string;
    }

    /**
     * {@link #convertNull(String, String)}
     *
     * @param string
     * @return String
     */
    public static String convertNull(String string) {
        return convertNull(string, "");
    }

    /**
     * 判断对象是否为空
     *
     * @param obj Object
     * @return boolean 空返回true,非空返回false
     */
    public static boolean isNull(Object obj) {
        return (null == obj);
    }

    /**
     * Description:判断字段空null <br>
     *
     * @param s
     * @return boolean
     */
    public static boolean isNull(String s) {
        if (s == null || "".equals(s.trim())) {
            return true;
        }

        return false;
    }

    /**
     * 获取百分比
     *
     * @param p1
     * @param p2
     * @return
     */
    public static String percent(double p1, double p2) {
        if (p2 == 0) {
            return "0.00%";
        }
        String str;
        double p3 = p1 / p2;
        NumberFormat nf = NumberFormat.getPercentInstance();
        nf.setMinimumFractionDigits(2);
        str = nf.format(p3);
        return str;
    }

    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }

    /**
     * @param str    原字符串
     * @param length 字符串达到多长才截取
     * @return
     */
    public static String subStringToPoint(String str, int length, String more) {

        String reStr = "";

        if (str.length() * 2 - 1 > length) {

            int reInt = 0;

            if (str == null)

            {
                return "";
            }

            char[] tempChar = str.toCharArray();

            for (int kk = 0; (kk < tempChar.length && length > reInt); kk++) {

                String s1 = str.valueOf(tempChar[kk]);

                byte[] b = s1.getBytes();

                reInt += b.length;

                reStr += tempChar[kk];

            }

            if (length == reInt || (length == reInt - 1)) {

                if (!reStr.equals(str)) {
                    reStr += more;
                }
            }

        } else {
            reStr = str;
        }
        return reStr;

    }

    // add 判断服务编码是否包含数字 工号：743 begin

    /**
     * 判断服务编码是否包含数字
     *
     * @param str 校验的数据
     * @return boolean true:是 False：否
     */
    public static boolean isExistNumber(String str) {
        // java自带函数去判断
        for (int i = str.length(); --i >= 0; ) {
            if (Character.isDigit(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    /**
     * 检测字符串是否不为空(null,"","null")
     *
     * @param s
     * @return 不为空则返回true，否则返回false
     */
    public static boolean notEmpty(String s) {
        return s != null && !"".equals(s) && !"null".equals(s);
    }

    /**
     * 检测字符串是否为空(null,"","null")
     *
     * @param s
     * @return 为空则返回true，不否则返回false
     */
    public static boolean isEmpty(String s) {
        return s == null || "".equals(s) || "null".equals(s);
    }

    /**
     * 字符串转换为字符串数组
     *
     * @param str        字符串
     * @param splitRegex 分隔符
     * @return
     */
    public static String[] str2StrArray(String str, String splitRegex) {
        if (isEmpty(str)) {
            return null;
        }
        return str.split(splitRegex);
    }

    /**
     * 用默认的分隔符(,)将字符串转换为字符串数组
     *
     * @param str 字符串
     * @return
     */
    public static String[] str2StrArray(String str) {
        return str2StrArray(str, ",\\s*");
    }

    /**
     * java去除html字符串中连续指定个数的&nbsp;为空
     *
     * @param str 字符串
     * @param num 空格数量
     * @return
     */
    public static String replaceHtmlBlank(String str, Integer num) {
        String dest = "";
        if (str != null) {
            Pattern p = Pattern.compile("/&nbsp;{" + num + ",}/");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }

    /**
     * java去除字符串中的空格、回车、换行符、制表符
     */
    public static String replaceBlank(String str) {
        String dest = "";
        if (str != null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }

    /**
     * java去除字符串中的多个空格、回车、换行符、制表符替换为单个空格
     */
    public static String replace2Blank(String str) {
        String dest = "";
        if (str != null) {
            Pattern p = Pattern.compile("\\s{1,}|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll(" ");
        }
        return dest;
    }

    /**
     * 去除html标记
     */
    public static String stripHtml(String value) {
        // remove html tags and space chars
        return value.replaceAll("<.[^<>]*?>", " ").replaceAll("/&nbsp;|&#160;", " ")
                // remove punctuation
                .replaceAll("[.(),;:!?%#$'\"_+=\\/\\-]*", " ");
    }

    public static boolean match(String value, String keyword) {// value指item文本，keyword指索引中的字符
        if (TextUtils.isEmpty(value) || TextUtils.isEmpty(keyword)) {// 两者都不能为空
            return false;
        }
        if (value.length() < keyword.length()) {// item中的文字长度不能小于索引列表中的字符长度
            return false;
        }
        int i = 0, j = 0;// i是对应value,j是对应keyword
        do {
            if (value.charAt(i) == keyword.charAt(j)) {
                i++;
                j++;
            }
            else if (j > 0) {
                break;
            }
            else {
                i++;
            }
        }
        while (i < value.length() && j < keyword.length());
        return (j == keyword.length()) ? true : false;
    }

}
