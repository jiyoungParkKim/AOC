package fr.istic.aoc.metronome.anti_adapter;

import javafx.scene.text.Text;
import fr.istic.aoc.metronome.adapter.AfficheurAdapter;
import fr.istic.aoc.metronome.material.Material;
import fr.istic.aoc.metronome.ui.Display;
import fr.istic.aoc.metronome.ui.DisplayType;

public class DisplayAdapter implements Display {
	
	private AfficheurAdapter afficheur = (AfficheurAdapter) Material.getAfficheur();
	
	private DisplayType type;
	
	public DisplayAdapter(DisplayType type, Text fxText) {
		this.type = type;
		switch (type) {
		case BPMText:
			afficheur.setBpmText(fxText);
			break;
		case MeasureText:
			afficheur.setMeasureText(fxText);
			break;
		case TempoName:
			afficheur.setTempoNameText(fxText);
			break;
		default:
			break;
		}
	}

	@Override
	public void setText(String txt) {
		switch (type) {
		case BPMText:
			afficheur.showBPM(txt);
			break;
		case MeasureText:
			afficheur.showMeasure(txt);
			break;
		case TempoName:
			afficheur.showTempoName(txt);
			break;
		default:
			break;
		}
	}

}
