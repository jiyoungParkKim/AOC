package fr.istic.m2miage.aoc.ctl;

import fr.istic.m2miage.aoc.command.BeatCommand;
import fr.istic.m2miage.aoc.command.Command;
import fr.istic.m2miage.aoc.me.Engine;

public class Controller {
	
	private Engine eg;
	
	public Controller(Engine eg){
		this.eg = eg;
	}
	
	public void executeBeatCmd(){
		Command cmd = new BeatCommand(this);
		eg.setBeatCommand(cmd);
	}
	
	public void beat(){
		System.out.println("beep!");
	}
	
	public void clignote(){
		System.out.println("clignote!");
	}
}
