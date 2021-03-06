package com.henorek.plantit.data.disk;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.henorek.plantit.constants.Database;
import com.henorek.plantit.data.disk.entity.Tactic;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import java.sql.SQLException;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

  private final static Class[] models = new Class[] {
      Tactic.class
  };

  public DatabaseHelper(Context context) {
    super(context, Database.DATABASE_NAME, null, Database.DATABASE_VERSION);
  }

  @Override public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
    try {
      for (Class target : models) {
        TableUtils.createTable(connectionSource, target);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion,
      int newVersion) {
  }

  @Override public void close() {
    super.close();
  }
}
