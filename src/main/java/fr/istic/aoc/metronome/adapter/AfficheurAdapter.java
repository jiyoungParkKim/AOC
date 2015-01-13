package fr.istic.aoc.metronome.adapter;

import javafx.scene.paint.Color;
import fr.istic.aoc.metronome.material.Afficheur;
import fr.istic.aoc.metronome.ui.LEDType;

public class AfficheurAdapter implements Afficheur{
	
	private javafx.scene.text.Text bpmText;
	private javafx.scene.text.Text measureText;
	private javafx.scene.text.Text tempoNameText;

	private javafx.scene.shape.Circle[] leds = new javafx.scene.shape.Circle[2];

	@Override
	public void turnOnLED(int numLED) {
		if(numLED == 0){
			leds[numLED].setFill(Color.LIMEGREEN);
		}else{
			leds[numLED].setFill(Color.PINK);
		}
	}

	@Override
	public void turnOffLED(int numLED) {
		leds[numLED].setFill(Color.BLACK);
	}

	@Override
	public void showBPM(String bpmValue) {
		bpmText.setText(bpmValue);
	}

	@Override
	public void showMeasure(String measureValue) {
		measureText.setText(measureValue);
	}

	@Override
	public void showTempoName(String tempoName) {
		tempoNameText.setText(tempoName);
	}

	public void setBpmText(javafx.scene.text.Text bpmText) {
		this.bpmText = bpmText;
	}

	public void setMeasureText(javafx.scene.text.Text measureText) {
		this.measureText = measureText;
	}

	public void setTempoNameText(javafx.scene.text.Text tempoNameText) {
		this.tempoNameText = tempoNameText;
	}

	public void setLED(LEDType ledType, javafx.scene.shape.Circle led){
		leds[ledType.getValue()] = led;
	}
}
