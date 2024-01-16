package com.shopping.amazon.util;

import java.util.Scanner;

public class InputReaderUtil {


	private static String getString() {
		Scanner in = new Scanner(System.in);
		return in.nextLine();
	}

	public static String readConfirmation() {
		return getString();
	}

	public static String readName() {
		return getString();
	}
	public static String readAddress() {
		return getString();
	}
	public static String readModel() {
		return getString();
	}

}
