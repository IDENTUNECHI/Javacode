package homework.two_array2;

public class Search6 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 2, 5};
        System.out.print("배열a: ");
        ArrayUtil5.printArray(a, a.length);
        System.out.println();
        // linearSearch 테스트
        System.out.println("printArray 테스트 ===");
        System.out.println("printArray(a, a.length, 5): "+linearSearch(a, a.length, 5));
        System.out.println("printArray(a, 1, 1): "+linearSearch(a, 1, 1));
        System.out.println("printArray(a, 4, 5): "+linearSearch(a, 4, 5));
        System.out.println("printArray(a, 1, 2): "+linearSearch(a, 1, 2));

        System.out.println("printArray(a, a.length, 2): "+linearSearch(a, a.length, 2));

        System.out.println("printArray(a, 0, 5): "+linearSearch(a, 0, 5));
        System.out.println("printArray(a, a.length, 4): "+linearSearch(a, a.length, 4));
        System.out.println("printArray(a, a.length + 1, 1): "+linearSearch(a, a.length + 1, 1));



    }

    /**
     * 선형탐색(Linear Search) - 배열 x의 앞 n개의 방에 key가 들어 있는가?
     *
     * @param x
     * @param n
     * @param key
     * @return i || -1
     */
    public static int linearSearch(int[] x, int n, int key) {

            for (int i = 0; i < n; i++) {
                if (x[i] == key) {
                    return i;
                }
            }

        return -1;
    }
}



