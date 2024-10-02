package java2.week3;

/**
 * VotingMachine과 결과는 같지만 String pick을 사용해 다른 매커니즘으로 구현한 프로그램
 */
public class VotingMachine2 {
    private int tteokbokkiVotes;  // 떡볶이 득표 수
    private int sundaeVotes;      // 순대 득표 수

    // 생성자
    public VotingMachine2() {
        tteokbokkiVotes = 0;
        sundaeVotes = 0;
    }

    // 떡볶이 또는 순대에 투표하는 메서드
    public void vote(String pick) {
        if (pick.equals("Tteokbokki")) {  // 떡볶이에 투표
            tteokbokkiVotes++;
        } else if (pick.equals("Sundae")) {  // 순대에 투표
            sundaeVotes++;
        }
        // 그 외의 경우 아무 일도 하지 않음
    }

    // 투표 결과 초기화
    public void clear() {
        tteokbokkiVotes = 0;
        sundaeVotes = 0;
    }

    // 떡볶이 득표수를 반환
    public int getVotes(String pick) {
        if (pick.equals("Tteokbokki")) {
            return tteokbokkiVotes;
        } else if (pick.equals("Sundae")) {
            return sundaeVotes;
        }
        // 떡볶이도 순대도 아닌 경우 0을 반환
        return 0;
    }
}

