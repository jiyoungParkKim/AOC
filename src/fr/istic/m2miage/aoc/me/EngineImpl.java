package fr.istic.m2miage.aoc.me;

import java.util.Timer;
import java.util.TimerTask;

import fr.istic.m2miage.aoc.command.Command;
import fr.istic.m2miage.aoc.observer.EngineObserver;
import fr.istic.m2miage.aoc.observer.Subject;

public class EngineImpl implements Engine, Subject{
	
	private Command cmd;
	private boolean isRunning;
	private int tempo;
	private int beatsPerBar;
	
	private EngineObserver observer;

	public void setBeatCommand(final Command c) {

		this.isRunning = true;
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			  @Override
			  public void run() {
				  c.execute();
			  }
			}, 0, getTempo() * 1000);
		
	}

	public void setBarCommand(Command c) {
		this.cmd = c;
		this.cmd.execute();
	}

	public int getTempo() {
		return this.tempo;
	}

	public void setTempo(int t) {
		this.tempo = t;
		this.observer.update(this);
	}

	public int getBeatsPerBar(int b) {
		return this.beatsPerBar;
	}

	public void setRunning(boolean r) {
		this.isRunning = r;
	}

	public boolean getRunning() {
		return isRunning;
	}
	
	/////////// observer pattern //////////////
	public void register(EngineObserver o) {
		this.observer = observer;
	}

}
