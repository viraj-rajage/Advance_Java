import java.util.*;
public class Experiment3 {
    static class Job {
        int id, profit, deadline;
        Job(int id, int profit, int deadline) {
            this.id = id;
            this.profit = profit;
            this.deadline = deadline;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\n\n\nEnter the number of jobs: ");
        int n = sc.nextInt();
        Job[] jobs = new Job[n];
        System.out.println("Enter profit and deadline for each job:");
        for (int i = 0; i < n; i++) {
            System.out.print("Job " + (i+1) + " profit: ");
            int profit = sc.nextInt();
            System.out.print("Job " + (i+1) + " deadline: ");
            int deadline = sc.nextInt();
            jobs[i] = new Job(i+1, profit, deadline);
        }
        Arrays.sort(jobs, new Comparator<Job>() {
            @Override
            public int compare(Job j1, Job j2) {
                return j2.profit - j1.profit;
            }
        });
        int[] result = new int[n];
        boolean[] slot = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = Math.min(n, jobs[i].deadline)-1; j >= 0; j--) {
                if (!slot[j]) {
                    result[j] = jobs[i].id;
                    slot[j] = true;
                    break;
                }
            }
        }
        int total_profit = 0;
        System.out.print("Scheduled jobs: ");
        for (int i = 0; i < n; i++) {
            if (slot[i]) {
                System.out.print(result[i] + " ");
                total_profit += jobs[result[i]-1].profit;
            }
        }
        System.out.println("\nTotal profit: " + total_profit);
    }
}