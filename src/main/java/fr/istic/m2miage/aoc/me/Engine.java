package fr.istic.m2miage.aoc.me;

import fr.istic.m2miage.aoc.command.Command;

public interface Engine {
	// beat
	public int getBeat();
	public void setBeat(int t);
	public void setBeatCmd(Command c);
	public void setBeatChangedCmd(Command c);
	
	// bar
	public int getBar();
	public void setBar(int b);
	public void setBarCmd(Command c);
	public void setBarChangedCmd(Command c);
	
	
	
	public void setRunning(boolean r);
	public boolean getRunning();
	
	
	public void tick();
	
}
