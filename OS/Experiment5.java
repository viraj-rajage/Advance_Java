import java.util.*;
public class Experiment5 {
    static class Process {
        int pid, bt, rt;
        Process(int pid, int bt) {
            this.pid = pid;
            this.bt = bt;
            this.rt = bt;
        } }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\n\n\nEnter the number of processes: ");
        int n = sc.nextInt();
        System.out.print("Enter the time quantum: ");
        int quantum = sc.nextInt();
        Process[] processes = new Process[n];
        System.out.println("Enter burst time for each process:");
        for (int i = 0; i < n; i++) {
            System.out.print("Process " + (i+1) + ": ");
            int bt = sc.nextInt();
            processes[i] = new Process(i+1, bt); }
        int time = 0;
        while (true) {
            boolean done = true;
            for (int i = 0; i < n; i++) {
                if (processes[i].rt > 0) {
                    done = false;
                    if (processes[i].rt > quantum) {
                        time += quantum;
                        processes[i].rt -= quantum;
                        System.out.println("Process " + processes[i].pid + " executed for " + quantum + " units.");
                    } else {
                        time += processes[i].rt;
                        processes[i].rt = 0;
                        System.out.println("Process " + processes[i].pid + " executed for " + processes[i].bt + " units.");
                        System.out.println("Process " + processes[i].pid + " completed at time " + time + ".");
      } } } if (done) break;
} } }
