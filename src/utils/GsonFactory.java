package utils;

import java.util.Arrays;
import java.util.List;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonFactory {

	private static Gson gson;

	public static Gson getInstance(Class<?>... excludingClass) {

		return gson = new GsonBuilder()

				.setExclusionStrategies(new ExclusionStrategy() {

					public boolean shouldSkipClass(Class<?> clazz) {
						List<Class<?>> classes = Arrays.asList(excludingClass);
						if (excludingClass == null)
							return false;
						else if (classes.contains(clazz))
							return true;
						else
							return false;
					}

					/**
					 * Custom field exclusion goes here
					 */
					public boolean shouldSkipField(FieldAttributes f) {
						return false;
					}

				})
				/**
				 * Use serializeNulls method if you want To serialize null
				 * values By default, Gson does not serialize null values
				 */
				// .serializeNulls()
				.create();

	}

}
