package fr.istic.aoc.metronome.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javafx.scene.paint.Color;

/**
 * Property Reader with given .properties file path
 * @author Jiyoung Park
 *
 */
public class PropertyReader {
	
	private static Map<String, PropertyReader> propertyReaders = new HashMap<String, PropertyReader>();
	private static PropertyReader propertyReader;
	
	/**
	 * Return the PropertyReader by given resource path which used as a key.
	 * @param path
	 * @return
	 */
	public static PropertyReader getReader(String path){
		if(propertyReaders.get(path) == null){
			PropertyReader pr = new PropertyReader();
			Properties props = pr.load(path);
			if(props != null){
				propertyReaders.put(path, propertyReader);
			}
			return pr;
		}else{
			return propertyReaders.get(path);
		}
	}
	
	private Properties props;
	/**
	 * Loads the properties by given resource path.
	 * @param path
	 * @return
	 */
	public Properties load(String path){
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(path);
		props = new Properties();
		try {
			props.load(inputStream);
			return props;
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	/**
	 * Returns the existing String type data.
	 * @param key
	 * @return
	 */
	public String getString(String key) {
		return (String) props.get(key);
	}
	
	/**
	 * Returns the existing Double type data.
	 * @param key
	 * @return
	 */
	public Double getDouble(String key) {
		if(props.get(key) != null){
			return Double.valueOf((String)props.get(key));
		}
		return null;
	}
	
	/**
	 * Returns the existing Integer type data.
	 * @param key
	 * @return
	 */
	public Integer getInteger(String key){
		if(props.get(key) != null){
			return Integer.valueOf((String)props.get(key));
		}
		return null;
	}

	/**
	 * Returns the existing java-fx Color type data.
	 * @param key
	 * @return
	 */
	public Color getColor(String key) {
		if(props.get(key) != null){
			return Color.valueOf((String)props.get(key));
		}
		return null;
	}
}
