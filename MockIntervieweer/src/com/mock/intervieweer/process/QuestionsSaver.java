package com.mock.intervieweer.process;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import static com.mock.intervieweer.constant.InterviewConstants.*;

public class QuestionsSaver {

	private static String writeFile = null;
	public static int counter =0;

	private static String getFileName() {
		if (writeFile == null) {
			setFileName();
		}
		return writeFile;
	}

	private static void setFileName() {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter questions saving file name");
		try {
			String fName = scn.nextLine();
			if (fName == null || fName.isEmpty()) {
				throw new IllegalArgumentException(
						"Invalid Write question file");
			}
			writeFile = fName;
		} catch (Exception e) {
			System.err.println("Error taking the file name as input" + e);
		}
	}

	public static void saveQuestions(String str) {
		FileWriter fw;
		BufferedWriter bw = null;
		PrintWriter out = null;
		try {
			String fileName = getFileName();
			if (fileName != null && !fileName.isEmpty() && str != null
					&& !str.isEmpty()) {
				fw = new FileWriter(SAVE_QUESTIONS_PER_DAY_LOCATION + fileName,
						true);
				bw = new BufferedWriter(fw);
				out = new PrintWriter(bw);
				out.println((counter + 1) + ") " + str);
				counter++;
				out.close();
			}
		} catch (Exception e) {
			System.err.println("Failed to save questions into the file!! " + e);
		}
	}
}
