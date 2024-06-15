import java.util.*;


public class Main2 {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);

            int n1 = input.nextInt();
            int n2 = input.nextInt();

            input.close();

            n1 = Integer.parseInt(new StringBuilder().append(n1).reverse().toString());
            n2 = Integer.parseInt(new StringBuilder().append(n2).reverse().toString());

            System.out.print(n1 > n2 ? n1 : n2);


            }
        }


