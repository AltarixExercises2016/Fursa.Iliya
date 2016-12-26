CREATE TABLE `Teacher` (
	`id`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`name`	TEXT
);

PRAGMA foreign_keys=ON;

CREATE TABLE `Lesson` (
	`id`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`name`	TEXT,
	`auditory`	INTEGER,
	`lesson_day` TEXT
	`type`	TEXT,
	`teacher_id`	INTEGER,
	 FOREIGN KEY(`teacher_id`) REFERENCES Teacher(id)
);
-- выбор всех данных по дню!!!
--SELECT Lesson.name, Lesson.time, Lesson.day, Teacher.name
--FROM Lesson, Teacher
--WHERE Lesson.day = 'Пятница' AND Teacher.id = Lesson.teacher_id
