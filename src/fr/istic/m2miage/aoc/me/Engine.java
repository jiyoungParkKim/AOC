package fr.istic.m2miage.aoc.me;

import fr.istic.m2miage.aoc.command.Command;

public interface Engine {
	public void setBeatCommand(Command c);
	public void setBarCommand(Command c);
	public int getTempo();
	public void setTempo(int t);
	public int getBeatsPerBar(int b);
	public void setRunning(boolean r);
	public boolean getRunning();
}
