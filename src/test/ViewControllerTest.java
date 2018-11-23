package test;

import java.util.ArrayList;

import java.util.Scanner;

public class ViewControllerTest {
	

	Scanner sc = new Scanner(System.in);
	ArrayList<String> nakup = new ArrayList<String>();
	String odpoved;
	
	do {
		System.out.print("zadej nakupni polozku: ");
		odpoved = sc.nextLine();
		if (!odpoved.equals("konec")) {
			nakup.add(odpoved);
		}
	} while (!odpoved.equals("konec"));

	// vypis polozek je shodny pro oba postupy
	System.out.println("toto je tvuj nakupni seznam: ");
	for (String polozka : nakup) {
		System.out.println(polozka);
	}
	sc.close();
}

}
