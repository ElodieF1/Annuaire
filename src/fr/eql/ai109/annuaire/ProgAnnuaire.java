package fr.eql.ai109.annuaire;

public class ProgAnnuaire {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StagiaireDao stagiaireDao = new StagiaireDao();
		stagiaireDao.determinerTaillesMax();
		stagiaireDao.lireFichierStagiaire();
	}

}
