package com.example.testkotlin

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class QuizDbHelper {
//    companion object {
//        private const val DB_NAME = "quiz.db"
//        private const val DB_VERSION = 1
//        private const val TABLE_QUESTIONS = "questions"
//        private const val COL_ID = "id"
//        private const val COL_QUESTION = "question"
//        private const val COL_OPTION1 = "option1"
//        private const val COL_OPTION2 = "option2"
//        private const val COL_OPTION3 = "option3"
//        private const val COL_ANSWER = "answer" // номер правильного ответа (1, 2 или 3)
//    }
//
//    override fun onCreate(db: SQLiteDatabase) {
//        val createTable = "CREATE TABLE $TABLE_QUESTIONS (" +
//                "$COL_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
//                "$COL_QUESTION TEXT, " +
//                "$COL_OPTION1 TEXT, " +
//                "$COL_OPTION2 TEXT, " +
//                "$COL_OPTION3 TEXT, " +
//                "$COL_ANSWER INTEGER)"
//        db.execSQL(createTable)
//    }
//
//    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
//        db.execSQL("DROP TABLE IF EXISTS $TABLE_QUESTIONS")
//        onCreate(db)
//    }
//
//    fun getInt(
//        columnIndex: Int,
//        string: String,
//        string2: String,
//        string3: String,
//        string4: String,
//        int2: Int
//    ) {
//    }
//
//    fun Question(id: Any) {}
//
//    // Метод для загрузки всех вопросов
//    fun getAllQuestions(): List<Question> {
//        val questions = mutableListOf<Question>()
//        val db = readableDatabase
//        val cursor = db.query(TABLE_QUESTIONS, null, null, null, null, null, null)
//
//        with(cursor) {
//            while (moveToNext()) {
//                val question = Question(
//                    getInt(getInt(getColumnIndex(COL_ID)),
//                        getString(getColumnIndex(COL_QUESTION)),
//                        getString(getColumnIndex(COL_OPTION1)),
//                        getString(getColumnIndex(COL_OPTION2)),
//                        getString(getColumnIndex(COL_OPTION3)),
//                        getInt(getColumnIndex(COL_ANSWER))
//                    )
//                )
//            }
//        }
//        cursor.close()
//        return questions
//    }
//companion object {
//    private const val DATABASE_NAME = "test.db"
//    private const val DATABASE_VERSION = 1
//    private const val TABLE_QUESTIONS = "questions"
//    private const val COL_ID = "id"
//    private const val COL_QUESTION = "question"
//    private const val COL_OPTION_A = "option_a"
//    private const val COL_OPTION_B = "option_b"
//    private const val COL_OPTION_C = "option_c"
//    private const val COL_CORRECT = "correct_answer"
//}
//
//    override fun onCreate(db: SQLiteDatabase) {
//        val createTable = "CREATE TABLE $TABLE_QUESTIONS (" +
//                "$COL_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
//                "$COL_QUESTION TEXT, " +
//                "$COL_OPTION_A TEXT, " +
//                "$COL_OPTION_B TEXT, " +
//                "$COL_OPTION_C TEXT, " +
//                "$COL_CORRECT TEXT)"
//        db.execSQL(createTable)
//    }
//
//    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
//        db.execSQL("DROP TABLE IF EXISTS $TABLE_QUESTIONS")
//        onCreate(db)
//    }
//
//    // Метод для добавления вопросов (можно вызвать один раз при старте)
//    fun addQuestion(question: Question) {
//        val db = this.writableDatabase
//        val values = ContentValues()
//        values.put(COL_QUESTION, question.question)
//        values.put(COL_OPTION_A, question.option1)
//        values.put(COL_OPTION_B, question.option2)
//        values.put(COL_OPTION_C, question.option3)
//        values.put(COL_CORRECT, question.answer)
//        db.insert(TABLE_QUESTIONS, null, values)
//        db.close()
//    }
//
//    // Получение всех вопросов
//    fun getAllQuestions(): List<Question> {
//        val questionList = mutableListOf<Question>()
//        val selectQuery = "SELECT  * FROM $TABLE_QUESTIONS"
//        val db = this.readableDatabase
//        val cursor = db.rawQuery(selectQuery, null)
//
//        if (cursor.moveToFirst()) {
//            do {
//                val question = Question(
//                    id = cursor.getInt(cursor.getColumnIndexOrThrow(COL_ID)),
//                    question = cursor.getString(cursor.getColumnIndexOrThrow(COL_QUESTION)),
//                    option1 = cursor.getString(cursor.getColumnIndexOrThrow(COL_OPTION_A)),
//                    option2 = cursor.getString(cursor.getColumnIndexOrThrow(COL_OPTION_B)),
//                    option3 = cursor.getString(cursor.getColumnIndexOrThrow(COL_OPTION_C)),
//                    answer = cursor.getString(cursor.getColumnIndexOrThrow(COL_CORRECT))
//                )
//                questionList.add(question)
//            } while (cursor.moveToNext())
//        }
//        cursor.close()
//        db.close()
//        return questionList
//    }
//
//    // Метод для заполнения БД тестовыми данными (вызвать один раз)
//    fun fillWithSampleData() {
//        val db = writableDatabase
//        val values = ContentValues()
//
//        values.put(COL_QUESTION, "When was the first version of the Android operating system released?")
//        values.put(COL_OPTION_A, "14/04/2002")
//        values.put(COL_OPTION_B, "23/09/2008")
//        values.put(COL_OPTION_C, "10/12/2000")
//        values.put(COL_CORRECT, 2)
//        db.insert(TABLE_QUESTIONS, null, values)
//
//        values.put(COL_QUESTION, "Which sea doesn't have a single shore?")
//        values.put(COL_OPTION_A, "Barents Sea")
//        values.put(COL_OPTION_B, "Red Sea")
//        values.put(COL_OPTION_C, "Sargasso Sea")
//        values.put(COL_CORRECT, 3)
//        db.insert(TABLE_QUESTIONS, null, values)
//
//        values.put(COL_QUESTION, "Which crop does not belong to cereals?")
//        values.put(COL_OPTION_A, "Barley")
//        values.put(COL_OPTION_B, "Potatoes")
//        values.put(COL_OPTION_C, "Rice")
//        values.put(COL_CORRECT, 2)
//        db.insert(TABLE_QUESTIONS, null, values)
//
//        values.put(COL_QUESTION, "Which style of speech is characterized by standardization?")
//        values.put(COL_OPTION_A, "Official - business")
//        values.put(COL_OPTION_B, "Scientific")
//        values.put(COL_OPTION_C, "Both options are correct")
//        values.put(COL_CORRECT, 3)
//        db.insert(TABLE_QUESTIONS, null, values)
//
//        values.put(COL_QUESTION, "Who discovered the law of universal gravitation?")
//        values.put(COL_OPTION_A, "G. Galilei")
//        values.put(COL_OPTION_B, "I. Newton")
//        values.put(COL_OPTION_C, "E. Rutherford")
//        values.put(COL_CORRECT, 2)
//        db.insert(TABLE_QUESTIONS, null, values)
//    }
private val questions = listOf(
    Question("Какой ваш любимый цвет?", listOf("Красный", "Синий", "Зелёный"), listOf(1, 2, 3)),
    Question("Что вы предпочитаете?", listOf("Кофе", "Чай", "Вода"), listOf(2, 1, 3)),
    Question("Как вы проводите выходные?", listOf("Дома", "С друзьями", "В путешествиях"), listOf(1, 2, 3)),
    Question("Ваш уровень стресса?", listOf("Низкий", "Средний", "Высокий"), listOf(3, 2, 1)),
    Question("Сколько часов вы спите?", listOf("5–6", "7–8", "9+"), listOf(1, 3, 2))
)

    fun getQuestion(index: Int): Question? {
        return if (index < questions.size) questions[index] else null
    }

    fun getTotalQuestions(): Int = questions.size
}