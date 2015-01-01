package fr.istic.aoc.metronome.material;

/**
 * This class contains beepers as a static object to reuse them.
 * @author Jiyoung Park
 *
 */
public class Material {
	private static Beeper beatBeeper = new BeeperImpl("PingLow.wav");
	private static Beeper barBeeper = new BeeperImpl("PingHi.wav");
	
	public static Beeper getBeatBeeper() {
		return beatBeeper;
	}
	
	public static Beeper getBarBeeper() {
		return barBeeper;
	}
}
