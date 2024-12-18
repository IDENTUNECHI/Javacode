package java2.week13_goodSW2.ver9;

import java.util.Scanner;

/**
 * 사용자 입력을 분석하고, 입력에 해당하는 Command 객체를 만들어주는 일을 함
 */
public class Parser {
	private CommandWords commands; // 유효한 명령어들을 보관하고 있는 객체
	private Scanner reader; // 명령이 입력되는 곳

	/**
	 * Create a parser to read from the terminal window.
	 */
	public Parser() {
		commands = new CommandWords();
		reader = new Scanner(System.in);
	}

	/**
	 * @return The next command from the user.
	 */
	public Command getCommand() {
		String inputLine; // will hold the full input line
		String word1 = null;
		String word2 = null;

		System.out.print("> "); // print prompt

		inputLine = reader.nextLine();

		// Find up to two words on the line.
		Scanner tokenizer = new Scanner(inputLine);
		if (tokenizer.hasNext()) {
			word1 = tokenizer.next(); // get first word
			if (tokenizer.hasNext()) {
				word2 = tokenizer.next(); // get second word
				// note: we just ignore the rest of the input line.
			}
		}
		tokenizer.close();

		// Now check whether this word is known. If so, create a command
		// with it. If not, create a "null" command (for unknown command).
		if (commands.isCommand(word1)) {
			return new Command(word1, word2);
		} else {
			return new Command(null, word2);
		}

	}

	/**
	 * 모든 명령어들을 화면에 출력한다.
	 */
	public String getCommandList() {
		return commands.getCommandList();
	}
}
