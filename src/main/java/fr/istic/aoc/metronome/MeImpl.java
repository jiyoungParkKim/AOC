package fr.istic.aoc.metronome;

import java.beans.Introspector;
import java.lang.reflect.Field;

import fr.istic.aoc.metronome.command.BpmChangedCmd;
import fr.istic.aoc.metronome.command.BpmEventCmd;
import fr.istic.aoc.metronome.command.Command;
import fr.istic.aoc.metronome.command.MeasureChangedCmd;
import fr.istic.aoc.metronome.command.MeasureEventCmd;
import fr.istic.aoc.metronome.ui.Timer;
import fr.istic.aoc.metronome.ui.fx.TimerImpl;

public class MeImpl implements ME{
	
	private BpmChangedCmd bpmChangedCmd;
	private MeasureChangedCmd measureChangedCmd;
	private BpmEventCmd bpmEventCmd;
	private MeasureEventCmd measureEventCmd;
	private Command tickCmd;
	
	private Timer timer = new TimerImpl();
	
	private boolean running;
	private int bpm = 140;
	private int measure = 4;
	private int count = 0;
	
	@Override
	public void setRunning(boolean b) {
		running = b;
		if(running){
			count = 0;
			timer.activatePeriodically(tickCmd, 60000/bpm);
		}else{
			timer.disable(null);
		}
	}
	
	public void tick() {
		if(running){
			bpmEventCmd.execute();
			if((++count % measure) == 0){
				measureEventCmd.execute();
			}
		}		
	}
	
	@Override
	public void setBPM(int bpm) {
		this.bpm = bpm;
		bpmChangedCmd.execute();
		if(running){
			timer.activatePeriodically(tickCmd, 60000/bpm);
		}
	}
	
	@Override
	public int getMeasure() {
		return measure;
	}
	
	@Override
	public void setMeasure(int measure) {
		this.measure = measure;
		measureChangedCmd.execute();
	}
	
	@Override
	public int getBPM() {
		return bpm;
	}
	
	@Override
	public void dec() {
		bpm--;
	}
	
	@Override
	public void inc() {
		bpm++;
	}
	
	//////////////////////////////////////// Observer /////////////////////
	@Override
	public void register(Command observer) throws ConfigurationException{
		setObserver(Introspector.decapitalize(observer.getClass().getSimpleName()), observer);
	}
	
	@Override
	public void unRegister(Command observer) throws ConfigurationException{
		setObserver(Introspector.decapitalize(observer.getClass().getSimpleName()), null);
	}
	
	/**
	 * Sets the observer classes using the java reflection function.
	 * @param observerName
	 * @param observer
	 * @throws ConfigurationException 
	 */
	private void setObserver(String observerName, Command observer) throws ConfigurationException {
		try {
			Field field = this.getClass().getDeclaredField(observerName);
			field.setAccessible(true);
			field.set(this, observer);
		} catch (Exception  e) {
			throw new ConfigurationException("You can't register " + observerName + " because it is not vailed observer of this class.");
		} 
	}

	public boolean isRunning() {
		return running;
	}
	
}
