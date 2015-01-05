package fr.istic.aoc.metronome;

import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import fr.istic.aoc.metronome.command.TurnOffLEDCmd;
import fr.istic.aoc.metronome.ui.LED;
import fr.istic.aoc.metronome.ui.View;
import fr.istic.aoc.metronome.ui.fx.FxButton;
import fr.istic.aoc.metronome.ui.fx.FxLED;
import fr.istic.aoc.metronome.ui.fx.FxSlider;
import fr.istic.aoc.metronome.ui.fx.FxText;


public class MockComponentsInitializer implements ComponentInitializer{

	private Button startBtn = new Button();
	private Button stopBtn = new Button();
	private Button speedUpBtn = new Button();
	private Button speedDownBtn = new Button();
	private Text bar = new Text();
	private Text beats = new Text();
	private Text tempoMarking = new Text();
	private Circle led1 = new Circle();
	private Circle led2 = new Circle();
	private Slider beatsSlider = new Slider(0, 250, 140);
	private Slider barSlider = new Slider(0, 7, 4);
	
	private Controller ctl;
	private View view;
	
	public Controller getCtl() {
		return ctl;
	}
	
	// getter setter
	
	public View getView() {
		return view;
	}

	/**
	 * Performs the actual initialization work after loading the FXML
	 * @throws ConfigurationException 
	 */
	public void initialize() throws ConfigurationException{
		ctl = new Controller();
		view = new View();
		
		view.setStartBtn(new FxButton(startBtn));
		view.setStopBtn(new FxButton(stopBtn));
		view.setIncBtn(new FxButton(speedUpBtn));
		view.setDecBtn(new FxButton(speedDownBtn));
		
		view.setBpmSlider(new FxSlider(beatsSlider));
		view.setMeasureSlider(new FxSlider(barSlider));
		
		view.setBpmText(new FxText(beats));
		view.setMeasureText(new FxText(bar));
		view.setTempoNameText(new FxText(tempoMarking));
		
		LED bpmLED = new FxLED(led1, Color.AQUA);
		bpmLED.register(new TurnOffLEDCmd(led1));
		view.setLed1(bpmLED);
		
		LED measureLED = new FxLED(led2, Color.PINK);
		measureLED.register(new TurnOffLEDCmd(led2));
		view.setLed2(measureLED);
		
		ctl.init(view);
	}

	public Button getStartBtn() {
		return startBtn;
	}

	public Button getStopBtn() {
		return stopBtn;
	}

	public Button getSpeedUpBtn() {
		return speedUpBtn;
	}

	public Button getSpeedDownBtn() {
		return speedDownBtn;
	}

	public Text getBar() {
		return bar;
	}

	public Text getBeats() {
		return beats;
	}

	public Text getTempoMarking() {
		return tempoMarking;
	}

	public Circle getLed1() {
		return led1;
	}

	public Circle getLed2() {
		return led2;
	}

	public Slider getBeatsSlider() {
		return beatsSlider;
	}

	public Slider getBarSlider() {
		return barSlider;
	}
	
	

}
