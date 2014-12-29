package fr.istic.aoc.metronome.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import fr.istic.aoc.metronome.command.Command;

public class ButtonImpl implements Button, FxComponentConverter{
	private Command cmd;
	
	public static ButtonImpl build(){
		return new ButtonImpl();
	}
	private ButtonImpl(){}
	@Override
	public ButtonImpl setCommand(Command cmd) {
		this.cmd = cmd;
		return this;
	}
	
	@Override
	public ButtonImpl setFxComponent(Object fxComponent) {
		((javafx.scene.control.Button) fxComponent).setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				click();
			}
		});
		return this;
	}

	@Override
	public void click() {
		cmd.execute();
	}
}
