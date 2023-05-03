package nomdepackage;

import entities.Joueur;
import entities.Poste;
import entities.Statut;
import repositories.DaoJoueur;
import repositories.JpaContext;

public class AppTest 
{
	
	public static void main(String[] args) {
		
		DaoJoueur daoJoueur=JpaContext.getDaoJoueur();
		
		Joueur j1 = new Joueur("James","LeBron",206,113,38,23,35000000,null,Statut.Titulaire,Poste.AilierFort,null);
		daoJoueur.insert(j1);
	}
	
}
