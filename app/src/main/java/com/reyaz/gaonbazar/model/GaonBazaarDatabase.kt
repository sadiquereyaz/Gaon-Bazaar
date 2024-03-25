package com.reyaz.gaonbazar.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [CartItem::class], version = 1)
abstract class GaonBazaarDatabase() : RoomDatabase() {
    abstract fun CartItemDao(): CartItemDao

    companion object {
        private var DB_INSTANCE: GaonBazaarDatabase? = null
        fun getDatabase(context: Context): GaonBazaarDatabase{
            @Volatile
            if (DB_INSTANCE == null){
                synchronized(this) {
                    DB_INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        GaonBazaarDatabase::class.java,
                        "gaon_bazaar_db"
                    ).build()
                }
            }
            return DB_INSTANCE!!
        }
    }
}
