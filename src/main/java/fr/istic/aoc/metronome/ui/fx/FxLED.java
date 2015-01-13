package fr.istic.aoc.metronome.ui.fx;

import javafx.scene.paint.Color;
import fr.istic.aoc.metronome.command.Command;
import fr.istic.aoc.metronome.ui.LED;
import fr.istic.aoc.metronome.ui.Timer;

public class FxLED implements LED {
	
	private javafx.scene.shape.Circle component;
	private Command cmd;
	private  Color color;
	private Timer timer = FxTimer.getInstance();
	
	public FxLED(javafx.scene.shape.Circle component, Color color){
		this.component = component;
		this.color = color;
		this.cmd = new TurnOffCmd();
	}

	@Override
	public void flash() {
		component.setFill(color);
		timer.activateAfterDelay(cmd, 100);
	}
	
	private class TurnOffCmd implements Command{
		@Override
		public void execute() {
			component.setFill(Color.BLACK);
		}
	}

}
