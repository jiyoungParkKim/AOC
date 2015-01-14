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
	
	/**
	 * Command class's hashcode , KeyFrame's index
	 */
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
	
	/**
	 * Verifies the KeyFrames is clean. If the same task(command) is found in the KeyFrames with a different time
	 * duration, remove it to make the timeline ready to add a new task.
	 * @param c Command to execute
	 * @param delayInMillis time duration
	 * @return true if the KeyFrame is clean
	 */
	private boolean verifyTimelineJobs(Command c, int delayInMillis){
		Integer index = jobs.get(c.hashCode());
		if(index != null){
			KeyFrame k = timeline.getKeyFrames().get(index);
			if(k.getTime().toMillis() == delayInMillis){
				return false;// This task is already exist in the timeline with same duration
			}else{
				return removeOneJob(c.hashCode());// Remove this task to replace it with a new duration
			}
		}else{// No same task so we are ready to add a new one
			return true;
		}
	}
	
	/**
	 * Removes a command(job) from the KeyFrame and the jobs.
	 * @param jobKey command's hashcode. 
	 * @return true if the job(command) is removed safely
	 */
	private synchronized boolean removeOneJob(int jobKey){
		int curFCnt = timeline.getKeyFrames().size();
		int curJCnt = jobs.size();
		Integer keyFrameIndex = jobs.get(jobKey);
		if(keyFrameIndex != null){
			KeyFrame k = timeline.getKeyFrames().get(keyFrameIndex);
			jobs.remove(jobKey);
			if(timeline.getStatus() == Status.RUNNING){
				timeline.stop();
			}
			timeline.getKeyFrames().remove(k);
			timeline.play();
			
			int jobSize = jobs.size();
			int fSize = timeline.getKeyFrames().size();
			
			return (curFCnt - fSize) == 1 &&  (curJCnt - jobSize) == 1;
		}
		return false;
	}
	
	/**
	 * Add a new task on the KeyFrame
	 * @param c
	 * @param delayInMillis
	 * @return
	 */
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
	 * Removes the given command from the jobs and the KeyFrames
	 */
	@Override
	public  void disable(Command c) {
		if(c != null){
			removeOneJob(c.hashCode());
		}
	}
	
	
}
