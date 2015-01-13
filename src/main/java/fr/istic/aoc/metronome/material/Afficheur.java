package fr.istic.aoc.metronome.material;

/**
 * Afficheur that controls LED components and Text Components of materials 
 * @author Jiyoung Park
 *
 */
public interface Afficheur {
	
	void turnOnLED(int numLED);
	void turnOffLED(int numLED);
	
	void showBPM(String bpmValue);
	void showMeasure(String measureValue);
	void showTempoName(String tempoName);

}
