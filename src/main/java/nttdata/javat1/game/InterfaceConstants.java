package nttdata.javat1.game;

/**
 * @author Fernando Pérez - InterfaceConstants
 * 
 * Utilitary class with all the constant from interface messages
 *
 */
public class InterfaceConstants {

	
	/**
	 * Empty constructor to let you know that it's not an instantiable class
	 */
	private InterfaceConstants() {
		throw new IllegalStateException("Utility class");
	}
	
	/** Speed message constants  */
	public static final int TEXT_SPEED = 40;
	public static final int MSG_SPEED = 15;
	
	/** Divider and margin */
	public static final String SEPARATOR = "-¨¨-_-_-¨¨\\\\/¨-¨-¨¨-__/¨¨-¨-|-¨¨-_-_-¨¨\\\\/¨-¨-¨¨-__/¨¨-¨-|-¨¨-_-_-¨¨\\\\/¨-¨-¨¨-__/¨¨-¨-|-¨¨-_-_-¨¨\\\\/¨-¨-¨¨-__/¨¨-¨-|";
	public static final String MARGIN = "           ";
	
	/** Game Logo in Ascii Art */
	public static final String[] LOGO_SIMPLE = {" ___ _,_ __,   __, _,   _,  _, _,_    _,  _, __,  _, _, ",
												"  |  |_| |_    |_) |   /_\\ / ` |_/   / ` / \\ |_) /_\\ |  ",
												"  |  | | |     |_) | , | | \\ , | \\   \\ , \\ / | \\ | | | ,",
												"  ~  ~ ~ ~~~   ~   ~~~ ~ ~  ~  ~ ~    ~   ~  ~ ~ ~ ~ ~~~"};
	 /** Intro image */
	public static final String[] BOAT = {"___________________________________________________________________",
										"||     *                            *                    ((   *  ||",
										"||        *                 *                *            ~      ||",
										"||                ___.                          *          *     ||",
										"||       *    ___.\\__|.__.           *                           ||",
										"||            \\__|. .| \\_|.                                      ||",
										"||            . X|___|___| .                         *           ||",
										"||          .__/_||____ ||__.            *                /\\     ||",
										"||  *     .  |/|____ |_\\|_ |/ _                          /  \\    ||",
										"||        \\ _/ |_X__\\|_  |\\||~,~{                       /    \\   ||",
										"||         \\/\\ |/|    |_ |/:|`X'{                   _ _/      \\__||",
										"||          \\ \\/ |___ |_\\|_.|~~~                   /    . .. . ..||",
										"||         _|X/\\ |___\\|_ :| |_.                  - .......... . .||",
										"||         | __\\_:____ |  ||o-|            ___/........ . . .. ..||",
										"||         |/_-|-_|__ \\|_ |/--|       ____/  . . .. . . .. ... . ||",
										"|| ........:| -|- o-o\\_:_\\|o-/:....../...........................||",
										"|| ._._._._._\\=\\====o==o==o=/:.._._._._._._._._._._._._._._._._._||",
										"|| _._._._._._\\_\\ ._._._._.:._._._._._._._._._._._._._.P_._._._._||",
										"|| ._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._||",
										"||---------------------------------------------------------------||"};
	
	
	/** Variables info */
	public static final String INTRODUCTION = "\"The thing is as clear as noonday,\" cried the squire. \"This is the black-hearted hound's account-book. These crosses stand for the names of ships or towns that they sank or plundered. The sums are the scoundrel's share, and where he feared an ambiguity, you see he added something clearer. 'Offe Caraccas,' now; you see, here was some unhappy vessel boarded off that coast. God help the poor souls that manned her — coral long ago...\"";

	/** Pinball sounds */
	protected static final String[] BOUNCE_SOUNDS = {"Boing","Click","Pop"};
	protected static final String[] SHOT_SOUNDS = {"Thunk","Swoosh"};
	protected static final String[] HOLE_SOUNDS = {"Ding, Ding, Ding","Argg","Glop","Zap", "Pom"};
	protected static final String[] RAMP_SOUNDS = {"slither", "Walking the plank"};
	/** Pinball interactions*/
	protected static final String RAMP_MSG = "You'll take the  G A N K P L A N K!";
	protected static final String[] HOLE_MSG = {"Feed the sharks, Arrgh","Go visit Davey Jones' locker, Anchors Away!", "Lookin' for the treasure? There is not in that hole!", "You've found the apple barrels, matey!"};
	public static final String BALL_FALLOFF = "You miss that shot!";
	public static final String BALL_SHOT = "B A A N G!!";
	public static final String USING_ANCHOR = "You have seven lifes mate!";
	/* Option and menu messages */
	public static final String CREDIT_MSG = "Videogame made by Fernando Pérez";
	public static final String MENU_OPTION_MSG = "Choose one option.";
	public static final String EXIT_MSG = "See ya soon, lil'shipboy";
	public static final String ERROR_OPTION_MSG = "Blimey, input a right choice or I'll make you walk the plank";
	public static final String SHOTBALL_MSG = "¡Click 'S' + 'E N T E R'  to shoot the ball. ";
	public static final String LOADING_MSG = "L O A D I N G";
	public static final String SCORE_MSG = "Your total score has been ";
	public static final String GAME_OVER = "G A M E   O V E R";
	
	




	




	




	
	

	
}
