package java2.week8_Generics;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {

    // HumanComparator 이용하여 학생을 사람으로서 먼저 비교
    // 즉, 이름과 나이를 차례로 비교한다.
    // 만약, 이름과 나이가 같으면 학번을 비교한다.
    public int compare(Student s1, Student s2) {
       HumanComparator hc = new HumanComparator();

       if(hc.compare(s1, s2) == 0){
           if(s1.studentId != s2.studentId)
               return -1;
           else
               return 0;
       }
       else
           return 1;
    }
}
