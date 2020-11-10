package info.androidhive.sqlite.database

import androidx.room.Dao
import androidx.room.Insert
import info.androidhive.sqlite.database.model.Person

@Dao
interface PersonDAO {
    @Insert
    fun insert(person: Person)

}