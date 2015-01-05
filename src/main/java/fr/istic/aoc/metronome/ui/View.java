package fr.istic.aoc.metronome.ui;

/**
 * View Class which contains all the ui components
 * @author Jiyoung Park
 *
 */
public class View {
	
	private Button startBtn;
	private Button stopBtn;
	private Button incBtn;
	private Button decBtn;
	
	private Slider bpmSlider;
	private Slider measureSlider;
	
	private Display bpmText;
	private Display measureText;
	private Display tempoNameText;
	
	private LED led1;
	private LED led2;
	
	private Beeper beeper1;
	private Beeper beeper2;
	
	public Button getStartBtn() {
		return startBtn;
	}
	public void setStartBtn(Button startBtn) {
		this.startBtn = startBtn;
	}
	public Button getStopBtn() {
		return stopBtn;
	}
	public void setStopBtn(Button stopBtn) {
		this.stopBtn = stopBtn;
	}
	public Button getIncBtn() {
		return incBtn;
	}
	public void setIncBtn(Button incBtn) {
		this.incBtn = incBtn;
	}
	public Button getDecBtn() {
		return decBtn;
	}
	public void setDecBtn(Button decBtn) {
		this.decBtn = decBtn;
	}
	public Slider getBpmSlider() {
		return bpmSlider;
	}
	public void setBpmSlider(Slider bpmSlider) {
		this.bpmSlider = bpmSlider;
	}
	public Slider getMeasureSlider() {
		return measureSlider;
	}
	public void setMeasureSlider(Slider measureSlider) {
		this.measureSlider = measureSlider;
	}
	public Display getBpmText() {
		return bpmText;
	}
	public void setBpmText(Display bpmText) {
		this.bpmText = bpmText;
	}
	public Display getMeasureText() {
		return measureText;
	}
	public void setMeasureText(Display measureText) {
		this.measureText = measureText;
	}
	public Display getTempoNameText() {
		return tempoNameText;
	}
	public void setTempoNameText(Display tempoNameText) {
		this.tempoNameText = tempoNameText;
	}
	public LED getLed1() {
		return led1;
	}
	public void setLed1(LED led1) {
		this.led1 = led1;
	}
	public LED getLed2() {
		return led2;
	}
	public void setLed2(LED led2) {
		this.led2 = led2;
	}
	public Beeper getBeeper1() {
		return beeper1;
	}
	public void setBeeper1(Beeper beeper1) {
		this.beeper1 = beeper1;
	}
	public Beeper getBeeper2() {
		return beeper2;
	}
	public void setBeeper2(Beeper beeper2) {
		this.beeper2 = beeper2;
	}
	
	

}
