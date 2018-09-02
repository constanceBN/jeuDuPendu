package jeuDuPendu;

import java.util.Scanner;

public class Game {

	/*
	 * On fait passer une chaîne de caractères String en tableau de caractères
	 * char[]. String motADeviner = "devine"; char[] ('d', 'e', 'v', 'i', 'n', 'e')
	 * motADeviner.length();
	 * 
	 * <type du tableau>char[] <nom du tableau>motVersTableau(<argument>String
	 * motADeviner) { }
	 * 
	 * int taille = motADeviner.length(); char[] motTableau = new char[taille];
	 * 
	 * int position; for(position=0; position<taille; position++) {
	 * motTableau[position] = s.charAt(position); // .charAt c'est une méthode pour
	 * récupérer un caractère d'une chaîne de caractère. } return motTableau;
	 */
	public char[] motVersTableau(String motADeviner) {
		int taille = motADeviner.length();
		char[] motTableau = new char[taille];
		int position;
		for (position = 0; position < taille; position++) {
			motTableau[position] = motADeviner.charAt(position);
		}
		return motTableau;
	}

	/*
	 * Taleaux parallèles: boolean[] (true, false, ...) -> char[] ('d', 'e', 'v',
	 * 'i', 'n', 'e')
	 * 
	 * int position; for(position=0; position< mot.length; position++) { // .length
	 * sans les () car c'est un char[] et pas un String qui renvoit une méthode().
	 * if (occurence[position] == true) { System.out.println(mot[position]); } else
	 * { System.out.println('?'); } }
	 */
	public void affichage(char[] mot, boolean[] occurence) {
		int position;
		for (position = 0; position < mot.length; position++) {
			if (occurence[position] == true) {
				System.out.print(mot[position]);
			} else {
				System.out.print('?');
			}
		}
	}

	/*
	 * boolean[] (true, false, ...) -> char[] ('d', '?', '?', '?', '?', '?')
	 * 
	 * int position; for(position=0; position< mot.length; position++) { if (lettre
	 * == mot[position]) { occurence[position] = true; } else { occurence[position]
	 * = false; } } return occurence;
	 */
	public boolean[] miseAJour(char[] mot, boolean[] occurence, char lettre) {
		int position;
		for (position = 0; position < mot.length; position++) {
			if (lettre == mot[position]) {
				occurence[position] = true;
			}
		}
		return occurence;
	}

	/*
	 * Si vu[0], vu[1], vu[2], vu[3], ... a pour valeur false return false; Sinon
	 * return true;
	 */
	public boolean finDePartie(boolean[] occurence) {
		int position;
		for (position = 0; position < occurence.length; position++) {
			if (occurence[position] == false) {
				return false;
			}
		}
		return true;
	}

	public void partie(String mot) {

		// Définir boolean[] occurence.
		boolean[] occurence = new boolean[motVersTableau(mot).length];

		// Commencer par l'appéle de la méthode N°2 (affichage) car la méthode N°1
		// (motVersTableau) se trouve déjà dans la méthode N°2.
		affichage(motVersTableau(mot), occurence);

		// Utilisation de la boucle while.
		while (finDePartie(occurence) == false) {

			// Utilisation du Scanner pour demander et récupérer les informations de
			// l'utilisateur.
			Scanner sc = new Scanner(System.in);
			System.out.println("\nPour deviner le mot, propose une lettre:");

			// Créer une variable de type String pour stocker l'input de l'utilisateur grâce
			// à .next().
			String str = sc.next();

			// Convertir l'input String en caractères grâce à .charAt().
			char lettre = str.charAt(0);

			// Appéle de la méthode miseAJour.
			miseAJour(motVersTableau(mot), occurence, lettre);

			affichage(motVersTableau(mot), occurence);
		}
		System.out.print("\nFélicitations, vous avez gagné!!! ;-)");
	}

}