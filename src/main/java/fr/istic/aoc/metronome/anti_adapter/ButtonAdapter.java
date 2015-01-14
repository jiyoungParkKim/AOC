package fr.istic.aoc.metronome.anti_adapter;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
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
		fxButton.setOnMousePressed(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				clavier.mousePresed(type);
			}
		});
		fxButton.setOnMouseReleased(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				clavier.mouseReleased(type);
			}
		});
		Material.getHorloge().activatePeriodically(new ReadCmd(this), 10);
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
