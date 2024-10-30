package java2Core.w5_Collection;

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
        /**
         * ArrayList
         */
        // 0이상, max 미만 정수 난수를 n개 발생시켜 리스트에 저장한다.
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            int ran = random.nextInt(max);
            list.add(ran);
        }

//----------------------------------------------------
        // list를 Iterator<>를 사용해 출력한다.
        Iterator<Integer> it = list.iterator();
        while(it.hasNext()){

            System.out.print(it.next()+" ");
        }
        System.out.println();
        //------------------------------------------//
        // 오름차순으로 정렬된 list 출력
        // Collections.sort()를 사용해 정렬
        Collections.sort(list);
        it = list.iterator();
        while(it.hasNext()){

            System.out.print(it.next()+" ");
        }
        System.out.println();
        //------------------------------------------//
        /**
         * Set
         */
        // Set 인터페이스의 HashSet 클래스를 사용해 list값을 set에 저장
        Set<Integer> setList = new HashSet<>(list);

        // Set은 중복이 허용되지 않으며 인덱스가 존재하지 않는다.
        it = setList.iterator();
        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }
        System.out.println();
        //-----------------------------------------------------------------//
        /**
         * ListMap
         */
        // list에 있는 각 원소가 얼마나 중복되었는지를 조사하여 map에 저장한다.

        // Map 생성
        // Map 인터페이스 중 HashMap 클래스를 사용해 list를 map에 저장
        // Map은 key와 value의 값을 쌍으로 저장한다. //
        // key는 중복을 허용하지 않는다. //
        // 하나의 value가 여러 key의 결합될 수 있다. //
        // map.getOrDefault(k, 0) 는 key에 해당하는 value값이 있을 때,//
        // 그 value값을 리턴하고 없다면 0을 리턴한다.//
        Map<Integer, Integer> mapList = new HashMap<>(); //<원소, 중복도>
        //Map의 모든 키-값 쌍을 읽는 법
        it = list.iterator();
        while(it.hasNext()){
            int i = it.next();
            mapList.put(i, mapList.getOrDefault(i, 0)+1);
        }

        Set<Integer> keys = mapList.keySet(); // HashMap에서 **모든 키(key)**들을 모아 Set 형태로 반환하는 방법
        for (Integer key : keys) {
            Integer value = mapList.get(key);
            System.out.println(key + ":" + value);
        }

        System.out.println();


        //-------------------------------------------------------//
        // map에서 Value 값 최대값 찾기
        // 1 10 10을 입력했을 때, 최대값 3

        // 중복 횟수의 빈도수 조사
        int [] frequency = new int [Collections.max(mapList.values())+1];

        for(int count : mapList.values()){
            frequency[count]++;
        }

        // 중복 횟수에 따른 도수 분포 출력
        for(int i=1; i< frequency.length; i++){
            System.out.println(i +":"+ + frequency[i]);
        }
    }
}
