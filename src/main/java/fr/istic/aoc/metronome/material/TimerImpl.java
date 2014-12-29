package fr.istic.aoc.metronome.material;

import javafx.animation.Animation;
import javafx.animation.Animation.Status;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import fr.istic.aoc.metronome.command.Command;

public class TimerImpl implements Timer{
	private Timeline timeline;
	//private Timeline timeline2;
	public TimerImpl() {
		timeline = new Timeline();
	}

	@Override
	public void activatePeriodically(Command c, int delayInMillis) {
		if(timeline.getStatus() == Status.RUNNING) timeline.stop();
		timeline = new Timeline(new KeyFrame(
		        Duration.millis(delayInMillis),
		        ae -> c.execute()));
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
	}

	@Override
	public void activateAfterDelay(Command c, int delayInMillis) {
		if(timeline != null) timeline.stop();
		timeline = new Timeline(new KeyFrame(
		        Duration.millis(delayInMillis),
		        ae -> c.execute()));
		timeline.play();
	}

	@Override
	public void disable(Command c) {
		timeline.stop();
		if(c != null)
		c.execute();
	}

}
