package fr.istic.aoc.metronome.anti_adapter;

import javafx.scene.shape.Circle;
import fr.istic.aoc.metronome.ConfigurationException;
import fr.istic.aoc.metronome.adapter.AfficheurAdapter;
import fr.istic.aoc.metronome.command.Command;
import fr.istic.aoc.metronome.material.Material;
import fr.istic.aoc.metronome.ui.LED;
import fr.istic.aoc.metronome.ui.LEDType;

public class LedAdapter implements LED {
	
	private AfficheurAdapter afficheur = (AfficheurAdapter)Material.getAfficheur();
	private LEDType type;
	private Command cmd;
	
	public LedAdapter(LEDType type, Circle led1) {
		this.type = type;
		afficheur.setLED(type, led1);
	}

	@Override
	public void register(Command cmd) throws ConfigurationException {
		this.cmd = cmd;
	}

	@Override
	public void unRegister(Command cmd) throws ConfigurationException {
		this.cmd = null;

	}

	@Override
	public void flash() {
		afficheur.turnOnLED(type.getValue());
		Material.getHorloge().activateAfterDelay(cmd, 100);
	}

}
