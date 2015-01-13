package fr.istic.aoc.metronome.command;

import fr.istic.aoc.metronome.Controller;

public class MeasureSliderChangedCmd implements Command {

	private Controller controller;
	public MeasureSliderChangedCmd(Controller controller) {
		this.controller = controller;
	}

	/* (non-Javadoc)
	 * @see fr.istic.aoc.metronome.command.Command#execute()
	 */
	@Override
	public void execute() {
		controller.measureSliderChanged();
	}
}
