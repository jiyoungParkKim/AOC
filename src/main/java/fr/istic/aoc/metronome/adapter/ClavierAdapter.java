package fr.istic.aoc.metronome.adapter;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import fr.istic.aoc.metronome.material.Clavier;
import fr.istic.aoc.metronome.ui.ButtonType;

public class ClavierAdapter implements Clavier{
	
	private boolean[] flags = {false, false, false, false};
	
	public void setMousePressedListener(ButtonType buttontype, javafx.scene.control.Button fxButton){
		fxButton.setOnMousePressed(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				flags[buttontype.getValue()] = true;
			}
		});
	}
	
	public void setMouseReleasedListener(ButtonType buttontype, javafx.scene.control.Button fxButton){
		fxButton.setOnMouseReleased(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				flags[buttontype.getValue()] = false;
			}
		});
	}

	@Override
	public boolean touchePressed(int number) {
		return flags[number];
	}

}
