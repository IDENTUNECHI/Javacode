package java2.week13_goodSW2.ver12_Refactoring;

public class Player {
    private Room currentRoom; // 지금 있는 방
    private Room recentRoom; // 최근에 있던 방

    /**
     * constructor
     * @param startRoom 이 선수가 처음 게임ㅁ을 시작할 방
     */
    public Player(Room startRoom){
        currentRoom = startRoom;
        recentRoom = null;
    }

    /**|
     * 주어진 방향으로 옮겨간다.
     * 그 방향으로 출구가 없으면 현재 위치에 머문다.
     * @param direction 옮겨갈 방향
     * @return 성공했으면 0, 실패했으면 -1.
     */
    int moveTo(String direction){
        Room nextRoom = null;

        nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            return -1;
        } else {
            recentRoom = currentRoom;
            currentRoom = nextRoom; // 방을 변경
            return 0;
        }
    }

    /**
     * 선수가 현재 있는 방을 반환한다.
     */

    public Room getCurrentRoom() {
        return currentRoom;
    }

    /**
     * 이전 방으로 돌아간다.
     */
    public void back() {
        currentRoom = recentRoom;
    }



}
