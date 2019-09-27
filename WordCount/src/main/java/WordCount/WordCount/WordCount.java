package WordCount.WordCount;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class WordCount {

	public static void main(String[] args) {

		File passage = new File("passage.txt");
		int wordCounter = 0;
		List<String> words = new ArrayList<String>();
		Map<String, Integer> repeatedWords = new HashMap<String, Integer>();
		int repeatedWordUsedCounter = 1;
		List<Integer> repeatedWordsValues = new ArrayList<Integer>();
		List<String> top10Words = new ArrayList<String>();
		List<String> linesWithMostUsedWord = new ArrayList<String>();
		List<String> fileInList = new ArrayList<String>();

		try (Scanner fileScanner = new Scanner(passage)) {

			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine().strip();

				if (!line.isEmpty()) {

					String[] lineArray = line.split(" ");
					wordCounter += lineArray.length;

					for (int i = 0; i < lineArray.length; i++) {

						if (lineArray[i].contains(".")) {
							String word = lineArray[i].replace(".", "");
							if (word.endsWith("\"")) {
								String word2 = word.replace("\"", "");
								words.add(word2);
							} else {
								words.add(word);
							}

						} else if (lineArray[i].contains(":")) {
							String word = lineArray[i].replace(":", "");
							words.add(word);
						} else if (lineArray[i].contains(",")) {
							String word = lineArray[i].replace(",", "");
							words.add(word);
						} else if (lineArray[i].startsWith("\"")) {
							String word = lineArray[i].replace("\"", "");
							words.add(word);
						} else if (lineArray[i].endsWith("\"")) {
							String word = lineArray[i].replace("\"", "");
							words.add(word);
						} else {
							words.add(lineArray[i]);
						}

					}

				}
			}

		} catch (Exception e) {
			System.out.println("File not found");
			e.printStackTrace();
		}

		for (int i = 0, j = i + 1; i < words.size();) {

			if ((j == words.size() - 1 || j == words.size())) {
				repeatedWords.put(words.get(i).toLowerCase(), repeatedWordUsedCounter);
				repeatedWordUsedCounter = 1;
				i++;
				j = i + 1;

			}

			else if (repeatedWords.containsKey(words.get(i).toLowerCase())) {
				i++;
				j = i + 1;
			}

			else if (words.get(i).equalsIgnoreCase(words.get(j))) {

				repeatedWordUsedCounter += 1;
				j++;

			} else {
				j++;
			}
		}

		repeatedWordsValues.addAll(repeatedWords.values());
		Collections.sort(repeatedWordsValues, Collections.reverseOrder());
		int last_value = -1;

		for (Integer value : repeatedWordsValues.subList(0, 10)) {
			if (last_value == value) // prevents duplicates of the word ,that matches the 'value', being put into the
										// list later on in this 'for' loop.
				continue;
			last_value = value;

			for (String word : repeatedWords.keySet()) {
				if (repeatedWords.get(word) == value && top10Words.size() < 10) {
					top10Words.add(word);
				}

			}
		}

		try (Scanner fileScanner = new Scanner(passage)) {

			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine().strip();
				if (!line.isEmpty()) {
					String sentence = "";
					for (int i = 0; i < line.length();) {
						String letter = line.substring(i, i + 1);
						if (letter.contains(".")) {
							sentence = sentence + letter;
							fileInList.add(sentence);
							sentence = "";
							i++;
						} else {
							sentence = sentence + letter;
							i++;

						}
					}

				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
		}

		for (int i = 0; i < fileInList.size();) {
			if (fileInList.get(i).contains(top10Words.get(0))) {
				linesWithMostUsedWord.add(fileInList.get(i));
				i++;
			} else {
				i++;
			}
		}

		System.out.println("Word count: " + wordCounter + "\n");
		System.out.println("Top 10 words used in the file: " + top10Words);
		System.out.println("How many times that specific word was used: " + repeatedWordsValues.subList(0, 10) + "\n");
		System.out.println("For example, 'the' was used 18 times, 'a' was used 16 times, and so on." + "\n");
		System.out.println("The last sentence in the file that contains the most used word: " + "'"
				+ linesWithMostUsedWord.get(linesWithMostUsedWord.size() - 1) + "'");

	}
}
