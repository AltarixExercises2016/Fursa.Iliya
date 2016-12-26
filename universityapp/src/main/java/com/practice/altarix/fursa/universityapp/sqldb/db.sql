CREATE TABLE `Teacher` (
	`id`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`name`	TEXT
);

PRAGMA foreign_keys=ON;

CREATE TABLE `Lesson` (
	`id`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`name`	TEXT,
	`auditory`	INTEGER,
	`type`	TEXT,
	`teacher_id`	INTEGER,
	 FOREIGN KEY(`teacher_id`) REFERENCES Teacher(id)
);

