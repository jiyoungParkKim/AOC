package fr.istic.aoc.metronome.command;

import fr.istic.aoc.metronome.Controller;

public class StopCmd implements Command {
	
	private Controller controller;
	public StopCmd(Controller controller) {
		this.controller = controller;
	}

	/* (non-Javadoc)
	 * @see fr.istic.aoc.metronome.command.Command#execute()
	 */
	@Override
	public void execute() {
		controller.stop();
	}

}
