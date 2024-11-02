select c.name, count(sc.studentId) NumberStudents
from course c, studentCourse sc
where c.id = sc.studentId
group by c.name
order by NumberStudents desc, c.name asc;

select c.name, count(studentId) NumberStudents
from studentcourse sc, course c
where sc.courseId = c.id
group by c.name
order by NumberStudents desc, c.name asc;

select c.name
from course c, facultyCourse f
where c.id = f.courseId
group by c.name
having count(facultyId) = 0
order by c.name;

select c.name
from course c
where c.id NOT IN (
    select f.courseId
    from facultycourse f
    group by f.courseId
    having count(*) > 0
)
order by c.name;

select c.name, count(*) NumberOfStudents
from course c, studentcourse sc
where c.id NOT IN (
    select f.courseId
    from facultycourse f
    group by f.courseId
    having count(*) > 0
    ) and c.id = sc.courseId
group by c.name
order by NumberOfStudents desc, c.name asc;

-- #6 you have to count distinct studentId
select count(distinct studentId) Students, YEAR(startDate) Year
from student s, studentcourse sc
where s.id = sc.studentId
group by Year
order by Year asc, Students desc;

-- #7 need startDate first column, students second column
select sc.startDate, count(distinct sc.studentId) Students
from student s, studentcourse sc
where s.id = sc.studentId and MONTH(sc.startDate)=8
group by sc.startDate
order by sc.startDate asc, Students asc;

-- 8
select s.firstname, s.lastname, count(*) Courses
from student s, department d, course c
where s.majorId = d.id and c.deptId = d.id
group by s.firstname, s.lastname
order by Courses desc, s.firstname asc, s.lastname asc;

-- 9
select s.firstname, s.lastname, Round(AVG(sc.progress),1) AvgProgress
from studentcourse sc, student s
where sc.studentId = s.id
group by s.firstname, s.lastname
having AvgProgress < 50
order by  AvgProgress desc, s.firstname asc, s.lastname asc;

-- 10
select c.name, ROUND(AVG(sc.progress), 1) AvgProgress
from course c, studentcourse sc
where c.id = sc.courseId
group by c.name
order by AvgProgress desc, c.name asc;

-- 11
select c.name, ROUND(AVG(sc.progress), 1) AvgProgress
from course c, studentcourse sc
where c.id = sc.courseId
group by c.name
order by AvgProgress desc, c.name asc
limit 1;

-- 12 Only get the courses that faculty member teach, not what they are belonging to

select f.firstname, f.lastname, ROUND(AVG(sc.progress), 1) AvgProgress
from course c, studentcourse sc, facultycourse fc, faculty f
where c.id = sc.courseId and fc.facultyId = f.id and fc.courseId = c.id
group by f.firstname, f.lastname
order by AvgProgress desc, f.firstname asc, f.lastname asc;

-- 13
select s.firstname, s.lastname,
       if (MIN(sc.progress)>=70, 'A', if(MIN(sc.progress)>=60, 'B', if(MIN(sc.progress)>=50, 'C', if(MIN(sc.progress)>=40, 'D', 'F')))) MinGrade,
       if (MAX(sc.progress)>=70, 'A', if(MAX(sc.progress)>=60, 'B', if(MAX(sc.progress)>=50, 'C', if(MAX(sc.progress)>=40, 'D', 'F')))) MaxGrade
from student s, studentcourse sc
where s.id = sc.studentid
group by s.firstname, s.lastname;