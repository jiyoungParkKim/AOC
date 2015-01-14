package fr.istic.aoc.metronome;

import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import fr.istic.aoc.metronome.anti_adapter.ButtonAdapter;
import fr.istic.aoc.metronome.anti_adapter.DisplayAdapter;
import fr.istic.aoc.metronome.anti_adapter.SliderAdapter;
import fr.istic.aoc.metronome.ui.ButtonType;
import fr.istic.aoc.metronome.ui.DisplayType;
import fr.istic.aoc.metronome.ui.SliderType;
import fr.istic.aoc.metronome.ui.View;


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
		
		view.setStartBtn(new ButtonAdapter(ButtonType.START, startBtn));
		view.setStopBtn(new ButtonAdapter(ButtonType.STOP, stopBtn));
		view.setIncBtn(new ButtonAdapter(ButtonType.INC, speedUpBtn));
		view.setDecBtn(new ButtonAdapter(ButtonType.DEC, speedDownBtn));
		
		view.setBpmSlider(new SliderAdapter(SliderType.BPM, beatsSlider));
		view.setMeasureSlider(new SliderAdapter(SliderType.MEASURE, barSlider));
		
		view.setBpmText(new DisplayAdapter(DisplayType.BPMText, beats));
		view.setMeasureText(new DisplayAdapter(DisplayType.MeasureText, bar));
		view.setTempoNameText(new DisplayAdapter(DisplayType.TempoName, tempoMarking));
		
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
