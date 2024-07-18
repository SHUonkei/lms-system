A lecture management system is a software application that manages information about lectures, students, and instructors. For each lecture, there is detailed information such as the lecture name, classroom, lecture day and time, instructor, and a list of enrolled students. For students, there is detailed information such as name, student ID, and enrolled lectures. For instructors, there is detailed information such as name, instructor ID, and assigned lectures.

## Target Users:

- Lecture instructors: Manage their lectures, students, and assignments
- Academic advisors: Assist students with course selection and registration
- Administrative staff: Maintain student records and manage enrollment data

# System Features:

## Lecture Management:
@@ -20,13 +26,3 @@ Track student progress and grades
Add, delete, modify, and view instructor information
Assign instructors to lectures
Manage instructor workload and availability

## er figure
![image](https://github.com/user-attachments/assets/743f1f23-b2e7-4e4a-b323-a75a3135480c)


## init
docker を使わない場合

```
apt-get update
apt-get upgrade -y
apt-get install -y sqlite3
cd backend
mvn install 
```



```
backend/src/main/java/com/example/backend/BackendApplication.java
```
