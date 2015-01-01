package fr.istic.aoc.metronome.view;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import fr.istic.aoc.metronome.command.Command;
import fr.istic.aoc.metronome.material.Timer;
import fr.istic.aoc.metronome.material.TimerImpl;
import fr.istic.aoc.metronome.observer.Subject;
/**
 * Implementation of the LED interface containing a java-fx component and a command object 
 * which will be executed later. 
 * @author Jiyoung Park
 *
 */
public class LEDImpl implements LED, FxComponentConverter{
	
	private Circle fxCircle;
	private Timer timer;
	private Command observer;
	private Color color;
	
	public static LEDImpl build(){
		return new LEDImpl();
	}
	public LEDImpl(){
		timer = new TimerImpl();
	}
	@Override
	public LEDImpl setFxComponent(Object fxComponent) {
		this.fxCircle = (Circle) fxComponent;
		return this;
	}
	public LED setFillColor(Color color){
		this.color = color;
		return this;
	}

	@Override
	public void flash() {
		fxCircle.setFill(color);
		timer.activateAfterDelay(observer, 100);
	}
	
	//////// Observer ///////////////////////
	
	@Override
	public Subject registerObserver(Command observer) {
		this.observer = observer;
		return this;
	}
	@Override
	public void unregisterObserver(Command observer) {
		this.observer = null;
	}
}
