package fr.istic.aoc.metronome.command;

import fr.istic.aoc.metronome.anti_adapter.AntiAdapter;


public class ReadCmd implements Command {
	
	private AntiAdapter adapter;
	public ReadCmd(AntiAdapter adapter) {
		this.adapter = adapter;
	}

	@Override
	public void execute() {
		adapter.read();
	}
}
