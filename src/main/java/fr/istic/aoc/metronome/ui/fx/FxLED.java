package fr.istic.aoc.metronome.ui.fx;

import javafx.scene.paint.Color;
import fr.istic.aoc.metronome.ConfigurationException;
import fr.istic.aoc.metronome.command.Command;
import fr.istic.aoc.metronome.ui.LED;
import fr.istic.aoc.metronome.ui.Timer;

public class FxLED implements LED {
	
	private javafx.scene.shape.Circle component;
	private Command cmd;
	private  Color color;
	private Timer timer = TimerImpl.getInstance();
	
	public FxLED(javafx.scene.shape.Circle component, Color color){
		this.component = component;
		this.color = color;
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
	public void flash() {
		component.setFill(color);
		timer.activatePeriodically(cmd, 100);
	}

}
