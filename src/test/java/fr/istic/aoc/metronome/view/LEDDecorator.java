package fr.istic.aoc.metronome.view;

public class LEDDecorator extends LEDImpl{
	
	private LEDImpl led;
	private String name;
	public LEDDecorator(LEDImpl led, String name){
		this.led = led;
		this.name = name;
	}
	
	@Override
	public void flash() {
		System.out.println(name + " flashed!!!");
		led.flash();
	}
}
