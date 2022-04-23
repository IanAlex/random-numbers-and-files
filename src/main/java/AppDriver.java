
import java.util.Scanner;

public class AppDriver {

	public static void main(String[] args) {
		runMenu();
	}
	
	private static void runMenu() {
		Scanner scanner = new Scanner(System.in);
		String userInput = "";
		String inFileName = "";
		String outFileName = "";
		RandomFileWorker rfw = new RandomFileWorker();
		boolean exitApp = false;
		while (true) {
			if (exitApp) {
				scanner.close();
				break;
			}
			System.out.println("");
			System.out.println("**Choose from Options**");
			System.out.println("Press 1 to create file with a million random numbers (unordered)");
			System.out.println("Press 2 to create file with a million ORDEREd random numbers");
			System.out.println("Press 3 to transfer random numbers from file and put them in order into a another file");
			System.out.println("Press 4 to exit this application");
			
			userInput = scanner.next();
			switch(userInput) {
			   case "1":
				   System.out.println("What is output file name for random numbers?:");
				   outFileName = scanner.next();
				   rfw.writeUnorderedRandomsToFile(outFileName);
				   break;
			   case "2":
				   System.out.println("What is output file name for ORDERED random numbers?:");
				   outFileName = scanner.next();
				   rfw.writeOrderedRandomsToFile(outFileName);
				   break;
			   case "3":
				   System.out.println("What is source file name for random numbers?");
				   inFileName = scanner.next();
				   System.out.println("What is destination file name for ORDERED random numbers?");
				   outFileName = scanner.next();
				   rfw.writeRandomsInOrderFromOneFileToAnother(inFileName, outFileName);
				   break;
			   case "4":
				   System.out.println("Exiting the application.");
				   exitApp = true;
				   break;
				default:
					System.out.println("Invalid choice.  Please try again.");
			}
		}
	}

}
