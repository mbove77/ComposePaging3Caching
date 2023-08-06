package com.martinbove.paging3compose.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * Created by Martín Bove on 28/07/2023.
 * E-mail: mbove77@gmail.com
 */

@Database(
    entities = [BeerEntity::class],
    version = 1
)
abstract class BeerDatabase: RoomDatabase() {
    abstract val dao: BeerDao
}