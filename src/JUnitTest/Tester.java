package JUnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import RestApi.RestApi;

public class Tester {

	@Test
	public void test() {
		assertFalse(RestApi.getInstance().login("simon", "simon"));
	}
	@Test
	public void test2() {
		assertTrue(RestApi.getInstance().login("simon", "simon"));
	}

}
