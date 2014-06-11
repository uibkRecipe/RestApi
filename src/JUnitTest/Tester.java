package JUnitTest;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import persistent.classes.City;
import persistent.classes.Country;
import persistent.classes.Region;
import restApi.RestApi;

public class Tester {

	@Test
	public void test() {
		assertTrue(RestApi.getInstance().login("hannes", "hannes")!=null);
	}
	@Test
	public void test2() {
		assertTrue(RestApi.getInstance().login("thomas", "bk")==null);
	}
//	@Test
//	public void test3() {
//		City c = RestApi.getInstance().findCityById(31731);
//		assertTrue(RestApi.getInstance().addUser("simon", "simon", "simon123@google.de", "mister", "test", c));
//	}
//	@Test
//	public void findUser(){
//		User hoi = RestApi.getInstance().findUserById("simön12345");
//		System.out.println(hoi);
//	}
//
//	@Test
//	public void test4(){
//		List<Country> countries = RestApi.getInstance().getCountryList();
//		for(Country c : countries)
//			System.out.println(c.getName());
//		
//	}
//	
//	@Test
//	public void addRecipe(){
//		Recipe newrec = new Recipe("simon", "test", "blub", 10, "dsdsfkljadsf");
//		assertTrue(RestApi.getInstance().addRecipe(newrec));
//	}
//	
//	@Test
//	public void delteRecipe(){
//		assertTrue(RestApi.getInstance().removeRecipe("hannes", 2));
//	}
//	
//	@Test
//	public void testgetAllIngredientType(){
//		List<IngredientType> blub = RestApi.getInstance().getAllIngredientType();
//		for (IngredientType ingredientType : blub) {
//			System.out.println(ingredientType);
//		}
//		assertTrue(blub.size()>0);
//		}
	
	
//	@Test
//	public void testAddIngredientstoRecipe(){
//		IngredientType hoi = RestApi.getInstance().getAllIngredientType().get(2);
//		RecipeIngredients recIN = new RecipeIngredients();
//		recIN.addIngredient("1000 g", hoi);
//		System.out.praaintln(recIN.getIngredients().size());
//		System.out.println(recIN.getQuantities().size());
//		assertTrue(RestApi.getInstance().addIngredientToRecipe(2, recIN));
//		
//	}
//	@Test
//	public void findCityByCountry (){
//		List<Country> countries = RestApi.getInstance().getCountryList();
//		List<City> city = new ArrayList<City>();
//		System.out.println(countries.get(1));
//		city = RestApi.getInstance().findCityByCountry("IT");
//		System.out.println(city);		
//		for(Country c : countries){
//			city.addAll(RestApi.getInstance().findCityByCountry(c.getCode()));
//		}
//		for (City city2 : city) {
//			System.out.println(city2);
//		}		
//	}
	
	@Test
	public void findRegionByCountryCode(){
		List<Region> regions = RestApi.getInstance().findRegionByCountryCode("IT");
		System.out.println(regions.size());
	}

}
