package fr.istic.aoc.metronome.ui.fx;

import java.util.Iterator;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import fr.istic.aoc.metronome.command.Command;
import fr.istic.aoc.metronome.ui.Timer;

/**
 * Implementation of the Timeline
 * @author Jiyoung Park
 *
 */
public class TimerImpl implements Timer{
	private static Timeline timeline;
	private static Timer timer;
	
	public static Timer getInstance(){
		if(timer == null){
			timer = new TimerImpl();
		}
		return timer;
	}
	
	private TimerImpl(){
		timeline = new Timeline();
	}

	/**
	 * Active the given command periodically.
	 * 
	 * @param c
	 * Command object
	 * @param delayInmillis
	 * Millisecond to indicate the delay time
	 */
	@Override
	public synchronized void  activatePeriodically(Command c, int delayInMillis) {
		timeline.getKeyFrames().add(new KeyFrame(
		        Duration.millis(delayInMillis),
		        c.getClass().getSimpleName(),
		        ae -> c.execute()));
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
	}

	/**
	 * Active the given command after specified delay time.
	 * 
	 * @param c
	 * Command object
	 * @param delayInmillis
	 * Millisecond to indicate the delay time
	 */
	@Override
	public synchronized void activateAfterDelay(Command c, int delayInMillis) {
		timeline.getKeyFrames().add(new KeyFrame(
		        Duration.millis(delayInMillis),
		        ae -> c.execute()));
		timeline.play();
	}

	/**
	 * Stop this timer
	 */
	@Override
	public synchronized void disable(Command c) {
		timeline.getKeyFrames().removeAll(timeline.getKeyFrames());
		timeline.stop();
		if(c != null)
		c.execute();
	}
	
	
}
