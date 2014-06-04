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
		assertTrue(RestApi.getInstance().addUser("bvb123", "bvb123", "hoi23@google.de", "mister", "test"));
	}
	
	@Test
	public void test4(){
		assertTrue(RestApi.getInstance().getCountryList()!= null);
	}

}
