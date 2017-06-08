package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import main.java.com.luhuiguo.chinese.ChineseUtils;

public class Test {

	public static void main(String[] args) {
		String fileNamer0 = "E:\\实验室\\wikiHandle\\result\\zhExtract\\20170301\\wiki_00";
		String fileNamer1 = "E:\\实验室\\wikiHandle\\result\\zhExtract\\20170301\\wiki_01";
		String fileNamer2 = "E:\\实验室\\wikiHandle\\result\\zhExtract\\20170301\\wiki_02";
		String fileNamew = "E:\\实验室\\wikiHandle\\result\\zhExtract\\20170301\\new_wiki";
		String newStr = "";
		File fr = new File(fileNamer0);
		File fw = new File(fileNamew);
		BufferedReader reader = null;
		BufferedWriter writer = null;
		try {
			reader = new BufferedReader(new FileReader(new File(fileNamer0)));
			writer = new BufferedWriter(new FileWriter(new File(fileNamew)));
			String tempString = null;
			while ((tempString = reader.readLine()) != null) {
				if (tempString.length() > 3&&isChinese(tempString.charAt(0))) {
					writer.write(new ChineseUtils().toSimplified(tempString));
					writer.newLine();
					writer.flush();
				}
			}
			reader = new BufferedReader(new FileReader(new File(fileNamer1)));
			while ((tempString = reader.readLine()) != null) {
				if (tempString.length() > 3&&isChinese(tempString.charAt(0))) {
					writer.write(new ChineseUtils().toSimplified(tempString));
					writer.newLine();
					writer.flush();
				}
			}
			reader = new BufferedReader(new FileReader(new File(fileNamer2)));
			while ((tempString = reader.readLine()) != null) {
				if (tempString.length() > 3&&isChinese(tempString.charAt(0))) {
					writer.write(new ChineseUtils().toSimplified(tempString));
					writer.newLine();
					writer.flush();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
					writer.close();
				} catch (IOException e1) {
				}
			}
		}
	}
	static boolean isChinese(char c) {
	    boolean result = false;
	    if (c >= 19968 && c <= 171941) {// 汉字范围 \u4e00-\u9fa5 (中文)
	        result = true;
	    }
	    return result;
	}

}
