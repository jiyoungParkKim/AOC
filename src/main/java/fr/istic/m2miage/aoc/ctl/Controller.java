package fr.istic.m2miage.aoc.ctl;

import fr.istic.m2miage.aoc.command.BarChangedCommand;
import fr.istic.m2miage.aoc.command.BarEventCmd;
import fr.istic.m2miage.aoc.command.BeatChangedCommand;
import fr.istic.m2miage.aoc.command.BeatEventCommand;
import fr.istic.m2miage.aoc.command.SliderChangedCmd;
import fr.istic.m2miage.aoc.me.Engine;
import fr.istic.m2miage.aoc.me.EngineImpl;
import fr.istic.m2miage.aoc.ui.StartButton;
import fr.istic.m2miage.aoc.ui.StopButton;
import fr.istic.m2miage.aoc.ui.View;

/**
 *  
 *
 */
public class Controller {
	
	private Engine eg;
	private View view;
	
	public Controller(){
		this.eg = new EngineImpl();
		this.view = new View();
		
		// beat init
		this.eg.setBeatCmd(new BeatEventCommand(this));
		this.eg.setBeatChangedCmd(new BeatChangedCommand(this));
		// bar init
		this.eg.setBarCmd(new BarEventCmd(this));
		this.eg.setBarChangedCmd(new BarChangedCommand(this));
		// slider init
		this.view.getSlider().setSliderChangedCmd(new SliderChangedCmd(this));
		
		
		// start button setting
		this.view.setStartBtn(new StartButton(this));
		// stop button
		this.view.setStopBtn(new StopButton(this));
		
	}
	
	// beat related methods	
	public void setBeat(int beat){
		this.eg.setBeat(beat);
	}
	public void beatChanged() {
		int beat = eg.getBeat();
		this.view.getDisplay().setText(String.valueOf(beat) + " bpm");
	}
	public void handleBeatEvent() {
		this.view.getBeatBeeper().beepClick();
		this.view.getLed().flash();
	}
	
	// bar related methods
	public void setBar(int bar) {
		this.eg.setBar(bar);
	}
	public void barChanged() {
		int bar = eg.getBar();
		this.view.getDisplay().setText(String.valueOf(bar) + " beats per bar");
	}
	public void handleBarEvent() {
		this.view.getBarBeeper().beepClick();
	}
	
	// slider related methods
	public void moveSlider(double position) {
		this.view.getSlider().moveSlider(position);
	}
	public void sliderChanged(){
		double newPosition = view.getSlider().position();
		int beat = (int) (20 + (240 - 20) * newPosition);
		this.eg.setBeat(beat);
	}


	
	public View getView(){
		return this.view;
	}

	public void start() {
		this.eg.setRunning(true);
		
	}



	public void stop() {
		this.eg.setRunning(false);
		
	}










	
}
