package com.mock.intervieweer.process;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static com.mock.intervieweer.constant.InterviewConstants.*;

public class InterviewQuestionsMaker {

	private static File output = new File(FILE_LOCATION + "QuestionMaker.txt");
	private static File input1 = new File(FILE_LOCATION
			+ INTERVIEW_DAY_MAP.get(CAL.get(Calendar.DAY_OF_WEEK)) + ".txt");
	private static FileWriter fw;
	private static BufferedWriter bw;
	private static BufferedReader buffer;
	private static Map<Integer, String> interviewer = new HashMap<Integer, String>();

	public static Map<Integer, String> fetchQuestions() {
		try {
			readAndWriteQuestions();
			loadToQuestionsBook();
		} catch (Exception e) {
			System.out.println("Error occurred during fetching questions " + e);
		}
		return interviewer;
	}

	private static void loadToQuestionsBook() {
		int i = 1;
		String text = null;
		try {
			buffer = new BufferedReader(new FileReader(output));
			while ((text = buffer.readLine()) != null) {
				interviewer.put(i++, text.trim());
			}
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException ioe) {
			System.out.println(ioe);
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	private static void readAndWriteQuestions() throws IOException {
		try {
			fw = new FileWriter(output);
			bw = new BufferedWriter(fw);
			String text = null;
			Scanner scn = new Scanner(System.in);
			System.out
					.println("Press '1' for all topics combined else press any key!!");
			String val = scn.nextLine();
			if (val.equals("1")) {
				for (int i = 0; i <= 7; i++) {
					File input = new File(FILE_LOCATION_ALL + i + ".txt");
					buffer = new BufferedReader(new FileReader(input));
					while ((text = buffer.readLine()) != null) {
						text = text.trim();
						bw.write(new String(text));
						bw.newLine();
					}
				}
			} else {
				buffer = new BufferedReader(new FileReader(input1));
				while ((text = buffer.readLine()) != null) {
					text = text.trim();
					bw.write(new String(text));
					bw.newLine();
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException ioe) {
			System.out.println(ioe);
		} catch (Exception ex) {
			System.out.println(ex);
		} finally {
			buffer.close();
			bw.close();
		}
	}
}