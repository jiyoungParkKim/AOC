package fr.istic.aoc.metronome.command;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class TurnOffLEDCmd implements Command {
	private Circle led;
	public TurnOffLEDCmd(Circle led) {
		this.led = led;
	}

	@Override
	public void execute() {
		led.setFill(Color.BLACK);
	}

}
