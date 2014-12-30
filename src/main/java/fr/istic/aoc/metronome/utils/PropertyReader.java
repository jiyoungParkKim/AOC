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
	
	public String getString(String key) {
		return (String) props.get(key);
	}
	
	public Double getDouble(String key) {
		if(props.get(key) != null){
			return Double.valueOf((String)props.get(key));
		}
		return null;
	}
	
	public Integer getInteger(String key){
		if(props.get(key) != null){
			return Integer.valueOf((String)props.get(key));
		}
		return null;
	}

	public Color getColor(String key) {
		if(props.get(key) != null){
			return Color.valueOf((String)props.get(key));
		}
		return null;
	}
}
