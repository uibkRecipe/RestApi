package restApi;

import static restApi.RestApiLib.doDelete;
import static restApi.RestApiLib.doGet;
import static restApi.RestApiLib.doPost;
import static restApi.RestApiLib.objectToJson;

import java.io.IOException;
import java.util.List;



import org.apache.http.client.ClientProtocolException;

import persistent.classes.City;
import persistent.classes.Country;
import persistent.classes.Ingredient;
import persistent.classes.IngredientType;
import persistent.classes.Rating;
import persistent.classes.Recipe;
import persistent.classes.RecipeIngredients;
import persistent.classes.Region;
import persistent.classes.User;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RestApi {

	private static final String URLBASE = "http://138.232.65.234:8080/RestServer/rest/manager/";

	private static RestApi instance;

	private RestApi() {
	}

	private static final ObjectMapper mapper = new ObjectMapper();

	public static RestApi getInstance() {
		if (instance == null) {
			instance = new RestApi();
		}
		return instance;
	}

	/****************************************************************
	 * 
	 * User Functionalities
	 * 
	 ****************************************************************/

	public User login(String username, String password) {
		String test = doGet(URLBASE + "login/" + username + "/" + password);
		System.out.println(test);
		User o = null;
		try {
			o = mapper.readValue(test, User.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
		return o;
	}

	public boolean addUser(String username, String password, String email,
			String firstname, String lastname, City city) {
		boolean ret = false;
		
		User newUser = new User(username, password, email, city); //new User(username, password, email, firstname, lastname);
		// byte[] foto = null;
		// File fi = new File("test.jpg");
		// try {
		// foto = Files.readAllBytes(fi.toPath());
		// } catch (IOException e2) {
		// // TODO Automatisch generierter Erfassungsblock
		// e2.printStackTrace();
		// }
		// newUser.setIsActive(1);
		// newUser.setFoto(foto);

		String userDataJSON = objectToJson(newUser);
		String response = doPost(URLBASE + "register", userDataJSON);
		System.out.println(response);
		try {
			ret = mapper.readValue(response, boolean.class);

		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ret;
	}

	public User findUserById(String userName) {
		String url = URLBASE + "findUser/" + userName;
		String json = doGet(url);
		User newUser = new User();
		try {
			newUser = mapper.readValue(json, User.class);
		} catch (Exception e) {
		}
		return newUser;

	}

	/****************************************************************
	 * 
	 * Country Functionalities
	 * 
	 ****************************************************************/

	public List<Country> getCountryList() {
		String json = doGet(URLBASE + "country");
		List<Country> countries = null;
		try {
			countries = mapper.readValue(json,
					new TypeReference<List<Country>>() {
					});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return countries;
	}

	public Country getCountryByCode(String countryCode) {
		String json = doGet(URLBASE + "countryByCode/" + countryCode);
		ObjectMapper mapper = new ObjectMapper();
		Country o = null;
		try {
			o = mapper.readValue(json, Country.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return o;
	}

	public List<String> findCountryByName(String countryName) {
		String json = doGet(URLBASE + "country/" + countryName);
		ObjectMapper mapper = new ObjectMapper();
		List<String> countries = null;
		try {
			countries = mapper.readValue(json,
					new TypeReference<List<String>>() {
					});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return countries;
	}

	public String findCountryCodeByName(String countryName) {
		String url = URLBASE + "countryCode/" + countryName;
		String json = doGet(url);
		ObjectMapper mapper = new ObjectMapper();
		String countryCode = null;
		try {
			countryCode = mapper.readValue(json, String.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return countryCode;
	}

	/*****************************************************************
	 * 
	 * City Functionalities
	 * 
	 *****************************************************************/

	public City findCityById(int cityId) {
		String url = URLBASE + "citybyID/" + cityId;
		String json = doGet(url);
		City c = null;
		try {
			c = mapper.readValue(json, City.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

	public List<City> findCityByName(String cityName) {
		String url = URLBASE + "citybyName/" + cityName;
		String json = doGet(url);
		List<City> cities = null;
		try {
			cities = mapper.readValue(json, new TypeReference<List<City>>() {
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cities;
	}

	public List<City> findCityByCountryAndRegion(String country, String region) {
		String url = URLBASE + "city/" + country + "/" + region;
		String json = doGet(url);
		List<City> cities = null;
		try {
			cities = mapper.readValue(json, new TypeReference<List<City>>() {
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cities;
	}
	
	public List<City> findCityByCountry(String country) {
		String url = URLBASE + "cityByCountry/" + country;
		String json = doGet(url);
		List<City> cities = null;
		try {
			cities = mapper.readValue(json, new TypeReference<List<City>>() {
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cities;	
	}

	/******************************************************************
	 * 
	 * Friends functionalities
	 * 
	 ******************************************************************/

	public List<String> getFriends(String username) {
		String url = URLBASE + "getFriends/" + username;
		String json = doGet(url);
		List<String> friends = null;
		try {
			friends = mapper.readValue(json, new TypeReference<List<String>>() {
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return friends;
	}

	public boolean addFriend(String username1, String username2) {
		boolean ret = false;
		String url = URLBASE + "addFriend/" + username2;
		String userDataJSON = objectToJson(username1);

		String response = doPost(url, userDataJSON);
		try {
			ret = mapper.readValue(response, boolean.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}

	public boolean deleteFriend(String username1, String username2) {
		boolean ret = false;
		String url = URLBASE + "deleteFriend/" + username1 + "/" + username2;
		String json = doDelete(url);
		try {
			ret = mapper.readValue(json, boolean.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;

	}
	

	public boolean existFriend(String username1, String username2) {
		String url = URLBASE + "existFriend/" + username1 +"/" +username2;
		String json = doGet(url);
		boolean ret = false;
		try {
			ret = mapper.readValue(json, boolean.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}

	/****************************************************************
	 * 
	 * Recipe functionalities
	 * 
	 ****************************************************************/

	 public boolean addRecipe(Recipe r) {
			boolean ret = false;
			String url = URLBASE + "addRecipe";
			String userDataJSON = objectToJson(r);
			String response = doPost(url, userDataJSON);
			try {
				ret = mapper.readValue(response, boolean.class);

			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return ret;
	 }
	 


	public boolean findRecipeByAutor(String author) {
		String url = URLBASE + "findRecipeByAuthor/" + author;
		String json = doGet(url);
		boolean ret = false;
		try {
			ret = mapper.readValue(json, boolean.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
	public boolean removeRecipe(String username, int recipeID){
		boolean ret = false;
		String url = URLBASE + "recipe/" + username + "/" + recipeID;
		String response = doDelete(url);
		try {
			ret = mapper.readValue(response, boolean.class);

		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ret;
}

	/***************************************************************
	 * 
	 * IngredientType manager
	 * 
	 ***************************************************************/
	public List<IngredientType> getAllIngredientType() {
		String test = doGet(URLBASE + "ingredientType");
		List<IngredientType> iTypes = null;
		try {
			iTypes = mapper.readValue(test,
					new TypeReference<List<IngredientType>>() {
					});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return iTypes;
	}

	public List<IngredientType> findIngredientByName(String ingredientname) {
		String url = URLBASE + "ingredientType" + ingredientname;
		String json = doGet(url);
		List<IngredientType> ingredients = null;
		try {
			ingredients = mapper.readValue(json, new TypeReference<List<IngredientType>>() {
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ingredients;
	}

	public boolean addIngredientType(IngredientType ingredientType) {
		boolean ret = false;
		String url = URLBASE + "addIngredientType";
		String userDataJSON = objectToJson(ingredientType);
		String response = doPost(url, userDataJSON);
		try {
			ret = mapper.readValue(response, boolean.class);

		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ret;
	}
	

	/***********************************************************
	 * 
	 * Composed Of
	 * 
	 ***********************************************************/
	public List<IngredientType> getIngredients(int recipeId) {
		String url = URLBASE + "ingredient/" + recipeId;
		String json = doGet(url);
		List<IngredientType> ingredients = null;
		try {
			ingredients = mapper.readValue(json, new TypeReference<List<IngredientType>>() {
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ingredients;
	}

//	public boolean findRezeptByIngredient() {
//		String test = doGet("http://138.232.65.234:8080/RestServer/rest/recipe/ingredients");
//		ObjectMapper mapper = new ObjectMapper();
//		boolean o = false;
//		try {
//			o = mapper.readValue(test, boolean.class);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return o;
//	}

	public boolean addIngredientToRecipe(int recipeID,
			RecipeIngredients recIngredients) {
		boolean ret = false;
		String url = URLBASE + "ingredient/" + recipeID;
		String userDataJSON = objectToJson(recIngredients);
		System.out.println(userDataJSON);
		String response = doPost(url, userDataJSON);
		System.out.println(response);
		try {
			ret = mapper.readValue(response, boolean.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}



	/****************************************************************
	 * 
	 * Ingredient
	 * 
	 ****************************************************************/

	public boolean addIngredient(Ingredient ingredient) {
		boolean ret = false;
		String url = URLBASE + "addIngredient";
		String userDataJSON = objectToJson(ingredient);
		String response = doPost(url, userDataJSON);
		try {
			ret = mapper.readValue(response, boolean.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
	

	/*****************************************************************
	 * 
	 * Rating
	 * 
	 *****************************************************************/

	public boolean addRating(Rating rating){
		boolean ret = false;
		String url = URLBASE + "addRating";
		String userDataJSON = objectToJson(rating);
		String response = doPost(url, userDataJSON);
		try {
			ret = mapper.readValue(response, boolean.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}

	/****************************************************************
	 * 
	 * Region
	 * 
	 *****************************************************************/

	public List<Region> getRegionByCountryCode(String countryCode) {
		String url = URLBASE + "region/" + countryCode;
		String json = doGet(url);
		List<Region> regions = null;
		try {
			regions = mapper.readValue(json, new TypeReference<List<Region>>() {
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return regions;
	}


	
}
