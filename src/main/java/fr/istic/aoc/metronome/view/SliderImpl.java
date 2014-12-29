package fr.istic.aoc.metronome.view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import fr.istic.aoc.metronome.command.Command;

public class SliderImpl implements Slider, FxComponentConverter{
	private javafx.scene.control.Slider fxSlider;
	private double position;
	private Command sliderChangedCmd;
	private int sliderValue = 0;
	private double maxSliderValue;
	
	public static SliderImpl build(){
		return new SliderImpl();
	}
	
	private SliderImpl(){}

	public SliderImpl setMaxSliderValue(double maxSliderValue) {
		this.maxSliderValue = maxSliderValue;
		return this;
	}

	@Override
	public SliderImpl setFxComponent(Object fxComponent) {
		this.fxSlider = (javafx.scene.control.Slider)fxComponent;
		this.position = calculPosition(fxSlider.getValue());//default value
		this.fxSlider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				if(sliderValue != newValue.intValue()){
					setSliderValue(newValue.intValue());
					setPosition(calculPosition(newValue.intValue()));
					sliderChangedCmd.execute();
				}
			}
		});
		return this;
	}
	
	private double calculPosition(double sliderValue){
		return sliderValue / maxSliderValue;
	}
	
	private void setSliderValue(int sliderValue) {
		this.sliderValue = sliderValue;
	}
	
	@Override
	public double getPosition() {
		return position;
	}
	@Override
	public void setPosition(double position) {
		this.position = position;
	}
	
	@Override
	public void speedDown() {
		this.fxSlider.setValue(this.fxSlider.getValue() -5);
	}
	
	@Override
	public void speedUp() {
		this.fxSlider.setValue(this.fxSlider.getValue() +5);
	}
	
	//////////// getter setter ///////////
	
	public Command getSliderChangedCmd() {
		return sliderChangedCmd;
	}
	
	/////////// observer ////////////
	
	@Override
	public Slider registerObserver(Command sliderChangedCmd) {
		this.sliderChangedCmd = sliderChangedCmd;
		return this;
	}
	
	@Override
	public void unregisterObserver(Command observer) {
		this.sliderChangedCmd = null;
	}
}
