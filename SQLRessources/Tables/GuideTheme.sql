CREATE TABLE `guide_theme` (
  `guide_id` bigint(11) NOT NULL,
  `theme_id` bigint(11) NOT NULL,
  PRIMARY KEY (`guide_id`,`theme_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
