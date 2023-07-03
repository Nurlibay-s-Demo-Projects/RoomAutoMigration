package uz.nurlibaydev.roomautomigration.database

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RenameColumn
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.AutoMigrationSpec

@Database(
    entities = [User::class],
    version = 3,
    exportSchema = true,
    autoMigrations = [
        AutoMigration(
            from = 1,
            to = 2
        ),
        AutoMigration(
            from = 2,
            to = 3,
            UserDatabase.Migration2To3::class
        )
    ]
)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        fun getInstance(context: Context): UserDatabase {
            return Room.databaseBuilder(
                context,
                UserDatabase::class.java,
                "users.db"
            )
                .allowMainThreadQueries()
                .build()
        }
    }

    @RenameColumn("User", "age", "user_age")
    class Migration2To3() : AutoMigrationSpec
}