package JUnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import at.ac.uibk.recipe.api.RestApi;

public class Tester {

	@Test
	public void test() {
		assertTrue(RestApi.getInstance().login("hannes", "hannes")!=null);
	}
//	@Test
//	public void test2() {
//		assertTrue(RestApi.getInstance().login("thomas", "bk")==null);
//	}
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
//		IngredientType hoi = RestApi.getInstance().getAllIngredientType().get(0);
//		System.out.println(hoi);
//		RecipeIngredients recIN = new RecipeIngredients();
//		recIN.addIngredient("1000 g", hoi);
//		System.out.println(recIN.getIngredients().size());
//		System.out.println(recIN.getQuantities().size());
//		assertTrue(RestApi.getInstance().addIngredientToRecipe(3, recIN));
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
	
//	@Test
//	public void findRegionByCountryCode(){
//		List<Region> regions = RestApi.getInstance().findRegionByCountryCode("IT");
//		System.out.println(regions.get(5).getName());
//		for (Region region : regions) {
//			System.out.println(region);
//		}
//		List<City> cities = RestApi.getInstance().findCityByCountryAndRegion("IT", regions.get(16).getCode());
//		for(int i=0; i< cities.size(); i++)
//			System.out.println(i + " " +cities.get(i).toString());
////		for (City city : cities) {
////			System.out.println(city);
////		}
//	}
	
//	@Test
//	public void getAllRecipes(){
//		List<Recipe> recipes = RestApi.getInstance().getAllRecipes();
//		for (Recipe recipe : recipes) {
//			System.out.println(recipe);
//		}
//	}
//	
	@Test
	public void calculateCO2(){
		System.out.println(RestApi.getInstance().calculateCO2(3, "simon").getDistance());
	}
//	
//	@Test
//	public void getIngredient(){
//		System.out.println(RestApi.getInstance().getIngredients(3).getQuantities());
//	}
	
//	@Test
//	public void addIngredient(){
//		Ingredient ingredient = new Ingredient(3, 2000, "brot");
//		System.out.println(RestApi.getInstance().addIngredient(ingredient));
//		
//	}
//	@Test
//	public void changePassword(){
//		System.out.println(RestApi.getInstance().changePassword("hannes", "blub", "hannes", "hannes"));
//	}
}
