package eg.edu.alexu.csd.filestructure.graphs.test.cs59_07;

import java.io.File;
import java.io.FileNotFoundException;

public class tester {
	public static void main(String[] args) throws FileNotFoundException {
		File f = new File("test.txt");
		java.util.Scanner sc = new java.util.Scanner(f);
		int n = sc.nextInt();
		System.out.println(n);
	    n = sc.nextInt();
		System.out.println(n);
		sc.close();
	}

}
