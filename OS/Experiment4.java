import java.util.*;
public class Experiment4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\n\n\nEnter the number of processes: ");
        int n = sc.nextInt();
        int[] bt = new int[n]; 
        int[] wt = new int[n]; 
        int[] tat = new int[n]; 
        int[] priority = new int[n]; 
        int total_wt = 0, total_tat = 0;
        System.out.println("Enter burst time and priority for each process:");
        for (int i = 0; i < n; i++) {
            System.out.print("Process " + (i+1) + " burst time: ");
            bt[i] = sc.nextInt();
            System.out.print("Process " + (i+1) + " priority: ");
            priority[i] = sc.nextInt();
        }
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if (priority[i] > priority[j]) {
                    int temp = priority[i];
                    priority[i] = priority[j];
                    priority[j] = temp;

                    temp = bt[i];
                    bt[i] = bt[j];
                    bt[j] = temp;
                } } }
        wt[0] = 0; 
        for (int i = 1; i < n; i++) {
            wt[i] = wt[i-1] + bt[i-1];
        }for (int i = 0; i < n; i++) {
            tat[i] = wt[i] + bt[i];
        }for (int i = 0; i < n; i++) {
            total_wt += wt[i];
            total_tat += tat[i];
        }
        System.out.println("Process\tBurst Time\tPriority\tWaiting Time\tTurnaround Time");
        for (int i = 0; i < n; i++) {
            System.out.println((i+1) + "\t\t" + bt[i] + "\t\t" + priority[i] + "\t\t" + wt[i] + "\t\t" + tat[i]);
        }
        System.out.println("Average waiting time: " + (float)total_wt/n);
        System.out.println("Average turnaround time: " + (float)total_tat/n);
    }
}