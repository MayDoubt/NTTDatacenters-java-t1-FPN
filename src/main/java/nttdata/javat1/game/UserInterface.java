package nttdata.javat1.game;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserInterface {

	/** Logger */
	static final Logger LOG = LoggerFactory.getLogger(UserInterface.class);

	public static final int CONSOLE_WIDTH = 278;

	private UserInterface() {
		throw new IllegalStateException("Utility class");
	}

	public static void showIntro() {
		System.out.println(multiplyText(4, "\n"));
		UserInterface.typeWriteText(50, StringUtils.center("Ahoy ye mateys!", UserInterface.CONSOLE_WIDTH));
		System.out.println("\n");
		UserInterface.typeWriteText(50, StringUtils.center("Welcome to the possibly best pinball you've never seen... ", UserInterface.CONSOLE_WIDTH));
		System.out.println(multiplyText(2, "\n"));
		showImage(InterfaceConstants.BOAT, 5);
		System.out.println(multiplyText(3, "\n"));
		showImage(InterfaceConstants.LOGO_SIMPLE, 5);
		UserInterface.typeWriteText(50, StringUtils.center("T H E   V I D E O G A M E", UserInterface.CONSOLE_WIDTH));
		System.out.println(multiplyText(2, "\n"));
	}

	public static void showMenu(int speed) {
		UserInterface.typeWriteText(speed,
				StringUtils.center("-¨¨-_-_-¨¨\\/¨-¨-¨¨-__/¨¨-¨-|", UserInterface.CONSOLE_WIDTH));
		System.out.println();
		UserInterface.typeWriteText(speed,
				StringUtils.center("\\                          /", UserInterface.CONSOLE_WIDTH));
		System.out.println();
		UserInterface.typeWriteText(speed,
				StringUtils.center("\\     1. Nuevo Juego    ,  /", UserInterface.CONSOLE_WIDTH));
		System.out.println();
		UserInterface.typeWriteText(speed,
				StringUtils.center("/                      (   \\", UserInterface.CONSOLE_WIDTH));
		System.out.println();
		UserInterface.typeWriteText(speed,
				StringUtils.center("\\     2. ScoreBoard     `  /", UserInterface.CONSOLE_WIDTH));
		System.out.println();
		UserInterface.typeWriteText(speed,
				StringUtils.center("|                        ` /", UserInterface.CONSOLE_WIDTH));
		System.out.println();
		UserInterface.typeWriteText(speed,
				StringUtils.center("\\     3. Creditos          |", UserInterface.CONSOLE_WIDTH));
		System.out.println();
		UserInterface.typeWriteText(speed,
				StringUtils.center("|                        , /", UserInterface.CONSOLE_WIDTH));
		System.out.println();
		UserInterface.typeWriteText(speed,
				StringUtils.center("\\     4. Salir         ,   \\", UserInterface.CONSOLE_WIDTH));
		System.out.println();
		UserInterface.typeWriteText(speed,
				StringUtils.center("/                     X    /", UserInterface.CONSOLE_WIDTH));
		System.out.println();
		UserInterface.typeWriteText(speed,
				StringUtils.center("\\                          \\", UserInterface.CONSOLE_WIDTH));
		System.out.println();
		UserInterface.typeWriteText(speed,
				StringUtils.center("-__-_-_-¨¨-__¨-¨-_/\\¨-__-¨-|", UserInterface.CONSOLE_WIDTH));
		System.out.println(multiplyText(3, "\n"));
	}

	private static void showImage(String[] image, int speed) {
		for (int i = 0; i < image.length; i++) {
			UserInterface.typeWriteText(speed, StringUtils.center(image[i], CONSOLE_WIDTH));
			System.out.println();
		}

	}

	public static void typeWriteText(int speed, String... strings) {

		for (String i : strings) {
			for (int j = 0; j < i.length(); j++) {
				System.out.print(i.charAt(j));
				try {
					if (i.charAt(j) != ' ') {
						Thread.sleep(speed);
					}
				} catch (InterruptedException e) {
					LOG.warn("Interrupted typewrite effect!", e);
					// restore interrupted state...
					Thread.currentThread().interrupt();
				}
			}
		}
	}

	private static String multiplyText(int times, String text) {
		StringBuilder strb = new StringBuilder();
		for (int i = 0; i < times; i++) {
			strb.append(text);
		}
		return strb.toString();
	}

	public static void menu() {
		int option = 0;
		UserInterface.showMenu(10);
		do {
			option = ask4Number(0,4,InterfaceConstants.MENU_OPTION_MSG);
			switch(option) {
			
				case 1:
					printSeparator();
					Game.newGame();
					printSeparator();
					break;
				case 2:
					printSeparator();
					System.out.println("Show ScoreBoard");
					printSeparator();
					break;
				case 3:
					printSeparator();
					System.out.println("Show Prices");
					printSeparator();
					break;
				case 4:// Exit Option
					printSeparator();
					UserInterface.typeWriteText(InterfaceConstants.MSG_SPEED, StringUtils.center(InterfaceConstants.EXIT_MSG, UserInterface.CONSOLE_WIDTH));
					printSeparator();
					SoundEffects.stopSound();
					break;
				default:// Otra opcion error
					printSeparator();
					UserInterface.typeWriteText(InterfaceConstants.MSG_SPEED, StringUtils.center(InterfaceConstants.ERROR_OPTION_MSG, UserInterface.CONSOLE_WIDTH));
					LOG.debug("Out of range value");
					printSeparator();
					break;
			}

		}while(option!=4);
	}
	
	private static void printSeparator() {
		UserInterface.typeWriteText(50, StringUtils.center(InterfaceConstants.SEPARATOR, UserInterface.CONSOLE_WIDTH));
		
	}

	/**
	 * @param start
	 * @param end
	 * @param message
	 * 
	 * Ask for a int between two values
	 * 
	 * @return int
	 */
	@SuppressWarnings("resource")
	private static int ask4Number(int start, int end, String message) {

		LOG.info("TRACE INIT");

		int number = 0;
		Scanner sc;
		sc = new Scanner(System.in);
		do {
			try {
				String msj = toStrBuilder(message, "Introduce a number between ", String.valueOf(start),
						" and ", String.valueOf(end), ": ");
				UserInterface.typeWriteText(50, StringUtils.center(msj,UserInterface.CONSOLE_WIDTH));
				number = sc.nextInt();
			} catch (InputMismatchException | NumberFormatException ex) {
				LOG.error(toStrBuilder("Error cause by ",String.valueOf(ex)));
				UserInterface.typeWriteText(50, StringUtils.center(InterfaceConstants.ERROR_OPTION_MSG,UserInterface.CONSOLE_WIDTH));
				sc.next();
			}
		} while (number < start || number > end);

		LOG.info("TRACE END");
		return number;
	}
	
	/**
	 * @param args
	 * 
	 * Concat any number of Strings with an StringBuilder
	 * 
	 * @return String
	 */
	public static String toStrBuilder(final String... args) {

		StringBuilder strb = new StringBuilder();
		for (String str : args) {
			strb.append(str);
		}
		return strb.toString();
	}
	
	//Ask for a key
	public static boolean ask4Words(String text) {
		String n = "";
		String exit = " ";
		Scanner sc = new Scanner(System.in);
	
		//Read a word != exit
		do{
			try{
				System.out.print(text);
				n = sc.nextLine();
				
			} catch (InputMismatchException ime){
				System.out.println("¡Click S P A C E to shot the ball. ");
				sc.next();
			}
		} while (n.equalsIgnoreCase(exit));
		
		System.out.println("B A A N G!!");
		sc.close();
		return Boolean.TRUE;
	}
}
