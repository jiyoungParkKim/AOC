package fr.istic.aoc.metronome.view;

/**
 * A class can implement the FxComponentConverter interface when it wants to contains a javaFX component. 
 * @author Jiyoung Park
 *
 */
public interface FxComponentConverter {
	/**
	 * Sets the javaFX component
	 * @param fxComponent
	 * @return
	 */
	Object setFxComponent(Object fxComponent);
}
