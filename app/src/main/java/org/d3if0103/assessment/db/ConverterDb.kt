package org.d3if0103.assessment.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ConverterEntity::class], version = 1, exportSchema = false)
abstract class ConverterDb: RoomDatabase() {
    abstract val dao: ConverterDao
    companion object {
        @Volatile
        private var INSTANCE: ConverterDb? = null

        fun getInstance(context: Context): ConverterDb {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ConverterDb::class.java,
                        "converterpanjang.db"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}