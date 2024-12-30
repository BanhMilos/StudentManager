package com.example.studentmanager

class StudentRepository(private val studentDao: StudentDao) {

    suspend fun insert(student: Student) {
        studentDao.insert(student)
    }

    suspend fun getAllStudents(): List<Student> {
        return studentDao.getAllStudents()
    }

    suspend fun deleteAll() {
        studentDao.deleteAll()
    }
}