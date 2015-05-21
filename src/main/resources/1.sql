BEGIN TRANSACTION;
CREATE TABLE "Projects" (
	`id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
	`category_id`	INTEGER NOT NULL,
	`name`	TEXT NOT NULL UNIQUE,
	`description`	TEXT
);
INSERT INTO `Projects` VALUES (1,1,'Project1 for Category1',NULL);
INSERT INTO `Projects` VALUES (2,1,'Project2 for Category1',NULL);
INSERT INTO `Projects` VALUES (3,2,'Project3 for Category2','Some description');
CREATE TABLE "Categories" (
	`id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
	`name`	TEXT NOT NULL UNIQUE
);
INSERT INTO `Categories` VALUES (21,'Photo');
INSERT INTO `Categories` VALUES (22,'Video');
INSERT INTO `Categories` VALUES (23,'Music');
COMMIT;
