import org.apache.commons.lang3.StringUtils;

public class PasswordIdentify {
    /*
     * ѧ��������071730214 ����ε
     * 
     * �ж�һ������İ�ȫ�ȼ�(1�ͣ�2�У�3��)��
     * ������������֣���ĸ�ͷ��ţ�ÿ��һ���ַ���һ����
     * @���� str :����������ַ���
     */
    public static int identify(String str) {
        int level = 0;
        String matchStringNum = "0123456789";
        String matchStringLetter = "abcdefghijklmnopqrstuvwxyz";
        String matchStringCharacter = "`~!@#$%^&*()-_=+[]{};':\",./<>?\\|";
        String matchAll = matchStringNum + matchStringLetter + matchStringCharacter;
        //�ַ���Ϊ�գ���һ�� NullPointerException �쳣
        if (StringUtils.isBlank(str)) throw new NullPointerException("Error: Password is NULL!");
        //�ַ���������Ҫ�󣬶�һ�� IllegalArgumentException �쳣
        if (!StringUtils.containsOnly(str, matchAll)) throw new IllegalArgumentException("Error: Password is illegal");
        //�ַ���ÿ��һ�����͵��ַ�����ȫ��+1
        if (StringUtils.containsAny(str, matchStringNum)) level++;
        if (StringUtils.containsAny(str, matchStringLetter)) level++;
        if (!StringUtils.containsAny(str, matchStringCharacter)) level++;
        //�����ʾ�ַ����İ�ȫ��
        printLevel(str, level);
        return level;
    }

    private static void printLevel(String str, int level) {
        System.out.println("\"" + str + "\" 's safty value is " + level);
    }
}
