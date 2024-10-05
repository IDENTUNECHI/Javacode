package java1.two_array2;

public class SwapComparison {

    /**
     * x, y 값을 서로 바꿔준다.
     * @param x
     * @param y
     */
    public static void swap(int x, int y) {
        int temp;
        temp = x;
        x = y;
        y = temp;
    }

    /**
     * 배열의 두 원소 값을 서로 바꾼다.
     * a[i] <-- > a[j]
     * @param a 배열.
     * @param i 값을 바꿀 방 번호.
     * @param j 값을 바꿀 방 번호.
     */
    public static void swap(int[] a, int i, int j) {
        int temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {

        int[] anArray = {10, 20};

        swap(anArray[0], anArray[1]);
        System.out.println("anArray[0]="+anArray[0]+",anArray[1]="+anArray[1]);
        swap(anArray, 0, 1);
        System.out.println("anArray[0]="+anArray[0]+",anArray[1]="+anArray[1]);

    }
}


