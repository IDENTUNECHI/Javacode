package baekjun;

import java.util.Scanner;

/**
 * B번 문제
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 테스트케이스 수
        for (int k = 0; k < n; k++) {
            int s = sc.nextInt(); // 목표 좌표
            int result = calculateTimeToReach(s);
            System.out.println(result);
        }
    }

    // 특정 좌표 x에 도달하는 시간을 계산하는 함수
    private static int calculateTimeToReach(int target) {
        int currentPosition = 0; // 현재 위치
        int time = 0; // 경과 시간
        int i = 0; // 택배 번호

        if(target == 0){
            return 0;
        }

        while (true) {
            // i번 택배의 목적지 Di 계산
            int destination = calculateDestination(i);

            // 현재 위치에서 목적지까지의 이동 거리
            int distance = Math.abs(currentPosition - destination);

            // 시간이 증가
            time += distance;

            // 현재 위치를 목적지로 업데이트
            currentPosition = destination;

            // 목표 좌표에 도달했는지 확인
            if (currentPosition == target) {
                return time;
            }

            // 다음 택배로 이동
            i++;
        }
    }

    // Di 계산 함수
    private static int calculateDestination(int i) {
        // (-1)^i × 2^(i // 2)
        int sign = (i % 2 == 0) ? 1 : -1;
        int power = i / 2;
        return sign * (1 << power); // 2^power는 1 << power로 계산
    }
}
