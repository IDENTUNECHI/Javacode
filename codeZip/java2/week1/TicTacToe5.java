package java2.week1;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * 오목과 비슷한 삼목 게임.
 * 사람이 놓는 돌 x
 * 컴퓨터가 놓는 돌 O
 * 사람이 먼저 돌을 놓는다.
 * 새 뼈대에 맞춰 구현
 * 추상화, 모듈화, 작은 덩어리로 나누기
 */

public class TicTacToe5 {

    public static void main(String[] args) throws InterruptedException {

        // 컴퓨터가 돌을 놓을 자리를 선정할 때 사용할 난수발생기.

        System.out.println("Tic-Tac-Toe 게임입니다.");
        System.out.println("사람이 X, 컴퓨터가 O입니다.");

        Scanner scan = new Scanner(System.in);

        char [][] board = new char[3][3];

        Random r = new Random(1L);

        intBord(board);
        printBoard(board);

        boolean end = false;
        String winner = null;

        while(!end){ // 게임 종료가 아닌 반복
            // 사람이 돌을 놓는다.
            int[] h = humanPlay(board, scan);
            printBoard(board);

            if (won(board, h[0], h[1])){
                end = true;
                winner = "Human";
                continue;
            }
            if (boardFull(board)){
                end = true;
                winner = "Nobody"; // 사람이 이기지 못했는데 보드가 꽉 찼다면 비긴것이다.
                continue;
            }

            TimeUnit.MILLISECONDS.sleep(300); // 0.3초 후에 컴퓨터가 돌을 놓는다.

            // 컴퓨터가 돌을 놓는다.
            int [] c = computerPlay(board,r);
            printBoard(board);

            if(won(board, c[0], c[1])){
                end = true;
                winner = "Computer";
                continue;
            }
            if(boardFull(board)){
                end = true;
                winner = "Nobody";
            }

        }

        printResult(winner);
        scan.close();
    }

    /**
     * 바둑판 초기화
     */
    static void intBord(char[][] board){
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = ' '; // 모든 칸에 공백문자를 저장한다.
    }

    /**
     * 바둑판을 화면에 그린다.
     */
    static void printBoard(char[][] board)
    {
        System.out.println();
        for (int i = 0; i < 3; i++){
            System.out.println(" " + board[i][0] + " | " + board[i][1] +" | "+ board[i][2]);
            if (i != 2)
                System.out.println("---|---|---");
        }
        System.out.println();
    }

    /**
     * 사람이 돌을 놓는다.
     * @param scan 키보드에 연결된 Scanner
     * @param board
     * @return 사람이 돌을 놓은 위치
     */
    static int[] humanPlay(char[][] board, Scanner scan){
        // 사람의 입력을 받는다.

        System.out.print("0 이상 3 미만 정수 두 개 입력: ");
        int x = scan.nextInt();
        int y = scan.nextInt();

        while (!isInputValid(board, x, y)){
            System.out.print("잘못된 위치입니다. 다시 입력하세요: ");
            x = scan.nextInt();
            y = scan.nextInt();
        }
        board[x][y] = 'X';

        return new int[] {x, y};
    }

    static void printResult(String winner){

        if(winner.equals("Human"))
            System.out.println("당신이 이겼습니다. 축하합니다.");

        else if (winner.equals("Computer"))
            System.out.println("당신이 졌습니다. 다시 도전하세요.");

        else if(winner.equals("Nobody"))
            System.out.println("비겼습니다. 막상막하군요. ");

    }
    /**
     * 현재 바둑판 상태에서 (x, y)가 돌을 놓을 수 있는 점인가?
     * @return 가능한 점이면 true, 그렇지 않으면 false
     */
    static boolean isInputValid(char[][] board, int x, int y){
        // x, y 각각이 0보다 작거나 2보다 크면 false
        // (x,y) 위치에 이미 돌이 놓여 있으면 false
        // 그렇지 않으면 true
        boolean valid = true;
        if(x < 0 || x> 2 || y<0 || y>2)
            valid = false;
        else if (board[x][y] != ' ')
            valid = false;
        return valid;
    }
    /**
     * 주어진 위치에서 플레이어가 승리했는지 검사한다.
     * @return 플레이어가 이겼으면 true, 그렇지 않으면 false
     */
    static boolean won(char[][] board, int x, int y) {
        // 가로, 세로 체크
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ')
                return true;
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != ' ')
                return true;
        }

        // 대각선 체크
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ')
            return true;
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ')
            return true;

        return false;
    }
    /**
     * 바둑판이 꽉 찼는가?
     * @return 꽉 찼으면 true 그렇지 않으면 false
     */
    static boolean boardFull(char[][] board){
        boolean full = true;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(board[i][j] == ' '){
                    full = false;
                }
            }
        }

        return full;
    }
    /**
     * 현재 바둑판 상태에서 컴퓨터가 돌을 놓을 자리를 결정한다.
     * 값 두 개를 반환해야 하므로 두 값을 배열에 넣어 반환한다.
     * @param r 난수
     */
    static int[] computerPlay(char[][] board, Random r){
        // 무작위로 위치를 결정하는 알고리즘
        int x, y;
        do{
            x = r.nextInt(3);
            y = r.nextInt(3);

        } while (board[x][y] != ' ');

        board[x][y] = 'O';

        return new int[] {x, y};
    }
}
