import java.lang.*;

public class QueueSimulator {

	public enum Event {ARRIVAL, DEPARTURE}

	;
	private double currTime;
	private double arrivalRate;
	private double serviceTime;
	private double timeForNextArrival;
	private double timeForNextDeparture;
	private double totalSimTime;
	LinkedListQueue<Data> buffer = new LinkedListQueue<Data>();
	LinkedListQueue<Data> eventQueue = new LinkedListQueue<Data>();
	private Event e;

	public double getRandTime(double arrivalRate) {
		double num, time1, max = 1, min = 0, randNUM;
		randNUM = Math.random();
		time1 = (-1 / arrivalRate) * (Math.log(1 - randNUM));
		//System.out.println(time1);
		return time1;
	}

	public QueueSimulator(double aR, double servT, double simT) {
		arrivalRate = aR;
		serviceTime = servT;

		timeForNextArrival = getRandTime(arrivalRate);
		timeForNextDeparture = servT + timeForNextArrival;

		totalSimTime = simT;
	}

  public double calcAverageWaitingTime(){

		double counter = 0;
		double avgTime = 0;
		Data deDatum = new Data();

		while (eventQueue.isEmpty() != true)
		{
			deDatum = eventQueue.dequeue();
			avgTime = deDatum.getDepartureTime() - deDatum.getArrivalTime();

			counter++;
		}

		return (avgTime/counter);
  }


  public double runSimulation(){

  	Data datum = new Data();

  	datum.setArrivalTime(timeForNextArrival);
  	datum.setDepartureTime(timeForNextDeparture);

  	currTime = 0;

    while (currTime >= totalSimTime)
    {
    	if (buffer.isEmpty() != true)
    	{
		    if (timeForNextArrival < timeForNextArrival)
			    e = Event.ARRIVAL;
		    else
			    e = Event.DEPARTURE;
	    }
	    else
	        e = Event.ARRIVAL;

      if (e == Event.ARRIVAL)
      {
        buffer.enqueue(datum);
        datum.setArrivalTime(currTime);// compute timeForNextArrival;
	      currTime += datum.getArrivalTime();// time at which event occurs
      }
      else
      {
        eventQueue.enqueue(buffer.dequeue());
        datum.setArrivalTime(currTime);// compute timeForNextDeparture;
	      currTime += datum.getDepartureTime();// time at which event occurs
      }
    }

    return calcAverageWaitingTime();
  }
}


/*
original class function declarations:
 public QueueSimulator(double aR, double servT, double simT){
  }

  public double calcAverageWaitingTime(){

  }

  public double runSimulation(){

  }
 */





