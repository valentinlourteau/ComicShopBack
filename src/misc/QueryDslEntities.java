package misc;

import entities.QAbonnement;
import entities.QGuide;
import entities.QProduit;
import entities.QProduitCommentaire;
import entities.QSerie;
import entities.QStock;
import entities.QTheme;
import entities.QUser;

public interface QueryDslEntities {

	final QUser USER = QUser.user;
	final QGuide GUIDE = QGuide.guide;
	final QTheme THEME = QTheme.theme;
	final QProduitCommentaire PRODUIT_COMMENTAIRE = QProduitCommentaire.produitCommentaire;
	final QProduit PRODUIT = QProduit.produit;
	final QStock STOCK = QStock.stock;
	final QSerie SERIE = QSerie.serie;
	final QAbonnement ABONNEMENT = QAbonnement.abonnement;
}
