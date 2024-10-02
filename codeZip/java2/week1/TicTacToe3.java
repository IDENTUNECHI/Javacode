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

public class TicTacToe3 {
    public static void main(String[] args) throws InterruptedException{
        char[][] board = new char[3][3];
        int x, y; // 바둑판의 좌표.
        Random r = new Random(1L); // 컴퓨터가 돌을 놓을 자리를 선정할 때 사용할 난수발생기.
        Scanner scan = new Scanner(System.in);
        System.out.println("Tic-Tac-Toe 게임입니다.");
        System.out.println("사람이 X, 컴퓨터가 O입니다.");

        for (int i = 0; i < 3; i++)
                for (int j = 0; j < 3; j++)
                        board[i][j] = ' '; // 모든 칸에 공백문자를 저장한다.

        printBoard(board);

        boolean end = false;
        String winner = null;

        while(!end){ // 게임 종료가 아닌 반복
            // 사람의 입력을 받는다.
            System.out.print("0 이상 3 미만 정수 두 개 입력: ");
            x = scan.nextInt();
            y = scan.nextInt();

            while (!isInputValid(board,x,y)){
                System.out.print("잘못된 위치입니다. 다시 입력하세요: ");
                x = scan.nextInt();
                y = scan.nextInt();
            }
            board[x][y] = 'X';

            printBoard(board);

            if (humanWon(board, x, y)){
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
            int[] c = computerPlay(board, r);// 컴퓨터가 돌을 놓을 곳.
            board[c[0]][c[1]] = 'O';

            printBoard(board);

            if(computerWon(board, c[0], c[1])){
                end = true;
                winner = "Computer";
                continue;
            }
            if(boardFull(board)){
                end = true;
                winner = "Nobody";
            }

        }

        if(winner.equals("Human"))
            System.out.println("당신이 이겼습니다. 축하합니다.");

        else if (winner.equals("Computer"))
            System.out.println("당신이 졌습니다. 다시 도전하세요.");

        else if(winner.equals("Nobody"))
            System.out.println("비겼습니다. 막상막하군요. ");

        scan.close();
    }

    /**
     * 바둑판을 화면에 그린다.
     * @param board 바둑판
     */
    static void printBoard(char[][] board){
        System.out.println();
        for (int i = 0; i < 3; i++){
            System.out.println(" " + board[i][0] + " | " + board[i][1] +" | "+ board[i][2]);
            if (i != 2)
                System.out.println("---|---|---");
        }
        System.out.println();
    }

    /**
     * 현재 바둑판 상태에서 (x, y)가 돌을 놓을 수 있는 점인가?
     * @param board 현재 바둑판 상태.
     * @param x 돌을 놓을 점의 x좌표.
     * @param y 돌을 놓을 점의 y좌표
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
     * 사람이 돌을 놓은 직후, 사람이 이겼는지 검사한다.
     * @param board 현재 바둑판 상태.
     * @param x 새로 놓은 돌의 x좌표
     * @param y 새로 놓은 돌의 y좌표.
     * @return 사람이 이겼으면 true, 그렇지 않으면 false.
     */
    static boolean humanWon (char[][] board, int x, int y){

        boolean allX = true;

        // 돌을 놓은 '행'이 모두 'X' 인지 검사한다.
        for (int j = 0; j<3; j++)
            if (board[x][j] != 'X')
                allX = false;

        if(allX)
            return true;

        // 돌을 놓은 '열'이 모두 'X' 인지 검사한다.
        for (int i = 0; i<3; i++) {
            if (board[i][y] != 'X')
                allX = false;
        }
        if(allX)
            return true;
        // 돌을 놓은 '대각선'이 모두 'X' 인지 검사한다.
        if(x==y){
            allX = true;
            for (int i=0; i<3; i++)
                if (board[i][i] != 'X')
                    allX = false;

            if(allX)
                return true;

        }
        // 돌을 놓은 '엇대각선'이 모두 'X' 인지 검사한다.
        if(x==2-y){
            allX = true;
            for (int i=0; i<3; i++)
                if(board[i][2-i] != 'X')
                    allX = false;

            if(allX)
                return true;
        }
        return false; // 사람이 짐
    }

    /**
     * 컴퓨터가 돌을 놓은 직후 컴퓨터가 이겼는지 검사한다.
     * @param board 현재 바둑판 상태
     * @param x
     * @param y
     * @return 컴퓨터가 이겼으면 true, 그렇지 않으면 false
     */
    static boolean computerWon(char[][] board, int x, int y){
        // 가로, 세로, 혹은 대각선으로 'O'가 한 줄로 세 개 놓여 있으면 true
        // 지금 놓은 위치 (x, y)를 지나는 가로, 세로, 대각선만 검사하면 된다.
        boolean allO = true;
        for (int j = 0; j<3; j++)
            if (board[x][j] != 'O')
                allO = false;

        if(allO)
            return true;

        for (int i = 0; i<3; i++)
            if (board[i][y] != 'O')
                allO = false;

        if(allO)
            return true;

        if(x==y){
            allO = true;
            for (int i=0; i<3; i++)
                if (board[i][y] != 'O')
                    allO = false;

            if(allO)
                return true;

        }

        if(x==2-y){
            allO = true;
            for (int i=0; i<3; i++)
                if(board[i][2-i] != 'O')
                    allO = false;

            if(allO)
                return true;
        }
        return false; // 컴이 짐
    }

    /**
     * 바둑판이 꽉 찼는가?
     * @param board
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
     * @param board
     * @param r
     * @return 돌을 놓을 자리 위치가 들어 있는 정수 배열[x, y]
     */
    static int[] computerPlay(char[][] board, Random r){
        int [] position = new int[2];
        // 무작위로 위치를 결정하는 알고리즘
        int x, y;
        do{
            x= r.nextInt(3);
            y = r.nextInt(3);

        } while (board[x][y] != ' ');

        position[0] = x; // 난수발생기를 이용하여 숫자를 정한다.
        position[1] = y; // 난수발생기를 이용하여 숫자를 정한다.

        return position;
    }



}