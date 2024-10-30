package Java2Practice.Exception;
import java.io.*;
import java.util.*;

public class FileProcessor3 {
    /**
     * 파일로 부터 단어들을 읽어 이들을 ArrayList에 넣은 후
     * ArrayList를 반환한다.
     * @param fileName 파일 이름.
     * @return 단어들이 들어 있는 리스트.
     * @throws FileNotFoundException 주어진 이름의 파일이 존재하지 않는 경우.
     */

    public List<String> readFile(String fileName) throws FileNotFoundException{
        ArrayList<String> list = new ArrayList<>();
        Scanner fileScanner = new Scanner(new File(fileName));

        while (fileScanner.hasNext()) {
            list.add(fileScanner.next());
        }
        fileScanner.close();
        return list;
    }

    /**
     * 주어진 리스트에 들어 있는 단어들의 순서르 바꿔
     * 새 ArrayList에 넣어 반환
     * @param list 단어들이 들어 있는 리스트
     * @return 순서가 바뀐 단어들이 들어 있는 새 ArrayList
     */
    public List<String> backwards(List<String> list) {
        ArrayList<String> backList = new ArrayList<>();
        ListIterator<String> it = list.listIterator(list.size());

        while(it.hasPrevious()){
            backList.add(it.previous());
        }

        return backList;
    }


    /**
     * 리스트에 들어 있는 단어들 중
     * 주어진 문자열로 끝나는 단어들을 삭제해준다.
     *
     * @param list 단어들이 들어 있는 리스트.
     * @param s    문자열
     */
    public void discardWords(List<String> list, String s) {
        Iterator<String> it = list.iterator();

        while(it.hasNext()){
            String str = it.next();
            if(str.endsWith(s)){
                it.remove();
            }
        }
    }

    /**
     * 리스트에 들어 있는 단어들 중
     * 주어진 문자열로 끝나는 단어들을 삭제해준다
     * @param list 단어들이 들어 있는 리스트
     * @param s 문자열
     */
    public void discardWords2(List<String> list, String s) {
        // not use iterator

        int position = 0;

        while(position<list.size()){
            String str = list.get(position);
            if(str.endsWith(s)){
                list.remove(position);
            }
            else{
                position++;
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException{
        FileProcessor3 fileProcessor3 = new FileProcessor3();

        String fileName = "C:\\Users\\rladl\\IdeaProjects\\Javastudy\\codeZip\\Java2Practice\\Exception\\words.txt";
//------------------------------------------------------------------//
        // 걍 list
        List<String> list1 = fileProcessor3.readFile(fileName);
        System.out.println(list1);

        // 순서 바꾼 list
        List<String> listReversed = fileProcessor3.backwards(list1);
        System.out.println(listReversed);

        // "fy" 로 끝나는 단어들을 삭제한다.

        String s = "fy";

        fileProcessor3.discardWords(list1, s);
        System.out.println(list1);

        // "er"로 끝나는 단어들을 삭제한다.
        String s2 = "er";

        fileProcessor3.discardWords(listReversed, s2);
        System.out.println(listReversed);

    }
}
