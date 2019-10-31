import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PasswordIdentifyTest {

	@Test
	void test() {
		//��������1���յ�����
		try {
			PasswordIdentify.identify(" ");
		}catch(NullPointerException expected) {
			assertEquals("Error: Password is NULL!", expected.getMessage());
		}
		
		//��������2�����Ϸ�������
		try {
			PasswordIdentify.identify("����");
		}catch(IllegalArgumentException expected) {
			assertEquals("Error: Password is illegal", expected.getMessage());
		}
		
		//��ȫ��Ϊ1�Ĳ���������
		int t[] = new int[7];
		t[0] = PasswordIdentify.identify("123456");
		t[1] = PasswordIdentify.identify("abcde");
		t[2] = PasswordIdentify.identify("$%^&*");
		//��ȫ��Ϊ2�Ĳ���������
		t[3] = PasswordIdentify.identify("1a2b3c");
		t[4] = PasswordIdentify.identify("a@b#c$");
		t[5] = PasswordIdentify.identify("1$2%3^");
		//��ȫ��Ϊ3�Ĳ���������
		t[6] = PasswordIdentify.identify("1a$%2b^*3c");
		
		//��Ԫ���Խ����֤
		assertEquals(1, t[0]);
		assertEquals(1, t[1]);
		assertEquals(1, t[2]);
		assertEquals(2, t[3]);
		assertEquals(2, t[4]);
		assertEquals(2, t[5]);
		assertEquals(3, t[6]);
	}
}
