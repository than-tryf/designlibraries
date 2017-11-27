import annotation.ExecutionTime;

/**
 * Created by atryfo03 on 11/27/17.
 */
public class Main {

    @ExecutionTime
    public static void main(String[] args) {

        System.out.println("Start sleeping for 2000ms");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
