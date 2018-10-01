import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int line = in.nextInt();
        int[] ans = new int[line];
        List<Integer>A = new ArrayList<>();
        if(line<=2) {
            System.out.println(line);
            return;
        }
        for (int i = 0; i < line; i++) {
            ans[i] = 0;
            A.add(i);
        }
        List<Integer>B = A;
        for (int i = 0; i < line; i++) {
            if(i%3==0){
                A.remove(i);
            }
        }

    }

}