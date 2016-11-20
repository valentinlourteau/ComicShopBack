package misc;

import entities.QGuide;
import entities.QProduit;
import entities.QProduitsCommentaires;
import entities.QStock;
import entities.QTheme;

public interface QueryDslEntities {
	//
	// final QUser USER = QUser.user;
	//
	final QGuide GUIDE = QGuide.guide;
	final QTheme THEME = QTheme.theme;
	final QProduitsCommentaires PRODUITS_COMMENTAIRES = QProduitsCommentaires.produitsCommentaires;
	final QProduit PRODUIT = QProduit.produit;
	final QStock STOCK = QStock.stock;

}
