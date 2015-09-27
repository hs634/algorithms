package eArrays;

/**
 * Explanation about time-complexity
 * 
 * This class returns the Top K most frequent words in a text.
 * The run time complexity is in O(n). This is due to the following:
 * (1) O(n) - The text is traversed for counting the frequency of words
 * (2) O(klogk) - The priority queue is populated with 'K' top words. 
 * Priority Queue provides O(log(k)) time for enqueing and dequeuing operation, 
 *
 * So the run time complexity is O(n + klog(k)). Since 'n' is much larger than 'k', the
 * run time complexity is amortized to O(n).
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class WordFrequencyCounter {

	/**
	 * Class to represent the word and its frequency to be used while using
	 * Priority Queue(min-heap)
	 * 
	 * @author arpana
	 */
	static class TermCount {
		String term;
		int count;

		TermCount(String term, int count) {
			this.term = term;
			this.count = count;
		}
	}

	String regex = "[\\p{Punct}\\s]+";
	Map<String, Integer> wordFrequencyMap;
	Queue<TermCount> sortedTerms;

	/**
	 * This method takes two parameters, calls a method to populate the hash map
	 * of word and frequency. It then initializes a priority queue of size k
	 * which acts as min-heap. Storing the word with smallest of k words at the
	 * head of queue. Comparator is used to replace the head of the queue with
	 * the word having frequency larger than the head(thus the entire heap).
	 * This is achieved by using a comparator and overriding compare method. The
	 * queue would contain the top k elements.
	 * 
	 * @param text
	 * @param k
	 */
	private void topKFrequencyOrderedWords(String text, int k) {
		wordFrequencyMap = new HashMap<String, Integer>();
		
		this.populateFrequencyMap(text);
		
		if (k > wordFrequencyMap.size()) {
			k = wordFrequencyMap.size();
		}
		
		sortedTerms = new PriorityQueue<TermCount>(k,
				new Comparator<TermCount>() {
					@Override
					public int compare(TermCount x, TermCount y) {
						return (x.count == y.count) ? x.term.compareTo(y.term)
								: y.count - x.count;
					}
				});

		for (Map.Entry<String, Integer> entry : wordFrequencyMap.entrySet()) {
			sortedTerms.add(new TermCount(entry.getKey(), entry.getValue()));
		}
		this.printTopK(k);
	}

	/**
	 * Splits the word based on the regular expression and populates the hashmap
	 * with word and corresponding frequency
	 * 
	 * @param text
	 *            - String representing document
	 */
	private void populateFrequencyMap(String text) {
		String[] words = text.split(regex);
		for (String word : words) {
			word = word.toLowerCase();
			int count = 1;
			if (wordFrequencyMap.containsKey(word)) {
				count = wordFrequencyMap.get(word) + 1;
			}
			wordFrequencyMap.put(word, count);
		}
	}

	/**
	 * Print the priority queue which holds the top k words in the sorted order
	 * of frequency
	 */
	private void printTopK(int k) {
		System.out.println("The top K words are:");
		for (int i = 0; i < k; i++) {
			System.out.println(sortedTerms.poll().term);
		}
	}

	/**
	 * Public method which is called from the main function.
	 * @param text
	 * @param k
	 */
	public void printTopKFrequentWords(String text, int k) {
		this.topKFrequencyOrderedWords(text, k);
	}

	/**
	 * Provide 2 inputs. String representing the text in the document value of K
	 * representing the top k words to be retrieved
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		String text = "";
		while (text.equals("") || text.length() == 0) {
			System.out.print("Please enter the text: ");
			try {
				text = rd.readLine().trim();
			} catch (IOException e) {
				System.out.println("An IO Error occured.");
			}
		}
		int k = -1;
		do {
			System.out.print("Please enter 'K': ");
			try {
				k = Integer.parseInt(rd.readLine());
			} catch (NumberFormatException e) {
				System.out.println("You entered an Invalid Number.");
			} catch (IOException e) {
				System.out.println("An IO Error occured.");
			}
		} while (k <= 0);

		WordFrequencyCounter topK = new WordFrequencyCounter();
		topK.printTopKFrequentWords(text, k);
	}

}
