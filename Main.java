import java.util.ArrayList;
import java.util.List;

public class Main {

       public static void main(String[] args) {
        List<Process> processes = new ArrayList<>();
        processes.add(new Process(1, 0, 6));
        processes.add(new Process(2, 2, 8));
        processes.add(new Process(3, 3, 7));
        processes.add(new Process(4, 4, 10));

        SJFScheduler.simulateSJFScheduling(processes);
    }
}