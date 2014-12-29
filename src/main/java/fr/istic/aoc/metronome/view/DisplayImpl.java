package fr.istic.aoc.metronome.view;

import javafx.scene.text.Text;

public class DisplayImpl implements Display, FxComponentConverter{
	
	private Text fxText;
	
	public static DisplayImpl build(){
		return new DisplayImpl();
	}
	
	private DisplayImpl(){ }
	
	@Override
	public Display setFxComponent(Object fxText) {
		this.fxText = (Text)fxText;
		return this;
	}

	@Override
	public void setText(String txt) {
		fxText.setText(txt);
	}
	
//	private Text bar;
//	private Text tempoMarking;
//	
//	public static final int BEATS_LED=1;
//	public static final int BARS_LED=2;
//	
//	public static DisplayImpl buildDisplay(){
//		DisplayImpl d = new DisplayImpl();
//		return d;
//	}
//	
//	private DisplayImpl(){}
//	
//	public DisplayImpl setBeats(Text beats) {
//		this.beats = beats;
//		return this;
//	}
//	
//	public DisplayImpl setBar(Text bar) {
//		this.bar = bar;
//		return this;
//	}
//
//	public DisplayImpl setTempoMarking(Text tempoMarking) {
//		this.tempoMarking = tempoMarking;
//		return this;
//	}
//	
//	public void displayBeats(int beats){
//		this.beats.setText(beats + " BPM");
//	}
//
//	public void displayBar(int bar) {
//		this.bar.setText(bar + " beats");
//	}

}
