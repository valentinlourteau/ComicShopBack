CREATE TABLE `produits_commentaires` (
  `produit_commentaire_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `produit_id` bigint(20) DEFAULT NULL,
  `commentaire` longtext DEFAULT NULL,
  `guide_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`produit_commentaire_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
