package fr.istic.aoc.metronome.anti_adapter;

import fr.istic.aoc.metronome.adapter.ClavierAdapter;
import fr.istic.aoc.metronome.command.Command;
import fr.istic.aoc.metronome.command.ReadCmd;
import fr.istic.aoc.metronome.material.Material;
import fr.istic.aoc.metronome.ui.Button;
import fr.istic.aoc.metronome.ui.ButtonType;

public class ButtonAdapter implements Button, AntiAdapter {
	
	private ButtonType type;
	private Command cmd;
	private ClavierAdapter clavier = (ClavierAdapter) Material.getClavier();
	
	
	public ButtonAdapter(ButtonType type, javafx.scene.control.Button fxButton){
		this.type = type;
		clavier.setMousePressedListener(type, fxButton);
		clavier.setMouseReleasedListener(type, fxButton);
		Material.getHorloge().activatePeriodically(new ReadCmd(this), 100);
	}

	@Override
	public void read() {
		if(clavier.touchePressed(type.getValue())){
			click();
		}
	}

	@Override
	public void setCommand(Command cmd) {
		this.cmd = cmd;
	}

	@Override
	public void click() {
		cmd.execute();
	}

}
