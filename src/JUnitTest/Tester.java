package JUnitTest;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import persistent.classes.IngredientType;
import persistent.classes.Recipe;
import persistent.classes.RecipeIngredients;
import persistent.classes.User;
import restApi.RestApi;

public class Tester {

//	@Test
//	public void test() {
//		assertTrue(RestApi.getInstance().login("thomas", "thomas")!=null);
//	}
//	@Test
//	public void test2() {
//		assertTrue(RestApi.getInstance().login("thomas", "bk")==null);
//	}
//	@Test
//	public void test3() {
//		assertTrue(RestApi.getInstance().addUser("blub12", "bvb123", "blub12@google.de", "mister", "test"));
//	}
//	@Test
//	public void findUser(){
//		User hoi = RestApi.getInstance().findUserById("simön12345");
//		System.out.println(hoi);
//	}
//
//	@Test
//	public void test4(){
//		assertTrue(RestApi.getInstance().getCountryList()!= null);
//	}
//	
//	@Test
//	public void addRecipe(){
//		Recipe newrec = new Recipe("hannes", "test", "blub", 10, "dsdsfkljadsf");
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
	
	
	@Test
	public void testAddIngredientstoRecipe(){
		IngredientType hoi = RestApi.getInstance().getAllIngredientType().get(2);
		RecipeIngredients recIN = new RecipeIngredients();
		recIN.addIngredient("1000 g", hoi);
		System.out.println(recIN.getIngredients().size());
		System.out.println(recIN.getQuantities().size());
		assertTrue(RestApi.getInstance().addIngredientToRecipe(2, recIN));
		
	}

}
