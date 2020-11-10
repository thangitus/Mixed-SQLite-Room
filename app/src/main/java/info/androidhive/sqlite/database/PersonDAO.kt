package info.androidhive.sqlite.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import info.androidhive.sqlite.database.model.Person

@Dao
interface PersonDAO {
    @Insert
    fun insert(person: Person)

    @Query("SELECT * FROM Person")
    fun getAll(): List<Person>
}