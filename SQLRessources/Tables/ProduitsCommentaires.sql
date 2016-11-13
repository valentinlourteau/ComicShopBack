CREATE TABLE `produits_commentaires` (
  `produit_commentaire_id` bigint(20) NOT NULL,
  `produit_id` bigint(20) DEFAULT NULL,
  `commentaire` varchar(255) DEFAULT NULL,
  `guide_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`produit_commentaire_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
