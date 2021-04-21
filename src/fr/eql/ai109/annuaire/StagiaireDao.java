package fr.eql.ai109.annuaire;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class StagiaireDao {

	private static int tailleNom = 0;
	private static int taillePrenom = 0;
	private static int tailleDepartement = 0;
	private static int taillePromo = 0;
	private static int tailleAnnee = 0;
	private static int tailleStagiaire = 0;
	private static int nbStagiaires = 0;
	
	private ArbreStagiaires arbreStagiaires = new ArbreStagiaires();
	private Noeud racine = new Noeud ();

	public void lireFichierStagiaire () {

		BufferedReader br = null;
		FileReader in = null;

		try {

			in = new FileReader("C:\\Users\\formation\\Desktop\\Fichiers-Projet1\\stagiaires.txt");
			br = new BufferedReader(in);
			String chaine = "";

			String [] tousStagiaires=null;
			String [] donneesStagiaire=null;
			ArrayList <String> donnees = new ArrayList<String>();
			Stagiaire stagiaire = new Stagiaire ();
			//Lire tout le fichier
			while(br.ready()) {
				//	chaine = chaine.trim() + "\t" + br.readLine();
				//	System.out.println(chaine);
				//chaine.trim();
				//	tousStagiaires=chaine.split("\\*");
				chaine = br.readLine();
				if (!(chaine.equals("*"))) {
					donnees.add(chaine);
				}
			}

			for (int a=0; a<donnees.size(); a=a+5) {
				
				stagiaire.setNom(donnees.get(a).trim());
				stagiaire.setPrenom(donnees.get(a+1).trim());
				stagiaire.setDepartement(donnees.get(a+2).trim());
				stagiaire.setPromo(donnees.get(a+3).trim());		
				stagiaire.setAnnee(Integer.parseInt(donnees.get(a+4).trim()));
			
				//arbreStagiaires.add(stagiaire);
				racine.ajouterElement(stagiaire, racine);
			}
			
			racine.traverseInOrder(racine);
			
			//arbreStagiaires.traverseInOrder(arbreStagiaires.getRoot()); 

			/*for (String d : donnees) {
				System.out.println(d);
			}*/

			/*	for (int j=0; j<tousStagiaires.length-1; j++) {
				System.out.println(tousStagiaires[j]);
			};*/

			/*for (int i=0; i<tousStagiaires.length-1; i++) {
				donneesStagiaire=tousStagiaires[i].split("\t");
			//	System.out.println(donneesStagiaire);
				Stagiaire stagiaire = new Stagiaire (donneesStagiaire[0].trim(), donneesStagiaire[1].trim(), donneesStagiaire[2].trim(),
						donneesStagiaire[3].trim(), Integer.parseInt(donneesStagiaire[4].trim()));
				System.out.println(stagiaire.getNom()+ " " + stagiaire.getPrenom());
			}*/
			in.close();
			br.close();	

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				in.close();
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void determinerTaillesMax () {
		BufferedReader br = null;
		FileReader in = null;

		try {

			in = new FileReader("C:\\Users\\formation\\Desktop\\Fichiers-Projet1\\stagiaires.txt");
			br = new BufferedReader(in);
			String chaine = "";
			ArrayList <String> donnees = new ArrayList<String>();

			while(br.ready()) {
				chaine = br.readLine();

				if (!(chaine.equals("*"))) {
					donnees.add(chaine);
				}
			}
			
			for (int a=0; a<donnees.size(); a=a+5) {

				tailleNom = trouverMax (tailleNom, donnees.get(a).trim());
				taillePrenom = trouverMax (taillePrenom, donnees.get(a+1).trim());
				tailleDepartement = trouverMax(tailleDepartement, donnees.get(a+2).trim());
				taillePromo = trouverMax(taillePromo, donnees.get(a+3).trim());
				tailleAnnee = trouverMax(tailleAnnee, donnees.get(a+4).trim());

				//System.out.println(tailleNom + " " +taillePrenom+ " " + tailleDepartement + " " + taillePromo + " " + tailleAnnee);
			}


			in.close();
			br.close();	

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				in.close();
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public int trouverMax(int tailleChamp, String champ) {
		if (tailleChamp < champ.length()) {
			return champ.length();
		}
		return tailleChamp;
	}

}

