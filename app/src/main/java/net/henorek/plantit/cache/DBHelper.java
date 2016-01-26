package net.henorek.plantit.cache;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.squareup.sqlbrite.BriteDatabase;
import com.squareup.sqlbrite.SqlBrite;

import net.henorek.plantit.cache.models.GameLevelDb;
import net.henorek.plantit.cache.models.TacticsEntityDb;

import java.sql.SQLException;

import rx.Observable;

public class DBHelper extends OrmLiteSqliteOpenHelper {

    private final static Class[] models = new Class[]{
            GameLevelDb.class,
            TacticsEntityDb.class,
    };
    SqlBrite sqlBrite = SqlBrite.create();
    BriteDatabase db = sqlBrite.wrapDatabaseHelper(this);
    private Observable<Dao<GameLevelDb, Integer>> gameLevelsDao = null;
    private Observable<Dao<TacticsEntityDb, Long>> tacticsDao = null;

    public DBHelper(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            for (Class target : models) {
                TableUtils.createTableIfNotExists(connectionSource, target);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {

    }

    public Observable<Dao<GameLevelDb, Integer>> getGameLevelsDao() throws SQLException {
        if (gameLevelsDao == null)
            gameLevelsDao = getDao(GameLevelDb.class);
        return gameLevelsDao;
    }

    public Observable<Dao<TacticsEntityDb, Long>> getTacticsDao() throws SQLException {
        if (tacticsDao == null)
            tacticsDao = getDao(GameLevelDb.class);
        return tacticsDao;
    }
}
