package fr.istic.aoc.metronome.command;

import fr.istic.aoc.metronome.Controller;

public class BpmSliderChangedCmd implements Command {

	private Controller controller;
	public BpmSliderChangedCmd(Controller controller) {
		this.controller = controller;
	}

	/* (non-Javadoc)
	 * @see fr.istic.aoc.metronome.command.Command#execute()
	 */
	@Override
	public void execute() {
		controller.bpmSliderChanged();
	}

}
