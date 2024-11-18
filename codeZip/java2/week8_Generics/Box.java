package java2.week8_Generics;

public class Box <T>{
    T contents;
    public Box(T initialContents){
        contents = initialContents;
    }

    public T getContents(){
        return contents;
    }
    public void setContents(T newContents){
        contents = newContents;
    }

    public String toString(){
        return contents.toString();
    }

    // 모든 클래스는 Object로 부터 상속한 toString 메소드를
    // 그대로, 혹은 엎어쓰기 하여 가지고 있다.

}
