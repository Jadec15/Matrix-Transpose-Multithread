/**modified from
 * @author Haiping Xu
 * Created at the CIS Department, UMass Dartmouth
 * Thread 3
 */

/*Jade Cabral
  Michael Sarmento
  Group 2
  CIS 481
  2/6/21
*/

import java.util.Random;

public class MatrixTranspose implements Runnable {
    private int choice;
    private int arr1[][];
    private int arr2[][];

    public MatrixTranspose(int newChoice, int arr1[][], int arr2[][]) {
        choice = newChoice;
        this.arr1 = arr1;
        this.arr2 = arr2;
    }

    private void delay() {
        Random random = new Random();
        int delay = 0;
        delay = random.nextInt(1000);
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {

        switch (choice) {
            case 1: // task 1
                for (int i = 0; i < 3; i++) {
                    delay();
                    arr2[i][0] = arr1[0][i];
                    System.out.println("Do-Task-" + choice + " ");

                }
                break;
            case 2: // task 2
                for (int i = 0; i < 3; i++) {
                    delay();
                    arr2[i][1] = arr1[1][i];
                    System.out.println("Do-Task-" + choice + " ");

                }
                break;
            case 3: // task 3
                for (int i = 0; i < 3; i++) {
                    delay();
                    arr2[i][2] = arr1[2][i];
                    System.out.println("Do-Task-" + choice + " ");

                }
                break;
            default: // task whatever
                delay();
                System.out.println("Do-Whatever-Task");
        }

    }

    public static void main(String[] args) {
        Thread task1, task2, task3;

        int arr[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }; //starting matrix

        int arr2[][] = new int[3][3];

        task1 = new Thread(new MatrixTranspose(1, arr, arr2));
        task2 = new Thread(new MatrixTranspose(2, arr, arr2));
        task3 = new Thread(new MatrixTranspose(3, arr, arr2));

        task1.start();
        task2.start();
        task3.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        System.out.println("[" + arr2[0][0] + ", " + arr2[0][1] + ", " + arr2[0][2] + "]");
        System.out.println("[" + arr2[1][0] + ", " + arr2[1][1] + ", " + arr2[1][2] + "]");
        System.out.println("[" + arr2[2][0] + ", " + arr2[2][1] + ", " + arr2[2][2] + "]");

    }
}