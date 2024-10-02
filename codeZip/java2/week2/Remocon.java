package java2.week2;
/**
 * 음량과 채널 조절 기능만 있는 간단한 리모콘
 * @author 김이든
 */

public class Remocon {
    // 필드
    private int volume = 0;
    private int channel = 0;
    public final static int MAX_VOLUME = 3;// 최고 음량
    public final static int MAX_CHANNEL = 3; // 채널 번호 최대값
    // 음량 최소값은 0
    // 채널 번호 최소값도 0


    /**
     * 음량을 한 단계 높인다.
     * 현재 음량이 최대이면 음량이 바뀌지 않는다.
      */
    public void volumeUp() {
        if(volume < MAX_VOLUME)
            volume++;
        display();
    }

    /**
     * 음량을 한 단계 낮춘다.
     * 현재 음량이 0이면 음량이 바뀌지 않는다.
     */
    public void volumeDown() {
        if(volume > 0) {
            volume--;
        }
        display();

    }

    /**
     * 한 단계 높은 번호로 채널을 변경한다.
     */
    public void channelUp() {
        if(channel < MAX_CHANNEL)
            channel++;

        else
         channel = 0;

        display();
    }


    /**
     * 한 단계 낮은 번호로 채널을 변경한다
     * 현재 0번 채널에 있다면 가장 높은 번호의 채널로 이동한다
     */
    public void channelDown() {
        if(channel == 0)
            channel = MAX_CHANNEL;
        else
            channel--;

        display();

    }

    /**
     * 현재의 volume, channel 상태를 화면에 보여준다.
     */
    public void display() {
        System.out.println("Volune = " + volume + ", Channel = "+channel);
        System.out.println();

    }
}
