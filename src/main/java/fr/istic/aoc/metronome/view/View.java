package fr.istic.aoc.metronome.view;

import fr.istic.aoc.metronome.observer.Subject;

public class View {
	
	private Subject beatsLED;
	private Subject barLED;
	
	private Slider beatsSlider;
	private Slider barSlider;
	
	private Button startButton;
	private Button stopButton;
	private Button speedUpButton;
	private Button speedDownButton;
	
	private Display beatsText;
	private Display barText;
	private Display tempoMarking;
	
	public static View build(){
		return new View();
	}
	private View(){}
	
	public Display getBeatsText() {
		return beatsText;
	}
	public View setBeatsText(Display beatsText) {
		this.beatsText = beatsText;
		return this;
	}
	public Display getBarText() {
		return barText;
	}
	public View setBarText(Display barText) {
		this.barText = barText;
		return this;
	}
	public LED getBeatsLED() {
		return (LED)beatsLED;
	}
	public View setBeatsLED(Subject subject) {
		this.beatsLED = subject;
		return this;
	}
	public LED getBarLED() {
		return (LED)barLED;
	}
	public View setBarLED(Subject subject) {
		this.barLED = subject;
		return this;
	}
	public Slider getBeatsSlider() {
		return beatsSlider;
	}

	public View setBeatsSlider(Slider beatsSlider) {
		this.beatsSlider = beatsSlider;
		return this;
	}

	public Slider getBarSlider() {
		return barSlider;
	}

	public View setBarSlider(Slider barSlider) {
		this.barSlider = barSlider;
		return this;
	}

	public View setStartButton(ButtonImpl buttonImpl) {
		this.startButton = buttonImpl;
		return this;
	}

	public Button getStartButton() {
		return startButton;
	}
	
	public Button getStopButton() {
		return stopButton;
	}

	public View setStopButton(Button subject) {
		this.stopButton = subject;
		return this;
	}

	public Button getSpeedUpButton() {
		return speedUpButton;
	}

	public View setSpeedUpButton(Button subject) {
		this.speedUpButton = subject;
		return this;
	}

	public Button getSpeedDownButton() {
		return speedDownButton;
	}

	public View setSpeedDownButton(Button subject) {
		this.speedDownButton = subject;
		return this;
	}
	public Display getTempoMarking() {
		return tempoMarking;
	}
	public View setTempoMarking(Display tempoMarking) {
		this.tempoMarking = tempoMarking;
		return this;
	}
}
