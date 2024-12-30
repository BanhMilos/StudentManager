package com.example.studentmanager

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
@Dao
interface StudentDao {
    @Insert
    suspend fun insert(student: Student)

    @Query("SELECT * FROM students")
    suspend fun getAllStudents() : List<Student>

    @Query("DELETE FROM students")
    suspend fun deleteAll()
}