package fr.istic.aoc.metronome;

import fr.istic.aoc.metronome.command.BpmChangedCmd;
import fr.istic.aoc.metronome.command.BpmEventCmd;
import fr.istic.aoc.metronome.command.BpmSliderChangedCmd;
import fr.istic.aoc.metronome.command.DecCmd;
import fr.istic.aoc.metronome.command.IncCmd;
import fr.istic.aoc.metronome.command.MeasureChangedCmd;
import fr.istic.aoc.metronome.command.MeasureEventCmd;
import fr.istic.aoc.metronome.command.MeasureSliderChangedCmd;
import fr.istic.aoc.metronome.command.StartCmd;
import fr.istic.aoc.metronome.command.StopCmd;
import fr.istic.aoc.metronome.command.TickCmd;
import fr.istic.aoc.metronome.observer.MEObserver;
import fr.istic.aoc.metronome.observer.SliderObserver;
import fr.istic.aoc.metronome.ui.BeeperImpl;
import fr.istic.aoc.metronome.ui.View;
import fr.istic.aoc.metronome.utils.Utils;

/**
 * Implementation of the {@link fr.istic.aoc.metronome.observer.MEObserver} and SliderObserver. This class acts as a observer for the {@link fr.istic.aoc.metronome.ME} and {@link fr.istic.aoc.metronome.ui.Slider}s.
 * Initialize the ME instance with relative observers(Command objects) and provides the methods which control the Metronome.
 * @author Jiyoung Park
 *
 */
public class Controller implements MEObserver, SliderObserver{
	
	private View view;
	private ME me = new MeImpl();
	
	
	public void init(View view) {
		this.view = view;
		try {
			
			me.register(new BpmChangedCmd(this));
			me.register(new MeasureChangedCmd(this));
			me.register(new BpmEventCmd(this));
			me.register(new MeasureEventCmd(this));
			me.register(new TickCmd(me));
			
			view.getStartBtn().setCommand(new StartCmd(this));
			view.getStopBtn().setCommand(new StopCmd(this));
			view.getIncBtn().setCommand(new IncCmd(this));
			view.getDecBtn().setCommand(new DecCmd(this));
			
			view.getBpmSlider().register(new BpmSliderChangedCmd(this));
			view.getMeasureSlider().register(new MeasureSliderChangedCmd(this));
			
			view.setBeeper1(new BeeperImpl("PingLow.wav"));
			view.setBeeper2(new BeeperImpl("PingHi.wav"));
			
			
		} catch (ConfigurationException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
	}

	
	////////// SliderObserver //////////

	public void bpmSliderChanged() {
		me.setBPM((int)(view.getBpmSlider().getPosition() * 250));
	}

	public void measureSliderChanged() {
		me.setMeasure((int)(view.getMeasureSlider().getPosition() * 7));
	}
	
	//////////MEObserver ///////////////
	
	@Override
	public void start() {
		me.setRunning(true);
	}
	
	@Override
	public void stop() {
		me.setRunning(false);
	}
	
	@Override
	public void inc() {
		me.inc();
		view.getBpmSlider().setPosition(me.getBPM());
	}
	
	@Override
	public void dec() {
		me.dec();
		view.getBpmSlider().setPosition(me.getBPM());
	}
	
	@Override
	public void bpmChanged() {
		int bpm = me.getBPM();
		view.getBpmText().setText(bpm + " BPM");
		view.getTempoNameText().setText(Utils.getTempoName(bpm));
	}

	@Override
	public void measureChanged() {
		int measure = me.getMeasure();
		view.getMeasureText().setText(measure + " beats");
	}

	@Override
	public void handleBpmEvent() {
		view.getLed1().flash();
		view.getBeeper1().beep();
	}

	@Override
	public void handleMeasureEvent() {
		view.getLed2().flash();
		view.getBeeper2().beep();
	}
	
	///////// getter /////////////

	public View getView() {
		return view;
	}

	public ME getMe() {
		return me;
	}

}
