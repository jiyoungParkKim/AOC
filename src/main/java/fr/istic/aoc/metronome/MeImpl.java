package fr.istic.aoc.metronome;

import java.beans.Introspector;
import java.lang.reflect.Field;

import fr.istic.aoc.metronome.command.Command;
import fr.istic.aoc.metronome.material.Horloge;
import fr.istic.aoc.metronome.material.Material;

public class MeImpl implements ME{
	
	private Command bpmChangedCmd;
	private Command measureChangedCmd;
	private Command bpmEventCmd;
	private Command measureEventCmd;
	private Command tickCmd = new TickCmd();
	
	private Horloge horloge = Material.getHorloge();
	
	private boolean running;
	private int bpm = 140;
	private int oldBpm = -1; 
	private int measure = 4;
	private int count = 0;
	
	
	private void start(){
		count = 0;
		horloge.activatePeriodically(tickCmd, 60000/bpm);
		running = true;
		oldBpm = bpm;
	}
	private void stop(){
		count = 0;
		horloge.disable(tickCmd);
		running = false;
		oldBpm = -1;
	}
	private void restart(){
		stop();
		start();
	}
	@Override
	public synchronized void setRunning(boolean b) {
		if(b){
			if(oldBpm != bpm){
				start();
			}
		}else{
			stop();
		}
	}
	
	
	public void tick() {
		bpmEventCmd.execute();
		if((++count % measure) == 0){
			measureEventCmd.execute();
		}
	}
	
	@Override
	public void setBPM(int bpm) {
		this.bpm = bpm;
		bpmChangedCmd.execute();
		if(running){
			restart();
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
		setBPM(--bpm);
	}
	
	@Override
	public void inc() {
		setBPM(++bpm);
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
	
	////////////////
	
	private class TickCmd implements Command{
		@Override
		public void execute() {
			tick();
		}
	}
}
