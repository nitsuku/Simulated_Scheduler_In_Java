package EmulatedScheduler;

import java.util.Queue;


/*
 * Class designed to run RoundRobin algorithm 
 * as a simulated Operating System on
 * processes.
 * 
 * @Author:  Nick Faccenda
 * @Version: 1.0
 * @Date:    10/10/2016
 * 
 */
public class Scheduler {

	private Clock clock; //Clock to cycle through processes

	/*
	 * Default constructor for Scheduler
	 * @param  Clock<Process> q   clock to
	 * 	be shared and iterated through.
	 */
	public Scheduler(Clock<Process> q) {
		this.clock = q;
	}
	/*
	 * Performs the round robin algorithm
	 * (HOPEFULLY)
	 * 
	 */
	public boolean run() throws TerminatedProcessException {
		while (clock.isEmpty() == false) {
			if (clock.getHead().getProcess().getTimeToRun() <= 0) {
				clock.remove();
			} else {
				clock.getHead().getProcess().run(10);
				if (clock.getHead().getProcess().getTimeToRun() > 0){
					Node temp = clock.getHead();
					clock.remove();
					clock.add(temp);
				}
			}
		}
		return true;
	}
}
