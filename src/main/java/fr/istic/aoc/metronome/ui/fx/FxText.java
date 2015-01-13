package fr.istic.aoc.metronome.ui.fx;

import fr.istic.aoc.metronome.ui.Display;

public class FxText implements Display {
	private javafx.scene.text.Text component;
	public FxText(javafx.scene.text.Text component){
		this.component = component;
	}

	@Override
	public void setText(String txt) {
		component.setText(txt);
	}

}
