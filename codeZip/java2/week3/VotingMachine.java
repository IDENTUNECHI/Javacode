package java2.week3;

/**
 * 떡볶이가 맛있니 순대가 맛있니? 투표하는 프로그램
 */
public class VotingMachine {
    private int voteTkeokk;
    private int voteSun;

    public VotingMachine(){
        voteTkeokk = 0;
        voteSun = 0;
    }
    public void voteForTkeokk(){ //떡볶기에 투표
        voteTkeokk += 1;
    }
    public void voteForSun() { // 순대에 투표
        voteSun += 1;
    }
    public void clear() {  // 지금까지의 투표 내용을 모두 삭제
        voteTkeokk = 0;
        voteSun = 0;
    }
    public int getTkeokkVotes() { // 떡복기 득표수를 반환
        return voteTkeokk;
    }
    public int getSunVotes() {// 순대 득표수를 반환
        return voteSun;
    }


}
