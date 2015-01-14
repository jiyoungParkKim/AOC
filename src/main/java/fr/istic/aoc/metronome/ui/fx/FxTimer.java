package fr.istic.aoc.metronome.ui.fx;

import java.util.HashMap;
import java.util.Map;

import javafx.animation.Animation;
import javafx.animation.Animation.Status;
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
public class FxTimer implements Timer{
	private static Timeline timeline;
	private static Timer timer;
	
	private Map<Integer, Integer> jobs = new HashMap<Integer, Integer>();
	
	public static Timer getInstance(){
		if(timer == null){
			timer = new FxTimer();
		}
		return timer;
	}
	
	protected FxTimer(){
		timeline = new Timeline();
	}
	
	private boolean verifyTimelineJobs(Command c, int delayInMillis){
		Integer index = jobs.get(c.hashCode());
		if(index != null){
			KeyFrame k = timeline.getKeyFrames().get(index);
			if(k.getTime().toMillis() == delayInMillis){
				return false;
			}else{
				return removeOneJob(c.hashCode());
			}
		}else{
			return true;
		}
	}
	
	private synchronized boolean removeOneJob(int jobKey){
		int curFCnt = timeline.getKeyFrames().size();
		int curJCnt = jobs.size();
		Integer index = jobs.get(jobKey);
		if(index != null){
			KeyFrame k = timeline.getKeyFrames().get(index);
			jobs.remove(jobKey);
			if(timeline.getStatus() == Status.RUNNING){
				timeline.stop();
			}
			timeline.getKeyFrames().remove(k);
			timeline.play();
			
			int jobSize = jobs.size();
			int fSize = timeline.getKeyFrames().size();
			
			boolean flag = (curFCnt - fSize) == 1 &&  (curJCnt - jobSize) == 1;
			return flag;
		}
		return false;
	}
	
	private synchronized boolean addOneJob(Command c, int delayInMillis){
		timeline.stop();
		KeyFrame k = new KeyFrame(
		        Duration.millis(delayInMillis),
		        ae -> c.execute());
		
		if(timeline.getKeyFrames().add(k)){
			
			jobs.put(c.hashCode(), timeline.getKeyFrames().size()-1);
			timeline.setCycleCount(Animation.INDEFINITE);
			timeline.play();
			return true;
		}
		return false;
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
	public  void  activatePeriodically(Command c, int delayInMillis) {
		boolean flag = verifyTimelineJobs(c, delayInMillis);
		if(flag){
			addOneJob(c, delayInMillis);
			
		}
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
	public  void activateAfterDelay(Command c, int delayInMillis) {
		KeyFrame k = new KeyFrame(
		        Duration.millis(delayInMillis),
		        ae -> c.execute());
		timeline.getKeyFrames().add(k);
		timeline.play();
	}

	/**
	 * Stop this timer
	 */
	@Override
	public  void disable(Command c) {
		if(c != null){
			removeOneJob(c.hashCode());
		}
	}
	
	
}
