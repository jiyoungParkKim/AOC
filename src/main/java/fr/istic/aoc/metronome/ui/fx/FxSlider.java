package fr.istic.aoc.metronome.ui.fx;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import fr.istic.aoc.metronome.ConfigurationException;
import fr.istic.aoc.metronome.command.Command;
import fr.istic.aoc.metronome.ui.Slider;

public class FxSlider implements Slider {
	private Command cmd;
	private double position;
	
	public FxSlider(javafx.scene.control.Slider fxSlider){
		double max = fxSlider.getMax();
		position = fxSlider.getValue() / max;
		fxSlider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				position = newValue.doubleValue() / max;
				cmd.execute();
			}
		});
	}
	
	
	@Override
	public void register(Command cmd) throws ConfigurationException {
		this.cmd = cmd;
	}

	@Override
	public void unRegister(Command cmd) throws ConfigurationException {
		this.cmd = null;
	}

	@Override
	public double getPosition() {
		return position;
	}

	@Override
	public void setPosition(int position) {
		this.position = position;
	}

}
