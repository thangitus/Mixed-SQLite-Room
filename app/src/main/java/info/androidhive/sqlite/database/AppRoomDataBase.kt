package info.androidhive.sqlite.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import info.androidhive.sqlite.database.model.Note
import info.androidhive.sqlite.database.model.Person

@Database(entities = [Person::class], version = 2)
abstract class AppRoomDataBase : RoomDatabase() {
    abstract fun personDao(): PersonDAO


    companion object {
        private var INSTANCE: AppRoomDataBase? = null

        fun getDatabase(context: Context): AppRoomDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppRoomDataBase::class.java,
                    "notes_db"
            ).addMigrations(MIGRATION_1_2)
                    .allowMainThreadQueries()
                    .build()

            INSTANCE = instance
            return instance
        }

        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                val CREATE_TABLE = "CREATE TABLE Person ( id INTEGER  PRIMARY KEY AUTOINCREMENT , name TEXT NOT NULL)"
                database.execSQL(CREATE_TABLE)
            }
        }
    }


}
