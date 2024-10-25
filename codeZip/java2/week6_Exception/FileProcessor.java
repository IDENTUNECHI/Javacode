package java2.week6_Exception;
import java.io.*;
import java.util.*;

public class FileProcessor {

    /**
     * 파일로부터 단어들을 읽어 이들을 ArrayList에 넣은 후
     * ArrayList를 반환
     * @param fileName 파일이름
     * @return 단어들이 들어 있는 리스트
     * @throws FileNotFoundException 주어진 이름의 파일이 존재하지 않는 경우
     */
    public List<String> readFiles(String fileName) throws FileNotFoundException {
        List<String> list = new ArrayList<>();
        Scanner input = new Scanner(new File(fileName), "UTF-8");

        while (input.hasNextLine()) {
            String line = input.nextLine();
            // BOM 제거 (첫 번째 줄에 BOM이 있는 경우)
            if (list.isEmpty() && line.startsWith("\uFEFF")) {
                line = line.substring(1);
            }
            // 각 라인의 단어를 공백으로 분리하여 리스트에 추가
            String[] words = line.split("\\s+");
            Collections.addAll(list, words);
        }
        input.close();

        return list;
    }

    /**
     * 주어진 리스트에 들어 있는 단어들의 순서를 바꿔
     * 새 ArrayList에 넣어 반환한다.
     * @param list 단어들이 들어 있는 리스트
     * @return 순서가 바뀐 단어들이 들어 있는 새 ArrayList.
     */
    public List<String> backwards(List<String> list) {
        List<String> reverseList = new ArrayList<>(list);
        Collections.reverse(reverseList);  // 리스트의 순서를 역순으로 변경
        return reverseList;
    }

    public static void main(String[] args) {
        try {
            // FileProcessor 인스턴스를 하나 구성한다.
            FileProcessor fp = new FileProcessor();


            // words.txt 파일의 단어들이 저장된 리스트를 얻는다.
            String fileName = "C:\\Users\\rladl\\IdeaProjects\\Javastudy\\codeZip\\java2\\week6_Exception\\words.txt";
            List<String> wordList = fp.readFiles(fileName);
            Iterator<String> iterator = wordList.iterator();
            // 리스트를 출력한다.
            ;

            System.out.println(wordList);


            // 리스트에 있는 단어들의 순서를 바꾼 새 리스트를 얻는다.
            List<String> reversedList = fp.backwards(wordList);

            // 새 리스트를 출력한다.
            System.out.println(reversedList);

        } catch (FileNotFoundException e) {
            System.err.println("파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
        }
    }
}
