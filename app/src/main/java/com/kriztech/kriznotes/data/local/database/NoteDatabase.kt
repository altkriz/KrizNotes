package com.kriztech.kriznotes.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kriztech.kriznotes.core.constant.DatabaseConst
import com.kriztech.kriznotes.data.local.dao.NoteDao
import com.kriztech.kriznotes.domain.model.Note

@Database(
    entities = [Note::class],
    version = DatabaseConst.NOTES_DATABASE_VERSION,
    exportSchema = false
)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDao
}