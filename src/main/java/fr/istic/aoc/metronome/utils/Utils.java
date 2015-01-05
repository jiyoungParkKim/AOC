package fr.istic.aoc.metronome.utils;


/**
 * Utility class
 * @author Jiyoung Park
 *
 */
public class Utils {
	
	/**
	 * Returns the tempo name by the bpm
	 * @param bpm
	 * @return
	 */
	public static String getTempoName(int bpm){
		String tempoName;
		
		if(bpm <= 24){
			tempoName = "Larghissimo";
		}else if(bpm <= 45){
			tempoName = "Grave";
		}else if(bpm <= 50){
			tempoName = "Lento";
		}else if(bpm <= 55){
			tempoName = "Largo";
		}else if(bpm <= 60){
			tempoName = "Larghetto";
		}else if(bpm <= 72){
			tempoName = "Adagio";
		}else if(bpm <= 80){
			tempoName = "Adagietto";
		}else if(bpm <= 84){
			tempoName = "Andantino";
		}else if(bpm <= 90){
			tempoName = "Andante";
		}else if(bpm <= 96){
			tempoName = "Andante moderato";
		}else if(bpm <= 108){
			tempoName = "Moderato";
		}else if(bpm <= 112){
			tempoName = "Allegro Moderato";
		}else if(bpm <= 120){
			tempoName = "Allegretto";
		}else if(bpm <= 168){
			tempoName = "Allegro";
		}else if(bpm <= 200){
			tempoName = "Allegretto";
		}else if(bpm <= 120){
			tempoName = "Presto";
		}else{
			tempoName = "Prestissimo";
		}
		
		return tempoName;
	}
}
