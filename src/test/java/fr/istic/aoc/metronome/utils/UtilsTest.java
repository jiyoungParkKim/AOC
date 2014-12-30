package fr.istic.aoc.metronome.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UtilsTest {

	@Test
	public void test() {
		assertEquals("Larghissimo",Utils.getTempoMarking(24));
		assertEquals("Grave",Utils.getTempoMarking(25));
		
		assertEquals("Grave",Utils.getTempoMarking(45));
		assertEquals("Lento",Utils.getTempoMarking(46));
		
		assertEquals("Lento",Utils.getTempoMarking(50));
		assertEquals("Largo",Utils.getTempoMarking(51));
		
		assertEquals("Largo",Utils.getTempoMarking(55));
		assertEquals("Larghetto",Utils.getTempoMarking(56));
		
		assertEquals("Larghetto",Utils.getTempoMarking(60));
		assertEquals("Adagio",Utils.getTempoMarking(61));
		
		assertEquals("Adagio",Utils.getTempoMarking(72));
		assertEquals("Adagietto",Utils.getTempoMarking(73));
		
		assertEquals("Adagietto",Utils.getTempoMarking(80));
		assertEquals("Andantino",Utils.getTempoMarking(81));
		
		assertEquals("Andantino",Utils.getTempoMarking(84));
		assertEquals("Andante",Utils.getTempoMarking(85));
		
		

		//		}else if(bpm <= 90){
//			tempoName = "Andante";
//		}else if(bpm <= 96){
//			tempoName = "Andante moderato";
//		}else if(bpm <= 108){
//			tempoName = "Moderato";
//		}else if(bpm <= 112){
//			tempoName = "Allegro Moderato";
//		}else if(bpm <= 120){
//			tempoName = "Allegretto";
//		}else if(bpm <= 168){
//			tempoName = "Allegro";
//		}else if(bpm <= 200){
//			tempoName = "Allegretto";
//		}else if(bpm <= 120){
//			tempoName = "Presto";
//		}else{
//			tempoName = "Prestissimo";
//		}
	}

}
