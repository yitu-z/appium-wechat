import java.io.IOException;
import java.util.Random;

public class CPUBenchmark {

    public static void main(String[] args)throws Exception {
        for(int i = 0; i<1e10;i++){
            Random r = new Random();
            int v = r.nextInt();
            System.out.println(v);
            //Thread.sleep(10);
        }
    }
}
