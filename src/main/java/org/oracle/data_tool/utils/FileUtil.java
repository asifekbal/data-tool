package org.oracle.data_tool.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author asifekbal
 *
 */
public class FileUtil {

	public static final Logger logger = LogManager.getLogger(FileUtil.class);

	private FileUtil() {

	}

	/**
	 * @param fileName, Reads this file
	 * @return List of String , where each string represents a single line from file
	 */
	public static List<String> readFile(String fileName) {
		List<String> result = new ArrayList<>();
		File file = new File(fileName + ".txt");
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			logger.info("Reading input file");
			String st = null;
			while ((st = reader.readLine()) != null) {
				result.add(st);
			}
		} catch (IOException ex) {
			logger.error(ex.getMessage());
		}
		return result;
	}

	/**
	 * Write to a file
	 * 
	 * @param list of strings
	 */
	public static void writeFile(List<String> list) {
		final String fileName = "output";
		File file = new File(fileName + ".txt");
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
			logger.info("Writing to onput file");
			for (String str : list) {
				writer.write(str + "\n");
			}

		} catch (IOException ex) {
			logger.error(ex.getMessage());
		}
	}
}