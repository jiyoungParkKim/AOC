package fr.istic.aoc.metronome.anti_adapter;

import fr.istic.aoc.metronome.material.EmetteurSonore;
import fr.istic.aoc.metronome.material.Material;
import fr.istic.aoc.metronome.ui.Beeper;
import fr.istic.aoc.metronome.ui.BeeperType;

public class BeeperAdapter implements Beeper{
	private BeeperType type;
	private EmetteurSonore emetteur = Material.getemetteurSonore();
	public BeeperAdapter(BeeperType type){
		this.type = type;
	}


	@Override
	public void beep() {
		emetteur.emettreClick(type);
	}

}
