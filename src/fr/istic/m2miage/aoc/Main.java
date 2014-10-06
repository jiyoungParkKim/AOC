package fr.istic.m2miage.aoc;

import fr.istic.m2miage.aoc.ctl.Controller;
import fr.istic.m2miage.aoc.me.Engine;
import fr.istic.m2miage.aoc.me.EngineImpl;

public class Main {

	public static void main(String[] args){
		Engine eg = new EngineImpl();
		eg.setTempo(1);
		Controller ctl = new Controller(eg);
		ctl.executeBeatCmd();
	}
}
