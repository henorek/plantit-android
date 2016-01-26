package net.henorek.plantit.cache.models;

import android.provider.BaseColumns;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import net.henorek.plantit.cache.DBConstants;

import java.util.Date;

import lombok.Data;

@Data
@DatabaseTable(tableName = DBConstants.GAME_LEVEL_TABLE)
public class GameLevelDb {

    @DatabaseField(id = true, columnName = BaseColumns._ID)
    private int id;

    @DatabaseField
    private String iconUrl;

    @DatabaseField
    private String name;

    @DatabaseField
    private String radarUrl;

    @DatabaseField
    private String backgroundUrl;

    @DatabaseField
    private Date updateTime;
}
