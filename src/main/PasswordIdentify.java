import org.apache.commons.lang3.StringUtils;

public class PasswordIdentify {
    /*
     * 学号姓名：071730214 潘绍蔚
     * 
     * 判断一个密码的安全等级(1低，2中，3高)。
     * 密码可以是数字，字母和符号，每有一种字符加一级。
     * @参数 str :输入的密码字符串
     */
    public static int identify(String str) {
        int level = 0;
        String matchStringNum = "0123456789";
        String matchStringLetter = "abcdefghijklmnopqrstuvwxyz";
        String matchStringCharacter = "`~!@#$%^&*()-_=+[]{};':\",./<>?\\|";
        String matchAll = matchStringNum + matchStringLetter + matchStringCharacter;
        //字符串为空，丢一个 NullPointerException 异常
        if (StringUtils.isBlank(str)) throw new NullPointerException("Error: Password is NULL!");
        //字符串不符合要求，丢一个 IllegalArgumentException 异常
        if (!StringUtils.containsOnly(str, matchAll)) throw new IllegalArgumentException("Error: Password is illegal");
        //字符串每有一种类型的字符，安全度+1
        if (StringUtils.containsAny(str, matchStringNum)) level++;
        if (StringUtils.containsAny(str, matchStringLetter)) level++;
        if (!StringUtils.containsAny(str, matchStringCharacter)) level++;
        //输出显示字符串的安全度
        printLevel(str, level);
        return level;
    }

    private static void printLevel(String str, int level) {
        System.out.println("\"" + str + "\" 's safty value is " + level);
    }
}
