package by.minsler.helper;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Counter {

	private int count;
	private File fileCount;

	public Counter(File file) {
		this.fileCount = file;
		System.out.println("initialized counter");

		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(fileCount));
			String s;
			if ((s = br.readLine()) != null) {
				count = Integer.parseInt(s);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					System.out.println("error close file");
				}
			}
		}

	}

	synchronized public int increment() {

		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(fileCount));
			String s;
			if ((s = br.readLine()) != null) {
				count = Integer.parseInt(s);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					System.out.println("error close file");
				}
			}
		}

		count++;

		PrintWriter bw = null;
		try {
			bw = new PrintWriter(fileCount);
			bw.println(count);
			bw.flush();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}

		return count;
	}

	public synchronized int getCount() {
		return increment();
	}

	public synchronized BufferedImage getImage() {
		BufferedImage image = new BufferedImage(500, 200,
				BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics = image.createGraphics();
		graphics.setFont(new Font("Serif", Font.ITALIC, 48));
		graphics.setColor(Color.green);
		graphics.drawString("count: " + count, 100, 100);

		return image;
	}
}
