package fr.istic.aoc.metronome.view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import fr.istic.aoc.metronome.command.Command;
/**
 *  Implementation of the Slider interface containing a java-fx component and a command object 
 *  which will be executed later.
 * @author Jiyoung Park
 *
 */
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

	/**
	 * Sets the max value of the slider object.
	 * @param maxSliderValue
	 * @return
	 */
	public SliderImpl setMaxSliderValue(double maxSliderValue) {
		this.maxSliderValue = maxSliderValue;
		return this;
	}

	/**
	 * Sets the value of the slider object.
	 * @param value
	 * @return
	 */
	public SliderImpl setValue(double value) {
		fxSlider.setValue(value);
		return this;
	}

	/**
	 * Sets the java-fx Slider component in this object to handle the event which will trigger executing the registered command.
	 */
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
	
	/**
	 * Calculates the position of the slider by current slider value and the max value.
	 * The result is between 0 and 1.
	 * @param sliderValue
	 * @return
	 */
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
	
	/**
	 * Adds by 5 the slider to up the bpm value.
	 */
	@Override
	public void speedDown() {
		this.fxSlider.setValue(this.fxSlider.getValue() -5);
	}
	
	/**
	 * Minus by 5 the slider to down the bpm value.
	 */
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
	public SliderImpl registerObserver(Command sliderChangedCmd) {
		this.sliderChangedCmd = sliderChangedCmd;
		return this;
	}
	
	@Override
	public void unregisterObserver(Command observer) {
		this.sliderChangedCmd = null;
	}
}
