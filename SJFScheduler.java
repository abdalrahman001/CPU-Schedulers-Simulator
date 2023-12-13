import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Process {
    int processId;
    int arrivalTime;
    int burstTime;

    public Process(int processId, int arrivalTime, int burstTime) {
        this.processId = processId;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
    }
}
public class SJFScheduler  {
public static void simulateSJFScheduling(List<Process> processes) {
        // Sort processes based on arrival time
        Collections.sort(processes, Comparator.comparingInt(p -> p.arrivalTime));

        int currentTime = 0; 
        int totalWaitingTime = 0; 

        System.out.println("Process\tArrival Time\tBurst Time\tWaiting Time\tTurnaround Time");

        for (Process process : processes) {
            int waitingTime = currentTime - process.arrivalTime;
            if (waitingTime < 0) {
                waitingTime = 0;
                currentTime = process.arrivalTime;
            }

            int turnaroundTime = waitingTime + process.burstTime;
            totalWaitingTime += waitingTime;

            System.out.println(process.processId + "\t\t" + process.arrivalTime + "\t\t\t" +
                    process.burstTime + "\t\t\t" + waitingTime + "\t\t\t" + turnaroundTime);

            currentTime += process.burstTime; 
        }

        double averageWaitingTime = (double) totalWaitingTime / processes.size();
        System.out.println("\nAverage Waiting Time: " + averageWaitingTime);
    }
}
    
