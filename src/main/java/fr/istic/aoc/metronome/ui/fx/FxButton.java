package fr.istic.aoc.metronome.ui.fx;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import fr.istic.aoc.metronome.command.Command;
import fr.istic.aoc.metronome.ui.Button;
import fr.istic.aoc.metronome.ui.ButtonType;

public class FxButton extends javafx.scene.control.Button implements Button{
	private ButtonType type;
	private Command cmd;
	private javafx.scene.control.Button btn;

	public FxButton(javafx.scene.control.Button btn) {
		this.btn = btn;
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				click();
			}
		});
	}
	
	public ButtonType getType() {
		return type;
	}

	public void setType(ButtonType type) {
		this.type = type;
	}

	public javafx.scene.control.Button getFxComponent(){
		return btn;
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
