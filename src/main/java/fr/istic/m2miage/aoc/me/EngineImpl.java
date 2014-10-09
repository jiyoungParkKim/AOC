package fr.istic.m2miage.aoc.me;

import fr.istic.m2miage.aoc.command.Command;
import fr.istic.m2miage.aoc.command.StopCommand;
import fr.istic.m2miage.aoc.command.TickCommand;
import fr.istic.m2miage.aoc.ui.Timer;
import fr.istic.m2miage.aoc.ui.TimerImpl;

public class EngineImpl implements Engine{
	
	// properties of state
	private boolean isRunning;
	private int beat;
	private int beatsPerBar;
	// Commands
	private Command beatChangedCmd;
	private Command barChangedCmd;
	private Command turnOnCmd;
	private Command turnOffCmd;
	private Command beatCmd;
	private Command barCmd;
	// Timer
	private Timer timer;
	private int count = 0;
	
	public EngineImpl(){
		timer = new TimerImpl();
	}
	
	// Beat
	public int getBeat() {
		return beat;
	}
	public void setBeat(int beat) {
		this.beat = beat;
		beatChangedCmd.execute();
	}
	public Command getBeatChangedCmd() {
		return beatChangedCmd;
	}
	public void setBeatChangedCmd(Command beatChangedCmd) {
		this.beatChangedCmd = beatChangedCmd;
	}
	
	// Bar
	public int getBar() {
		return beatsPerBar;
	}
	public void setBar(int beatsPerBar) {
		this.beatsPerBar = beatsPerBar;
		this.barChangedCmd.execute();
	}
	public Command getBarChangedCmd() {
		return barChangedCmd;
	}
	public void setBarChangedCmd(Command barChangedCmd) {
		this.barChangedCmd = barChangedCmd;
	}	
	
	
	// running
	public boolean isRunning() {
		return isRunning;
	}
	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
		if(isRunning){
			Command cmd = new TickCommand(this);
			timer.activatePeriodically(cmd, beat/60);
		}else{
			timer.disable(new StopCommand(this));
		}
	}
	public void tick() {
		this.beatCmd.execute();
		count++;
		if((count % beatsPerBar) == 0){
			this.barCmd.execute();
		}
	}
	

	public Command getTurnOnCmd() {
		return turnOnCmd;
	}
	public void setTurnOnCmd(Command turnOnCmd) {
		this.turnOnCmd = turnOnCmd;
	}
	public Command getTurnOffCmd() {
		return turnOffCmd;
	}
	public void setTurnOffCmd(Command turnOffCmd) {
		this.turnOffCmd = turnOffCmd;
	}
	public void setBeatCmd(Command c) {
		this.beatCmd = c;
	}
	public void setBarCmd(Command c) {
		this.barCmd = c;
	}
	public int getBeatsPerBar(int b) {
		return beatsPerBar;
	}
	public boolean getRunning() {
		return isRunning;
	}

}
