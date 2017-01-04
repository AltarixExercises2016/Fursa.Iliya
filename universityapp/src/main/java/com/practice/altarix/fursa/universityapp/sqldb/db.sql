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

SELECT *
FROM Lesson, Teacher
WHERE Lesson.day = 'Вторник' AND Teacher.id = Lesson.teacher_id

INSERT INTO Teacher(id, name) VALUES(10, \"Шаипов А.С\")

INSERT INTO Lesson(id, name, auditory, type, teacher_id, day, time)
VALUES(7, "ОБЖ", 101, "Лекция", 10, "Понедельник", "10:00")

--счетчик по дню!
SELECT COUNT(*) FROM Teacher, Lesson WHERE
Teacher.id = Lesson.teacher_id AND Lesson.day = 'Вторник';
