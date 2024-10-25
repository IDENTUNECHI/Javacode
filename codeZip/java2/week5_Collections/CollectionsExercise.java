package java2.week5_Collections;

import java.util.*;

public class CollectionsExercise {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Seed, how many, max: ");
        long seed = input.nextLong();
        Random random = new Random(seed);

        int n = input.nextInt();
        int max = input.nextInt();

        // (1) -------------------
        // 0이상, max 미만 정수 난수를 n개 발생시켜 리스트에 저장한다.
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<n; i++){
            int ran = random.nextInt(max);
            list.add(ran);
        }

//----------------------------------------------------
        // list를 Iterator<>를 사용해 출력한다.
        System.out.print("list: ");
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            int k = iterator.next();
            System.out.print(k+" ");
        }
        System.out.println();
        //------------------------------------------//
        // 오름차순으로 정렬된 list 출력
        Collections.sort(list); // Collections.sort()를 사용해 정렬
        iterator = list.iterator();
        System.out.print("sorted list: ");
        while(iterator.hasNext()){
            int k = iterator.next();
            System.out.print(k+" ");
        }
        System.out.println();
        ///////////////////////////////////
        // Set 인터페이스의 HashSet 클래스를 사용해 list값을 set에 저장
        Set<Integer> set = new HashSet<>(list);
        // Set은 중복이 허용되지 않으며 인덱스가 존재하지 않는다.

        iterator= set.iterator();
        System.out.print("set (no duplicates): ");
        while(iterator.hasNext()){
            int k = iterator.next();
            System.out.print(k+" ");
        }
        System.out.println();

        ////////////////////////////////////////////
        /**
         * list에 있는 각 원소가 얼마나 중복되었는지를 조사하여 map에 저장한다.
         */
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        // Map 인터페이스 중 HashMap 클래스를 사용해 list를 map에 저장
        // Map은 key와 value의 값을 쌍으로 저장한다. //
        // key는 중복을 허용하지 않는다. //
        // 하나의 value가 여러 key의 결합될 수 있다. //
        iterator = list.iterator();
        System.out.println("Multiplicity of each number in the list.");
        while(iterator.hasNext()){
            Integer k = iterator.next();
            // k가 key map.getOrDefault(k, 0)+1이 value
            map.put(k, map.getOrDefault(k, 0)+1);
            // map.getOrDefault(k, 0) 는 key에 해당하는 value값이 있을 때,//
            // 그 value값을 리턴하고 없다면 0을 리턴한다.//
        }

        //Map의 모든 키-값 쌍을 읽는 법

        Set<Integer> keys = map.keySet(); // HashMap에서 **모든 키(key)**들을 모아 Set 형태로 반환하는 방법
        for (Integer key : keys) {
            Integer value = map.get(key);
            System.out.println(key + ":" + value);
        }

        System.out.println();

        ///////////////////////////////////////////

        int maxValue = Collections.max(map.values()); // map에서 Value 값 최대값 찾기
                                                      // 1 10 10을 입력했을 때, 최대값 3

        // 중복 횟수의 빈도수 조사
        int[] frequency = new int[maxValue+1];
        for(int count : map.values()){
            frequency[count]++;
        }

        // 중복 횟수에 따른 도수 분포 출력
        System.out.println("Multiplicity frequency");
        for(int i=1; i< frequency.length; i++) {
            System.out.println(i + ": " + frequency[i]);

        }
    }
}
