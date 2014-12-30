package fr.istic.aoc.metronome.command;

import fr.istic.aoc.metronome.EventHandlingController;

public class TickCounter implements Command {

    private int ticks = 0;
    private Command cmd;
    private EventHandlingController ctl;
    public TickCounter(Command cmd, EventHandlingController ctl){
    	this.cmd = cmd;
    	this.ctl = ctl;
    }

    @Override
    public void execute() {
    	ticks++;
    	System.out.println("tick " + ticks);
    	cmd.execute();
    	if(ticks > 5){
    		ctl.stop();
    	}
    }
    
    public int getTicks(){
    	return ticks;
    }

}
