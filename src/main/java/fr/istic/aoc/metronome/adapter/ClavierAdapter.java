package fr.istic.aoc.metronome.adapter;

import fr.istic.aoc.metronome.material.Clavier;
import fr.istic.aoc.metronome.ui.ButtonType;

public class ClavierAdapter implements Clavier{
	
	private boolean[] flags = {false, false, false, false};
	
	public void mousePresed(ButtonType buttontype){
		flags[buttontype.getValue()] = true;
	}
	public void mouseReleased(ButtonType buttontype){
		flags[buttontype.getValue()] = false;
	}
	@Override
	public boolean touchePressed(int number) {
		return flags[number];
	}

}
