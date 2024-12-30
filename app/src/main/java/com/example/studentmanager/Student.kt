package com.example.studentmanager

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "students")
data class Student(val name: String,
                   @PrimaryKey val id: String)
