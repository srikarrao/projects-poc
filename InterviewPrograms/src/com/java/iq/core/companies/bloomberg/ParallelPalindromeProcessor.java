package com.java.iq.core.companies.bloomberg;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class ParallelPalindromeProcessor {

	private static Map<Integer, List<String>> mapBagOfTasks = new ConcurrentHashMap<Integer, List<String>>();

	public static void main(String[] args) throws FileNotFoundException,
			InterruptedException {
		BlockingQueueImpl blockingQueue = new BlockingQueueImpl(100);
		Thread t1 = new Thread(new PalindromeWorker(blockingQueue));
		Thread t2 = new Thread(new PalindromeWriter(blockingQueue));
		t1.start();
		t2.start();
	}

	public static class PalindromeWriter implements Runnable {

		private BlockingQueueImpl blockingQueue;

		public PalindromeWriter(BlockingQueueImpl blockingQueue) {
			this.blockingQueue = blockingQueue;
		}

		@Override
		public void run() {
			try {
				System.out.println(Thread.currentThread().getName() + " :: "
						+ getPalindromeCount());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		private synchronized Integer getPalindromeCount()
				throws InterruptedException {

			while (this.blockingQueue.size() == 0) {
				wait();
			}
			if (this.blockingQueue.size() == 100) {
				notifyAll();
			}
			int count = 0;
			List<String> values = blockingQueue.dequeue();
			if (values != null) {
				for (String s : values) {
					if (s.length() > 1 && isPalindrome(s)) {
						count++;
					}
				}
			}
			return count;
		}

		private static boolean isPalindrome(String s) {
			int x = 0;
			int y = s.length() - 1;

			for (int i = 0; i < s.length() && x < y; i++) {
				if (!Character.isLetterOrDigit(s.charAt(x))) {
					x++;
				} else if (!Character.isLetterOrDigit(s.charAt(y))) {
					y--;
				} else if (Character.toUpperCase(s.charAt(x)) == Character
						.toUpperCase(s.charAt(y))) {
					x++;
					y--;
				} else {
					return false;
				}
			}
			return true;
		}
	}

	public static class PalindromeWorker implements Runnable {

		private BlockingQueueImpl blockingQueue;

		public PalindromeWorker(BlockingQueueImpl blockingQueue) {
			this.blockingQueue = blockingQueue;
		}

		@Override
		public void run() {
			try {
				fetchWords();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		private synchronized void fetchWords() throws FileNotFoundException,
				InterruptedException {
			File file = new File("input-files/palindrome.txt");
			InputStream fileStream = new FileInputStream(file);
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					fileStream));
			String readVal;
			try {
				while ((readVal = reader.readLine()) != null) {
					String[] words = readVal.split("\\W");
					for (int i = 0; i < words.length; i++) {
						String temp = words[i].trim();
						int len = temp.length();
						if (len > 0 && !temp.isEmpty()) {
							List<String> list = null;
							if (mapBagOfTasks.containsKey(len)) {
								list = mapBagOfTasks.get(len);
							} else {
								list = new CopyOnWriteArrayList<String>();
							}
							list.add(temp);
							mapBagOfTasks.put(len, list);
							while (this.blockingQueue.size() == 100) {
								wait();
							}
							if (this.blockingQueue.size() == 0) {
								notifyAll();
							}
							blockingQueue.enqueue(list);
						}
					}
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}