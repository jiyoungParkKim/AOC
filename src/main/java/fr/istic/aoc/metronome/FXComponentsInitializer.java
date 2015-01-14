package fr.istic.aoc.metronome;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import fr.istic.aoc.metronome.anti_adapter.ButtonAdapter;
import fr.istic.aoc.metronome.anti_adapter.DisplayAdapter;
import fr.istic.aoc.metronome.anti_adapter.LedAdapter;
import fr.istic.aoc.metronome.anti_adapter.SliderAdapter;
import fr.istic.aoc.metronome.ui.ButtonType;
import fr.istic.aoc.metronome.ui.DisplayType;
import fr.istic.aoc.metronome.ui.LEDType;
import fr.istic.aoc.metronome.ui.SliderType;
import fr.istic.aoc.metronome.ui.View;

/**
 * Sets the java-fx components into the instance of the {@link View} class and pass it to the Controller
 * @author Jiyoung Park
 *
 */
public class FXComponentsInitializer implements ComponentInitializer{

	@FXML private Button startBtn;
	@FXML private Button stopBtn;
	@FXML private Button speedUpBtn;
	@FXML private Button speedDownBtn;
	@FXML private Text bar;
	@FXML private Text beats;
	@FXML private Text tempoMarking;
	@FXML private Circle led1;
	@FXML private Circle led2;
	@FXML private Slider beatsSlider;
	@FXML private Slider barSlider;

	/**
	 * Performs the actual initialization work after loading the FXML
	 * @throws ConfigurationException 
	 */
	@FXML
	public void initialize() throws ConfigurationException{
		Controller ctl = new Controller();
		
		// 1. FX + Anti Adapter = Material
		//FxButton fxStartBtn = new FxButton(startBtn);
		View view = new View();
		
		view.setStartBtn(new ButtonAdapter(ButtonType.START, startBtn));
		view.setStopBtn(new ButtonAdapter(ButtonType.STOP, stopBtn));
		view.setIncBtn(new ButtonAdapter(ButtonType.INC, speedUpBtn));
		view.setDecBtn(new ButtonAdapter(ButtonType.DEC, speedDownBtn));
		
		view.setBpmSlider(new SliderAdapter(SliderType.BPM, beatsSlider));
		view.setMeasureSlider(new SliderAdapter(SliderType.MEASURE, barSlider));
		
		view.setBpmText(new DisplayAdapter(DisplayType.BPMText, beats));
		view.setMeasureText(new DisplayAdapter(DisplayType.MeasureText, bar));
		view.setTempoNameText(new DisplayAdapter(DisplayType.TempoName, tempoMarking));
		
		view.setLed1(new LedAdapter(LEDType.BPMLED, led1));
		view.setLed2(new LedAdapter(LEDType.MeasureLED, led2));
		
		ctl.init(view);
	}
}
