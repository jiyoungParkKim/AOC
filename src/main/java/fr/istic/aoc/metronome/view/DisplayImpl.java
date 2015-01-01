package fr.istic.aoc.metronome.view;

import javafx.scene.text.Text;

/**
 * Implementation of the Display interface containing a java-fx component and a command object 
 * which will be executed later. 
 * @author Jiyoung Park
 *
 */
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

	/**
	 * Sets the given text to the fxText field.
	 */
	@Override
	public void setText(String txt) {
		fxText.setText(txt);
	}

}
