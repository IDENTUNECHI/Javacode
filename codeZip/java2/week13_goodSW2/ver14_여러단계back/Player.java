package java2.week13_goodSW2.ver14_여러단계back;

import java.util.*;

public class Player {
    private Room currentRoom; // 지금 있는 방
    private int maxWeight; // 들 수 있는 최대 무게
    private List<Item> items; // 이 선수가 가지고 있는 아이템들
    private Stack<Room> pastRooms; // 거쳐온 방들
    /**
     * constructor
     * @param startRoom 이 선수가 처음 게임을 시작할 방
     * @param maxWeight 최대 무게
     */
    public Player(Room startRoom, int maxWeight){
        currentRoom = startRoom;
        this.maxWeight = maxWeight;
        items = new ArrayList<>();
        pastRooms = new Stack<>();
    }

    /**
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
            pastRooms.push(currentRoom);
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
        if(!pastRooms.isEmpty()){
            currentRoom = pastRooms.pop();
        }
    }

    /**
     * 아이템을 잡는다
     * @param name 집어 들 아이템의 이름.
     * @return 집어 든 아이템(성공한 경우), null (실패한 경우)
     */
    public Item takeItem(String name){
        Item item = currentRoom.removeItem(name);

        if (item != null) { // 제거에 성공한 경우
            if(pickable(item)) // 아이템을 잡을 수 있나?
                items.add(item); // 아이템을 선수의 컬렉션에 넣는다.
            else {
                currentRoom.addItem(item);
                item = null; // 실패한 경우로 간주함.
            }
        }
        return item;
    }

    private boolean pickable(Item item) {
        if (item.getWeight() + totalWeight() > maxWeight)
            return false;
        else
            return true;
    }

    /**
     * 이 선수가 가지고 있는 아이템들의 총 무게
     */
    private int totalWeight() {
        Iterator<Item> it = items.iterator();
        int sum = 0;
        while(it.hasNext())
            sum += it.next().getWeight();
        return sum;
    }

    /**
     * 아이템을 잡는다
     * @param name 집어 들 아이템의 이름.
     * @return 집어 든 아이템(성공한 경우), null (실패한 경우)
     */
    public Item dropItem(String name){

        Iterator<Item> it = items.iterator();

        while(it.hasNext()){
            Item item = it.next();
            if(item.getName().equals(name)) {// 아이템을 잡을 수 있나?
                it.remove();
                currentRoom.addItem(item); // 현재 방에 그 아이템을 넣고
                return item; // 그 아이템을 반환
            }
        }
        return null;
    }

    /**
     * 선수가 가지고 있는 아이템들의 list반환
     * 단, 반환되는 list는 수정할 수 없는 list이다.
     * @return 선수가 가지고 있는 아이템들의 list.
     */
    public List<Item> getItems(){
        return Collections.unmodifiableList(items);
    }

    public int getMaxWeight() {
        return maxWeight;
    }
}
