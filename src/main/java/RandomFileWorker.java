
import java.util.*;
import java.util.stream.Collectors;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class RandomFileWorker {
	
	final static int MILLION = 1000000;
	final static String DELIMITER = " ";
	
	public void writeUnorderedRandomsToFile(String fileName) {
		if(writeRandomsToFile(generateMillionRandoms(), fileName)) {
		System.out.println("Wrote unordered randoms to file: " + fileName);
		} 
		else {
			System.out.println("Could not write unordered randoms to file: " + fileName);
		}
		try {
		  Thread.sleep(4);
		} catch (InterruptedException ex) {}
	}
	
	public void writeOrderedRandomsToFile(String fileName) {
		if(writeRandomsToFile(generateMillionOrderedRandoms(), fileName)) {
		System.out.println("Wrote ordered randoms to file: " + fileName);
		}
		else {
			System.out.println("Could not write ordered randoms to file: " + fileName);
		}
		try {
			  Thread.sleep(4);
		} catch (InterruptedException ex) {}
	}
	
	public void writeRandomsInOrderFromOneFileToAnother(String inFileName, String outFileName) {
		List<Integer> randomsFromInFile = readRandomsFromFile(inFileName);
		if (!randomsFromInFile.isEmpty()) {
			Collections.sort(randomsFromInFile);
			if(writeRandomsToFile(randomsFromInFile, outFileName)) {
			   System.out.println("Wrote randoms in order from file: " + inFileName + " to file: " + outFileName);
			}
			else {
			   System.out.println("Unable to write randoms in order from file: " + inFileName + " to file: " + outFileName);
			}
		}
		try {
			  Thread.sleep(4);
		} catch (InterruptedException ex) {}
	}
	
	private List<Integer> readRandomsFromFile(String fileName) {
		List<Integer> randoms = new ArrayList<>();
		File file = new File(fileName);
		if (!file.exists()) {
			System.out.println("File with name: " + fileName + " does not exist.");
		} 
		else {
			BufferedReader br = null;
			try {
				br = new BufferedReader(new FileReader(fileName));
				String randomsLine = br.readLine();
				String [] randomsTextArr = randomsLine.split(DELIMITER);
				for (String randomStr : randomsTextArr) {
					try {
						randoms.add(Integer.parseInt(randomStr));
					} catch (NumberFormatException nfe) {
						System.out.println("Bad (non-numeric) data encountered");
						randoms = new ArrayList<>();
						break;
					}
				}
				System.out.println("Read randoms from file: " + fileName);
				br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return randoms;
	}
	
	private boolean writeRandomsToFile(List<Integer> randoms, String fileName) {
		deleteFileIfExists(fileName);
		FileWriter fileWriter = null;
		boolean OKFlag = true;
		try {
		   fileWriter = new FileWriter(fileName);
		   StringBuffer delimitedRandoms = new StringBuffer();
		   randoms.forEach(r -> delimitedRandoms.append(r + DELIMITER));
		   fileWriter.write(delimitedRandoms.toString());
		   fileWriter.close();
		} catch (IOException ex) {
			ex.printStackTrace();
			OKFlag = false;
		} 
		return OKFlag;
	}
	
	private List<Integer> generateMillionRandoms() {
		List<Integer> randoms = new ArrayList<>();
		Random randomNum = new Random();
		for (int i = 0; i < MILLION; i++) {
			randoms.add(randomNum.nextInt());
		}
		return randoms;
	}
	
	private List<Integer> generateMillionOrderedRandoms() {
		List<Integer> randoms = generateMillionRandoms();
		Collections.sort(randoms);
		return randoms;
	}
	
	private void deleteFileIfExists(String fileName) {
		File file = new File(fileName);
		if (file.exists()) {;
			file.delete();
		}
	}

}
