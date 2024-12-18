package java2.week13_goodSW2.ver12_Refactoring;

public class Item {
    private String itemName;		// 이 방에 있는 아이템 이름
    private String itemDescription; 	// 이 방에 있는 아이템에 대한 설명
    private int itemweight; 		// 이 방에 있는 아이템 무게

    public Item(String name, String description, int weight){
        itemName = name;
        itemDescription = description;
        itemweight = weight;
    }

    public String getName(){
        return itemName;
    }
    public String getDescription(){
        return itemDescription;
    }
    public int getWeight(){
        return itemweight;
    }
    /**
     * 이 아이템에 대한 상세한 설명을 반환한다.
     *
     * @return 이 아이템에 대한 상세한 설명이 들어 있는 문자열.
     */
    public String getLongDescription() {
        return itemName + " (" + itemweight + "Kg, "+ itemDescription + ")";
    }
}
