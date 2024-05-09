package homework.function;

/**
* 10부터 20까지... 20부터 30까지.. 꼴과 같은 10차이 나는 자연수 합을 구하는 프로그램
* @author 김이든
*/
public class Summations2 {
	public static void main(String[] args) {
		
		for(int i = 10; i<=90; i+=10){
		System.out.printf("%d부터  %d까지의 자연수의 합 = %d", i, i+10, sum(i, i+10));
		System.out.println();
		}
	}
/**
* 값을 반환하는 함수
* @param from 구간의 시작 값
* @param to		구간의 끝 값
* @return sum 구간의 합
*/
	public static int sum(int from, int to){
		int sum = 0;
		for (int i = from; i<= to; i++){
			sum += i;
		}
		return sum;
		}
  }
