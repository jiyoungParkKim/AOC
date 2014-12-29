package fr.istic.aoc.metronome;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import fr.istic.aoc.metronome.command.BarChangedCmd;
import fr.istic.aoc.metronome.command.BarEventCmd;
import fr.istic.aoc.metronome.command.BeatEventCmd;
import fr.istic.aoc.metronome.command.SpeedUpCmd;


@RunWith(MockitoJUnitRunner.class)
public class MEImplTest {
	
	private MEImpl meImpl;
	@Mock EventHandlingController controller;
	
	@Before
	public void setup(){
		meImpl = MEImpl.build();
	}
	
	@Test(expected=ConfigurationException.class)
	public void registerObserverTest() throws ConfigurationException {
		meImpl
		  .registerObserver(new SpeedUpCmd(controller))//SpeedUpCmd is not observer for ME
		  .registerObserver(new BarChangedCmd(controller))
		  .registerObserver(new BeatEventCmd(controller)) 
		  .registerObserver(new BarEventCmd(controller));
	}
	
	@Test
	public void setRunningTest(){
		
	}
	
	
}
