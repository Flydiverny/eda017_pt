package se.markusmaga.lth.pt.helper;
import java.util.*;
import se.lth.cs.pt.io.Keyboard;

public class MenuHandler {

	private List<MenuAction> menuActions;

	/**
	 * Initializes a new MenuHandler
	 */
	public MenuHandler() {
		menuActions = new ArrayList<MenuAction>();
	}
	
	/**
	 * Adds a MenuAction to the menu.
	 * @param ma - MenuAction to add.
	 */
	public void add(MenuAction ma) {
		menuActions.add(ma);
	}
	
	/**
	 * Prints menu to console and asks for user input,
	 * then executes the menu actions callback.
	 */
	public void showMenuAndExecuteAction() {
		int alternatives = menuActions.size(); 
		
		System.out.println("\nVad vill du g�ra:");
		
		for (int i = 1; i < alternatives; i++) {
			System.out.println(i + ". " + menuActions.get(i));
		}
		
		System.out.println("0. " + menuActions.get(0)); // We want Quit to list last
		
		String userPrompt = "Ange kommando (0-" + (alternatives-1) + "): ";
		
		System.out.print(userPrompt);
		while (!Keyboard.hasNextInt()) {
			System.out.print("Du m�ste skriva in ett heltal, f�rs�k igen: ");
			Keyboard.nextLine();
		}
		
		int val = Keyboard.nextInt();

		while (!(val < alternatives && val >= 0)) {
			System.out.print("Ogiltigt val, " + userPrompt);
			while (!Keyboard.hasNextInt()) {
				System.out.print("Du m�ste skriva in ett heltal, f�rs�k igen: ");
				Keyboard.nextLine();
			}
			val = Keyboard.nextInt();
		}

		System.out.println("");
		
		menuActions.get(val).execute();
    }
}