package fr.istic.aoc.metronome.adapter;

import fr.istic.aoc.metronome.material.EmetteurSonore;
import fr.istic.aoc.metronome.ui.BeeperImpl;
import fr.istic.aoc.metronome.ui.BeeperType;

public class EmetteurSonoreAdapter implements EmetteurSonore{
	
	BeeperImpl beeper1 = new BeeperImpl("PingLow.wav");
	BeeperImpl beeper2 = new BeeperImpl("PingHi.wav");

	@Override
	public void emettreClick(BeeperType type) {
		switch (type) {
		case BEEP1:
			beeper1.beep();
			break;

		case BEEP2:
			beeper2.beep();
			break;
		}
		
	}

}
