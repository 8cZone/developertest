import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PasswordIdentifyTest {

	@Test
	void test() {
		//测试用例1：空的密码
		try {
			PasswordIdentify.identify(" ");
		}catch(NullPointerException expected) {
			assertEquals("Error: Password is NULL!", expected.getMessage());
		}
		
		//测试用例2：不合法的密码
		try {
			PasswordIdentify.identify("中文");
		}catch(IllegalArgumentException expected) {
			assertEquals("Error: Password is illegal", expected.getMessage());
		}
		
		//安全度为1的测试用例：
		int t[] = new int[7];
		t[0] = PasswordIdentify.identify("123456");
		t[1] = PasswordIdentify.identify("abcde");
		t[2] = PasswordIdentify.identify("$%^&*");
		//安全度为2的测试用例：
		t[3] = PasswordIdentify.identify("1a2b3c");
		t[4] = PasswordIdentify.identify("a@b#c$");
		t[5] = PasswordIdentify.identify("1$2%3^");
		//安全度为3的测试用例：
		t[6] = PasswordIdentify.identify("1a$%2b^*3c");
		
		//单元测试结果验证
		assertEquals(1, t[0]);
		assertEquals(1, t[1]);
		assertEquals(1, t[2]);
		assertEquals(2, t[3]);
		assertEquals(2, t[4]);
		assertEquals(2, t[5]);
		assertEquals(3, t[6]);
	}
}
