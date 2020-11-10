package info.androidhive.sqlite.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Person(val name: String) {

    @PrimaryKey
    var id: Int? = null
}