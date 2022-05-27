package nttdata.javat1.game;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Fernando Pérez - Class UserInterface
 * 
 * Class that manage all the UI from the game
 *
 */
public class UserInterface {

	/** Logger */
	static final Logger LOG = LoggerFactory.getLogger(UserInterface.class);

	/** Resolution static vars - We need update with the user input so can't be final like sonar says */ 
	public static int consoleWidth = 278;
	public static int blankMultiplier = 7;

	/**
	 * Empty constructor to show that this class is an utility class
	 */
	private UserInterface() {
		throw new IllegalStateException("Utility class");
	}
	

	/**
	 * Method from the main menu
	 */
	public static void menu() {
		int option = 0;
		UserInterface.showMenu(10);
		do {
			option = ask4Number(1, 4, InterfaceConstants.MENU_OPTION_MSG);
			switch (option) {

			case 1:
				Game.newGame();
				break;
			case 2:
				System.out.println("Show ScoreBoard");
				break;
			case 3:
				UserInterface.typeWriteText(InterfaceConstants.MSG_SPEED, StringUtils.center(InterfaceConstants.EXIT_MSG, UserInterface.consoleWidth));
				break;
			case 4:// Exit Option
				UserInterface.typeWriteText(InterfaceConstants.MSG_SPEED, StringUtils.center(InterfaceConstants.EXIT_MSG, UserInterface.consoleWidth));
				SoundEffects.stopSound();
				break;
			default:// Otra opcion error
				UserInterface.typeWriteText(InterfaceConstants.MSG_SPEED, StringUtils.center(InterfaceConstants.ERROR_OPTION_MSG, UserInterface.consoleWidth));
				LOG.debug("Out of range value");
				break;
			}

		} while (option != 4);
	}
	
	/**
	 * Method from the setting menu
	 */
	public static void settingMenu() {
		int option = 0;
		UserInterface.showSettingMenu();
		option = ask4Number(1,3,InterfaceConstants.MENU_OPTION_MSG);
		switch(option) {
			
		case 1:
			consoleWidth = 278;
			blankMultiplier = 7;
			break;
		case 2:
			consoleWidth = 139;
			blankMultiplier = 3;
			break;
		case 3:
			consoleWidth = 100;
			blankMultiplier = 2;
			break;
		default:// Otra opcion error
			UserInterface.typeWriteText(InterfaceConstants.MSG_SPEED,
					StringUtils.center(InterfaceConstants.ERROR_OPTION_MSG, UserInterface.consoleWidth));
			LOG.debug("Out of range value");
			break;
		}
		System.out.println();
		System.out.println(StringUtils.center(InterfaceConstants.LOADING_MSG, UserInterface.consoleWidth));
		System.out.println();
		printSeparator();
	}

	/**
	 * Method that print a separator
	 */
	private static void printSeparator() {
		UserInterface.typeWriteText(50, StringUtils.center(InterfaceConstants.SEPARATOR, UserInterface.consoleWidth));
		System.out.println();
	}

	/**
	 * Method that show the intro sequence of text and images
	 */
	public static void showIntro() {
		System.out.println(multiplyText(4, "\n"));
		UserInterface.typeWriteText(InterfaceConstants.TEXT_SPEED, StringUtils.center("Ahoy ye mateys!", UserInterface.consoleWidth));
		System.out.println("\n");
		UserInterface.typeWriteText(InterfaceConstants.TEXT_SPEED, StringUtils.center("Welcome to the possibly best pinball you've never seen... ", UserInterface.consoleWidth));
		System.out.println(multiplyText(2, "\n"));
		showImage(InterfaceConstants.BOAT, 5);
		System.out.println(multiplyText(3, "\n"));
		UserInterface.typeWriteText(110 ,InterfaceConstants.TEXT_SPEED, InterfaceConstants.INTRODUCTION);
		System.out.println(multiplyText(3, "\n"));
		showImage(InterfaceConstants.LOGO_SIMPLE, 5);
		UserInterface.typeWriteText(InterfaceConstants.TEXT_SPEED, StringUtils.center("T H E   V I D E O G A M E", UserInterface.consoleWidth));
		System.out.println(multiplyText(2, "\n"));
	}

