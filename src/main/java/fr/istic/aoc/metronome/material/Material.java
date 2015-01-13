package fr.istic.aoc.metronome.material;

import fr.istic.aoc.metronome.adapter.AfficheurAdapter;
import fr.istic.aoc.metronome.adapter.ClavierAdapter;
import fr.istic.aoc.metronome.adapter.EmetteurSonoreAdapter;
import fr.istic.aoc.metronome.adapter.HorlogeAdapter;
import fr.istic.aoc.metronome.adapter.MoletteAdapter;
import fr.istic.aoc.metronome.ui.fx.TimerImpl;

public class Material {

	private static Clavier clavier = new ClavierAdapter();
	private static Molette molette = new MoletteAdapter();
	private static Afficheur afficheur = new AfficheurAdapter();
	private static EmetteurSonore emetteurSonore = new EmetteurSonoreAdapter();
	private static Horloge horloge = new HorlogeAdapter(TimerImpl.getInstance());
	public static Clavier getClavier(){
		return clavier;
	}
	
	public static Horloge getHorloge(){
		return horloge;
	}
	
	public static Molette getMolette(){
		return molette;
	}

	public static Afficheur getAfficheur() {
		return afficheur;
	}
	
	public static EmetteurSonore getemetteurSonore(){
		return emetteurSonore;
	}
}
