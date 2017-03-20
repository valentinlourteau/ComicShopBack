//package utils;
//
//import java.beans.IntrospectionException;
//import java.lang.reflect.Field;
//import java.lang.reflect.InvocationTargetException;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import fr.klee.cv.api.config.ApiAttribute;
//import fr.klee.cv.api.config.JSONObject;
//import fr.klee.cv.api.config.JSONParser;
//import fr.klee.cv.api.config.Logger;
//import fr.klee.cv.api.config.MapperEntity;
//import fr.klee.cv.api.config.NestedNullException;
//
//public class MapperEntity {
//	
//	private static final String SEPARATOR = "\\.";
//
//	/**
//	 * Methode pour mapper un objet vers un objet Json
//	 * 
//	 * @param obj
//	 * @return
//	 */
//
//	public JSONObject mapperEntityToJson(Object obj) {
//
//		JSONObject objJson = new JSONObject();
//		List<Field> fields = new ArrayList<Field>(Arrays.asList(obj.getClass().getFields()));
//		try {
//			for (Field field : fields) {
//
//
//					String targetAttribut = !field.getAnnotation(ApiAttribute.class).targeAttribute()
//							.equalsIgnoreCase("")
//									? field.getName() + "." + field.getAnnotation(ApiAttribute.class).targeAttribute()
//									: field.getName();
//					String name = !field.getAnnotation(ApiAttribute.class).name().equalsIgnoreCase("")
//							? field.getAnnotation(ApiAttribute.class).name() : field.getName();				
//
//			}
//		} catch (SecurityException e) {
//			logger.error("NoSuchFieldException");
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			logger.error("IllegalAccessException");
//			e.printStackTrace();
//		} catch (InvocationTargetException e) {
//			logger.error("InvocationTargetException");
//			e.printStackTrace();
//		} catch (NoSuchMethodException e) {
//			logger.error("NoSuchMethodException");
//			e.printStackTrace();
//		}
//		return objJson;
//	}
//
//	public List<JSONObject> mapperEntityListToJson(List<Object> obj)
//			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException,
//			NoSuchFieldException, SecurityException, NoSuchMethodException {
//		List<JSONObject> jsonObjet = new ArrayList<JSONObject>();
//		for (Object objIter : obj) {
//			jsonObjet.add(mapperEntityToJson(objIter));
//		}
//		return jsonObjet;
//	}
//
//	/**
//	 * Methode pour mapper un objet json a un objet java
//	 * 
//	 * @param jsonEntity
//	 * @param typeClasse
//	 * @return
//	 */
//
//	public Object getObjectEntity(String jsonEntity, final Class<?> typeClasse) {
//
//		JSONParser parser = new JSONParser();
//
//		try {
//
//			JSONObject json = (JSONObject) parser.parse(jsonEntity);
//			Object entityObject = ClassUtils.getClass(typeClasse.getCanonicalName()).newInstance();
//			final List<Field> fields = getFieldWithoutConstraint(entityObject.getClass());
//
//			json.forEach((k, v) -> {
//				try {
//
//					Field field = getByName((String) k, fields);
//
//					if (field != null) {
//
//						if (field.getAnnotation(ApiAttribute.class).targeAttribute().equalsIgnoreCase("")) {
//
//							BeanUtils.setProperty(entityObject, field.getName(), v);
//
//						} else {
//
//							String[] filedMapping = field.getAnnotation(ApiAttribute.class).targeAttribute()
//									.split(SEPARATOR);
//							/*
//							 * si la taille du nom == 2 => un fild dans un objet
//							 * simple
//							 */
//							Field fieldTemp = field;
//							Object tmps = null;
//
//							if (filedMapping.length == 1) {
//
//								tmps = ClassUtils.getClass(field.getType().getCanonicalName()).newInstance();
//								BeanUtils.setProperty(tmps, filedMapping[filedMapping.length - 1], v);
//								BeanUtils.setProperty(entityObject, field.getName(), tmps);
//
//							} else {
//								/*
//								 * cas ou on a des objets a l'interieur des
//								 * objets
//								 */
//								Map<String, Object> objects = new HashMap<String, Object>();
//								//List<Field> listFielCopositeTmp = getFieldWithoutConstraint(field.getClass());
//
//								for (int i = 0; i < filedMapping.length - 1; i++) {
//									tmps = ClassUtils.getClass(fieldTemp.getType().getCanonicalName()).newInstance();
//									objects.put(filedMapping[i], tmps);
//									fieldTemp = getByName(filedMapping[i + 1],
//											getFieldWithoutConstraint(tmps.getClass()));
//								}
//
//								BeanUtils.setProperty(objects.get(filedMapping[filedMapping.length - 2]),
//										filedMapping[filedMapping.length - 1], v);
//
//								for (int i = 0; i < filedMapping.length - 2; i++) {
//									BeanUtils.setProperty(objects.get(filedMapping[i]), filedMapping[i + 1],
//											objects.get(filedMapping[i + 1]));
//								}
//								BeanUtils.setProperty(entityObject, field.getName(), objects.get(filedMapping[0]));
//							}
//
//						}
//					}
//				} catch (Exception e) {
//					if (!((String) k).equalsIgnoreCase("token")) {
//						e.printStackTrace();
//					}
//
//				}
//
//			});
//
//			return entityObject;
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			logger.error("ERREUR parse -");
//		}
//
//		return null;
//	}
//
//	public Field getByName(String nameField, List<Field> fields) {
//		for (Field field : fields) {
//			if (field.getName().equalsIgnoreCase(nameField) || (field.isAnnotationPresent(ApiAttribute.class)
//					&& field.getAnnotation(ApiAttribute.class).name().equalsIgnoreCase(nameField))) {
//				return field;
//			}
//		}
//		return null;
//	}
//
//	public List<Field> getFieldWithoutConstraint(Class<?> classType) {
//		List<Field> fields = FieldUtils.getAllFieldsList(classType);
//		for (Field field : fields) {
//			field.setAccessible(true);
//		}
//		return fields;
//	}
//
//	/**
//	 * Methode pour mapper des attributs json avec un objet deja instancié passe
//	 * en parametter
//	 * 
//	 * @param jsonEntity
//	 * @param object
//	 */
//	public void mappObjectWhithJsonField(String jsonEntity, Object object) {
//		JSONParser parser = new JSONParser();
//
//		try {
//
//			JSONObject json = (JSONObject) parser.parse(jsonEntity);
//			final List<Field> fields = getFieldWithoutConstraint(object.getClass());
//
//			json.forEach((k, v) -> {
//				try {
//
//					Field field = getByName((String) k, fields);
//
//					if (field != null && (json.get(field.getName()) != null
//							|| json.get(field.getAnnotation(ApiAttribute.class).name()) != null)) {
//
//						if (field.getAnnotation(ApiAttribute.class).targeAttribute().equalsIgnoreCase("")) {
//
//							BeanUtils.setProperty(object, field.getName(), v);
//
//						} else {
//
//							String[] filedMapping = field.getAnnotation(ApiAttribute.class).targeAttribute()
//									.split(SEPARATOR);
//							/*
//							 * si la taille du nom == 2 => un fild dans un objet
//							 * simple
//							 */
//							Field fieldTemp = field;
//							Object tmps = null;
//
//							if (filedMapping.length == 1) {
//
//								tmps = ClassUtils.getClass(field.getType().getCanonicalName()).newInstance();
//								BeanUtils.setProperty(tmps, filedMapping[filedMapping.length - 1], v);
//								BeanUtils.setProperty(object, field.getName(), tmps);
//
//							} else {
//								/*
//								 * cas ou on a des objets a l'interieur des
//								 * objets
//								 */
//								Map<String, Object> objects = new HashMap<String, Object>();
//								//List<Field> listFielCopositeTmp = getFieldWithoutConstraint(field.getClass());
//
//								for (int i = 0; i < filedMapping.length - 1; i++) {
//									tmps = ClassUtils.getClass(fieldTemp.getType().getCanonicalName()).newInstance();
//									objects.put(filedMapping[i], tmps);
//									fieldTemp = getByName(filedMapping[i + 1],
//											getFieldWithoutConstraint(tmps.getClass()));
//								}
//
//								BeanUtils.setProperty(objects.get(filedMapping[filedMapping.length - 2]),
//										filedMapping[filedMapping.length - 1], v);
//
//								for (int i = 0; i < filedMapping.length - 2; i++) {
//									BeanUtils.setProperty(objects.get(filedMapping[i]), filedMapping[i + 1],
//											objects.get(filedMapping[i + 1]));
//								}
//								BeanUtils.setProperty(object, field.getName(), objects.get(filedMapping[0]));
//							}
//						}
//					}
//				} catch (Exception e) {
//					if (!((String) k).equalsIgnoreCase("token")) {
//						e.printStackTrace();
//					}
//				}
//			});
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			logger.error("ERREUR parse -");
//		}
//	}
//    
//	public String genJsonShemaForDoc(Object object){
//		String jsonShema=new String();
//		JSONObject objJson =  mapperEntityToJson(object);
//	    for (Object key : objJson.keySet()) {
//	        String keyStr = (String)key;
//	        jsonShema+="</br>\""+keyStr+"\":\"\"";
//	    }
//		return "{</br>"+jsonShema+"</br>}";
//	}
//}