	/**
	 * Method that show the option from main menu
	 * 
	 * @param speed
	 */
	public static void showMenu(int speed) {
		UserInterface.typeWriteText(speed,
				StringUtils.center("-¨¨-_-_-¨¨\\/¨-¨-¨¨-__/¨¨-¨-|", UserInterface.consoleWidth));
		System.out.println();
		UserInterface.typeWriteText(speed,
				StringUtils.center("\\                          /", UserInterface.consoleWidth));
		System.out.println();
		UserInterface.typeWriteText(speed,
				StringUtils.center("\\     1. Nuevo Juego    ,  /", UserInterface.consoleWidth));
		System.out.println();
		UserInterface.typeWriteText(speed,
				StringUtils.center("/                      (   \\", UserInterface.consoleWidth));
		System.out.println();
		UserInterface.typeWriteText(speed,
				StringUtils.center("\\     2. ScoreBoard     `  /", UserInterface.consoleWidth));
		System.out.println();
		UserInterface.typeWriteText(speed,
				StringUtils.center("|                        ` /", UserInterface.consoleWidth));
		System.out.println();
		UserInterface.typeWriteText(speed,
				StringUtils.center("\\     3. Creditos          |", UserInterface.consoleWidth));
		System.out.println();
		UserInterface.typeWriteText(speed,
				StringUtils.center("|                        , /", UserInterface.consoleWidth));
		System.out.println();
		UserInterface.typeWriteText(speed,
				StringUtils.center("\\     4. Salir         ,   \\", UserInterface.consoleWidth));
		System.out.println();
		UserInterface.typeWriteText(speed,
				StringUtils.center("/                     X    /", UserInterface.consoleWidth));
		System.out.println();
		UserInterface.typeWriteText(speed,
				StringUtils.center("\\                          \\", UserInterface.consoleWidth));
		System.out.println();
		UserInterface.typeWriteText(speed,
				StringUtils.center("-__-_-_-¨¨-__¨-¨-_/\\¨-__-¨-|", UserInterface.consoleWidth));
		System.out.println(multiplyText(3, "\n"));
	}
	
	/**
	 * Method that show the option from setting menu
	 */
	private static void showSettingMenu() {
		System.out.println( StringUtils.center("I N I T I A L   S E T T I N G S:", UserInterface.consoleWidth) );
		System.out.println( StringUtils.center("1. - XL (<=  1200px)", UserInterface.consoleWidth) );
		System.out.println( StringUtils.center("2. - L (<=  700px)", UserInterface.consoleWidth) );
		System.out.println( StringUtils.center("3. - S (<  400px)", UserInterface.consoleWidth) );
		
	}

	/**
	 * Method that print ascii art images
	 * 
	 * @param image
	 * @param speed
	 */
	private static void showImage(String[] image, int speed) {
		for (int i = 0; i < image.length; i++) {
			UserInterface.typeWriteText(speed, StringUtils.center(image[i], consoleWidth));
			System.out.println();
		}

	}

	/**
	 * Method that simulates a typewriter typing in console without linebreaks
	 * 
	 * @param speed
	 * @param strings
	 */
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
	
	/**
	 * Method that simulates a typewriter typing in console with linebreaks
	 * 
	 * @param charsPerLine
	 * @param speed
	 * @param strings
	 */
	public static void typeWriteText(int charsPerLine, int speed, String... strings) {
		int counter = 0;
		System.out.print(UserInterface.multiplyText(blankMultiplier, InterfaceConstants.MARGIN));
		for (String i : strings) {
			for (int j = 0; j < i.length(); j++) {
				System.out.print(i.charAt(j));
				counter++;
				if(counter >= charsPerLine && i.charAt(j) == ' ') {
					System.out.println();
					System.out.print(UserInterface.multiplyText(blankMultiplier, InterfaceConstants.MARGIN));
					counter = 0;
				}
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

	/**
	 * @param times
	 * @param text
	 * @return the @param text multiply by the @param times
	 */
	public static String multiplyText(int times, String text) {
		StringBuilder strb = new StringBuilder();
		for (int i = 0; i < times; i++) {
			strb.append(text);
		}
		return strb.toString();
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
				UserInterface.typeWriteText(50, StringUtils.center(msj,UserInterface.consoleWidth));
				number = sc.nextInt();
				
			} catch (InputMismatchException | NumberFormatException ex) {
				
				LOG.error(toStrBuilder("Error cause by ",String.valueOf(ex)));
				UserInterface.typeWriteText(50, StringUtils.center(InterfaceConstants.ERROR_OPTION_MSG,UserInterface.consoleWidth));
				sc.next();
			}
			
		} while (number < start || number > end);

		LOG.info("TRACE END");
		return number;
	}
	

	/**
	 * @return true if the player has pressed 'S' + 'ENTER', it stays in the loop until they do
	 */
	@SuppressWarnings("resource")
	public static boolean shotInput() {
		String launch = " ";
		String exit = "S";
		Scanner sc = new Scanner(System.in);
	
		do{
			try{
				UserInterface.typeWriteText(InterfaceConstants.MSG_SPEED,
						StringUtils.center(InterfaceConstants.SHOTBALL_MSG, UserInterface.consoleWidth));
				launch = sc.next();
				
			} catch (InputMismatchException ime){
				UserInterface.typeWriteText(InterfaceConstants.MSG_SPEED,
						StringUtils.center(InterfaceConstants.SHOTBALL_MSG, UserInterface.consoleWidth));
				sc.next();
			}
			
		} while (!(exit.equalsIgnoreCase(launch)));
		
		UserInterface.typeWriteText(InterfaceConstants.MSG_SPEED, StringUtils.center(InterfaceConstants.BALL_SHOT, UserInterface.consoleWidth));
		return Boolean.TRUE;
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
}
