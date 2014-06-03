package JUnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import RestApi.RestApi;

public class Tester {

	@Test
	public void test() {
		assertTrue(RestApi.getInstance().login("thomas", "thomas")!=null);
	}
	@Test
	public void test2() {
		assertTrue(RestApi.getInstance().login("thomas", "bk")==null);
	}
	@Test
	public void test3() {
		assertTrue(RestApi.getInstance().addUser("blub123", "blub", "simon@blub.com", "simon", "simon"));
	}

}
