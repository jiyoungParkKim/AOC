package fr.istic.aoc.metronome.adapter;

import fr.istic.aoc.metronome.material.Molette;
import fr.istic.aoc.metronome.ui.SliderType;
import fr.istic.aoc.metronome.utils.PropertiesReader;

public class MoletteAdapter implements Molette {
	
	private double[] positions = {140.0, 4.0};
	public MoletteAdapter(){
		
		PropertiesReader propReader = PropertiesReader.getReader("config.properties");
		double defaultBeats = propReader.getDouble("defaultBeats").doubleValue();
		double beatsSliderMaxValue = propReader.getDouble("beatsSliderMaxValue").doubleValue();
		positions[0] = defaultBeats / beatsSliderMaxValue;
		
		double defaultBar = propReader.getDouble("defaultBar").doubleValue();
		double barSliderMaxValue = propReader.getDouble("barSliderMaxValue").doubleValue();
		positions[1] = defaultBar / barSliderMaxValue;
		
	}

	@Override
	public double getPosition(int number) {
		return positions[number];
	}
	
	public void slideChanged(SliderType type, double position){
		positions[type.getValue()] = position;
	}
}
