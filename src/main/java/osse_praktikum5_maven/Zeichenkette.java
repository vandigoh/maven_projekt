package osse_praktikum5_maven;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Zeichenkette {

	public static void main(String[] args) throws IOException {
		
		System.out.println("Typpen Sie eine Zeichenkette ein:\n");
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String eingabe = br.readLine();
		
		System.out.println(eingabe.toUpperCase());

	}

}
