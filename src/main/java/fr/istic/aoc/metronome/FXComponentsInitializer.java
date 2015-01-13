package fr.istic.aoc.metronome;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import fr.istic.aoc.metronome.ui.LED;
import fr.istic.aoc.metronome.ui.View;
import fr.istic.aoc.metronome.ui.fx.FxButton;
import fr.istic.aoc.metronome.ui.fx.FxLED;
import fr.istic.aoc.metronome.ui.fx.FxSlider;
import fr.istic.aoc.metronome.ui.fx.FxText;

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
		view.setLed1(bpmLED);
		
		LED measureLED = new FxLED(led2, Color.PINK);
		view.setLed2(measureLED);
		
		ctl.init(view);
	}
}
