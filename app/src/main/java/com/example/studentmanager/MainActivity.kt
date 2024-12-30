package com.example.studentmanager

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var db: AppDatabase
    private lateinit var studentDao: StudentDao
    private lateinit var studentRepository: StudentRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize ROOM database components
        db = AppDatabase.getDatabase(applicationContext)
        studentDao = db.studentDao()
        studentRepository = StudentRepository(studentDao)
        val listViewStudents = findViewById<ListView>(R.id.listViewStudents)

        // Fetch students from ROOM database using coroutines
        lifecycleScope.launch {
            studentDao.insert(Student("Nguyen Van A", "20213456"))
            studentDao.insert(Student("Nguyen Van B", "20211234"))
            studentDao.insert(Student("Nguyen Van C", "20214567"))
            val students = studentRepository.getAllStudents() // Fetch from database

            // Adapter for the ListView
            val adapter = StudentAdapter(this@MainActivity, students)
            listViewStudents.adapter = adapter
        }
    }
}
