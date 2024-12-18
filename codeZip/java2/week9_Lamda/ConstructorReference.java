package java2.week9_Lamda;

import java.util.List;

public class ConstructorReference {
    public static void main(String[] args) {
        List.of("", "1", "22", "3").stream().filter(x -> x.length() < 0).reduce(String :: concat);

        

    }
}
