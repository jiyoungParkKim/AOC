package fr.istic.aoc.metronome.anti_adapter;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import fr.istic.aoc.metronome.adapter.MoletteAdapter;
import fr.istic.aoc.metronome.command.Command;
import fr.istic.aoc.metronome.command.ReadCmd;
import fr.istic.aoc.metronome.material.Material;
import fr.istic.aoc.metronome.ui.Slider;
import fr.istic.aoc.metronome.ui.SliderType;

public class SliderAdapter implements Slider, AntiAdapter{
	private javafx.scene.control.Slider fxSlider;
	private SliderType type;
	private MoletteAdapter molette = (MoletteAdapter) Material.getMolette();
	private Command cmd;
	private int count = 0;
	private double oldValue = 0.0;
	private double nv = 0.0;
	public SliderAdapter(SliderType type, javafx.scene.control.Slider fxSlider){
		this.fxSlider = fxSlider;
		this.type = type;
		this.oldValue = fxSlider.getValue();
		// add listener
		fxSlider.valueProperty().addListener(new ChangeListener<Number>() {
			double max = fxSlider.getMax();
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				nv = newValue.doubleValue();
				molette.slideChanged(type, newValue.doubleValue() / max);
			}
		});
		
		Material.getHorloge().activatePeriodically(new ReadCmd(this), 100);
	}

	@Override
	public void register(Command cmd) {
		this.cmd = cmd;
	}

	@Override
	public void unRegister(Command cmd) {
		this.cmd = null;
	}

	@Override
	public void read() {
	// I comment this option because it recognize too slowly the movement 
	//	if(nv != oldValue && count > 10){
		if(nv != oldValue){
			count = 0;
			oldValue = nv;
			cmd.execute();
		}
		count++;
	}

	@Override
	public double getPosition() {
		return molette.getPosition(type.getValue());
	}
	
	@Override
	public void setPosition(int value) {
		fxSlider.setValue(value);
	}

}
