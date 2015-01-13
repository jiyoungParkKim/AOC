package fr.istic.aoc.metronome.anti_adapter;

import org.junit.Test;

import fr.istic.aoc.metronome.material.Material;
import fr.istic.aoc.metronome.ui.BeeperType;

public class BeeperAdapterTest {

	@Test
	public void beeperAdapterTest() {
		BeeperAdapter beeperAdapter = new BeeperAdapter(BeeperType.BEEP1);
		beeperAdapter.beep();
		
		BeeperAdapter beeperAdapter2 = new BeeperAdapter(BeeperType.BEEP2);
		beeperAdapter2.beep();
		
		Material.getemetteurSonore().emettreClick(BeeperType.BEEP1);
		Material.getemetteurSonore().emettreClick(BeeperType.BEEP2);
	}

}
