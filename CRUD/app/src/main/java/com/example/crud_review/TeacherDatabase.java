package com.example.crud_review;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class TeacherDatabase extends SQLiteOpenHelper {

    public static final String TEACHER_TABLE = "TEACHER";
    public static final String TEACHER_ID = "ID";
    public static final String TEACHER_NAME = "NAME";
    public static final String TEACHER_EMAIL = "EMAIL";

    public TeacherDatabase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public void addTeacher(Teacher teacher) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put(TEACHER_NAME, teacher.getName());
        cv.put(TEACHER_EMAIL, teacher.getEmail());

        db.insert(TEACHER_TABLE, null, cv);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TEACHER_TABLE + " (" + TEACHER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + TEACHER_NAME + " TEXT, " + TEACHER_EMAIL + " TEXT)";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public List<Teacher> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TEACHER_TABLE;
        List<Teacher> list = new ArrayList<Teacher>();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()){
            do{
                int teacherID = cursor.getInt(0);
                String teacherName = cursor.getString(1);
                String teacherEmail = cursor.getString(2);
                Teacher newTeacher = new Teacher(teacherID, teacherName, teacherEmail);
                list.add(newTeacher);
            }
            while(cursor.moveToNext());
        }
        return list;
    }
}
