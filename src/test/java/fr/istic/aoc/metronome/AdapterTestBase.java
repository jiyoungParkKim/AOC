package fr.istic.aoc.metronome;



import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import fr.istic.aoc.metronome.command.Command;

public abstract class  AdapterTestBase {
	
	public void assertInTimeline(Command cmd){
		Timeline timeline = new Timeline();
		timeline.getKeyFrames().add(new KeyFrame(
		        Duration.millis(200),
		        ae -> cmd.execute()));
		timeline.play();
	}
	
	public class TestAdapterCommand implements Command{
		double expectedValue;
		public TestAdapterCommand(double expectedValue){
			this.expectedValue = expectedValue;
		}
		@Override
		public void execute() {
			doTest(expectedValue);
		}
	}
	
	abstract void doTest(double expectedValue);
}
