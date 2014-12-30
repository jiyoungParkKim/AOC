package fr.istic.aoc.metronome;

import java.beans.Introspector;
import java.lang.reflect.Field;

import fr.istic.aoc.metronome.command.BarChangedCmd;
import fr.istic.aoc.metronome.command.BarEventCmd;
import fr.istic.aoc.metronome.command.BeatEventCmd;
import fr.istic.aoc.metronome.command.BeatsChangedCmd;
import fr.istic.aoc.metronome.command.Command;
import fr.istic.aoc.metronome.material.Timer;
import fr.istic.aoc.metronome.material.TimerImpl;
import fr.istic.aoc.metronome.utils.PropertyReader;

/**
 * Concrete Metronome Engine class and it has a Subject role to the {@link fr.istic.aoc.metronome.EventHandlingController} class
 * @author Jiyoung Park
 *
 */
public class MEImpl implements ME {
	private PropertyReader props;
	private int beats = 140;// Default beats per minute
	private int bar = 4;// Default measure
	/**
	 * Flag for setting up the running mode
	 * tests.
	 */
	private boolean isRunning;
	private Timer timer;
	private int count = 0;
	private Command tickCmd;
	
	private BeatsChangedCmd beatsChangedCmd;
	private BarChangedCmd barChangedCmd;
	private BeatEventCmd beatEventCmd;
	private BarEventCmd barEventCmd;
	
	public static MEImpl build(){
		return new MEImpl();
	}
	
	private MEImpl(){
		timer = new TimerImpl();
		props = PropertyReader.getReader("config.properties");
		if(props != null){
			beats = props.getInteger("defaultBeats");
			bar = props.getInteger("defaultBar");
		}
	}
	
	@Override
	public void setBeats(int beats){
		this.beats = beats;
		beatsChangedCmd.execute();
		if(isRunning){
			timer.activatePeriodically(tickCmd, 60000/beats);
		}
	}
	
	@Override
	public void setBar(int bar) {
		this.bar = bar;
		barChangedCmd.execute();
	}
	
	@Override
	public void setRunning(boolean b) {
		isRunning = b;
		if(isRunning){
			count = 0;
			timer.activatePeriodically(tickCmd, 60000/beats);
		}else{
			timer.disable(null);
		}
	}
	
	@Override
	public void tick() {
		if(isRunning){
			beatEventCmd.execute();
			if((++count % bar) == 0){
				barEventCmd.execute();
			}
		}
	}
	
	@Override
	public void speedUp() {
		this.beats -= 5;
	}
	
	@Override
	public void speedDown() {
		this.beats += 5;
	}
	
	@Override
	public int getBar(){
		return bar;
	}
	
	@Override
	public int getBeats() {
		return beats;
	}

	////////////// observer /////////////	
	@Override
	public MEImpl registerObserver(Command observer) throws ConfigurationException{
		setObserver(Introspector.decapitalize(observer.getClass().getSimpleName()), observer);
		return this;
	}
	
	@Override
	public void unregisterObserver(Command observer) throws ConfigurationException{
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
		return isRunning;
	}
	/////////// getter ////////////
}
