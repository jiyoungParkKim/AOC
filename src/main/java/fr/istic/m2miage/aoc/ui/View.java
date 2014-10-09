package fr.istic.m2miage.aoc.ui;



public class View {
	// materials
	private Beeper beeper;
	private Slider slider;
	private Keybord keybord;
	private Timer timer;
	private Display display;

	private LED led;
	private Button startBtn;
	private Button stopBtn;
	private Button speedUp;
	private Button speedDown;
	
	public View(){
		this.beeper = Material.getBeeper();
		this.slider = Material.getSlider();
		this.keybord = Material.getKeybord();
		this.display = Material.getDisplay();
		this.timer = Material.getTimer();
		this.led = new LEDImpl();
		
		this.speedUp = new SpeedUpButton();
		this.speedDown = new SpeedDownButton();
	}

	public LED getLed() {
		return led;
	}

	public Display getDisplay() {
		return display;
	}

	public Beeper getBeeper() {
		return beeper;
	}

	public Slider getSlider() {
		return slider;
	}

	public Button getStartBtn() {
		return startBtn;
	}

	public Button getStopBtn() {
		return stopBtn;
	}

	public Button getSpeedUp() {
		return speedUp;
	}

	public Button getSpeedDown() {
		return speedDown;
	}

	public void setBeeper(Beeper beeper) {
		this.beeper = beeper;
	}

	public void setSlider(Slider slider) {
		this.slider = slider;
	}

	public void setKeybord(Keybord keybord) {
		this.keybord = keybord;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}

	public void setDisplay(Display display) {
		this.display = display;
	}

	public void setLed(LED led) {
		this.led = led;
	}

	public void setStartBtn(Button startBtn) {
		this.startBtn = startBtn;
	}

	public void setStopBtn(Button stopBtn) {
		this.stopBtn = stopBtn;
	}

	public void setSpeedUp(Button speedUp) {
		this.speedUp = speedUp;
	}

	public void setSpeedDown(Button speedDown) {
		this.speedDown = speedDown;
	}
	
	
	
}
