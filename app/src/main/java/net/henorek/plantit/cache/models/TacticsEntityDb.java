package net.henorek.plantit.cache.models;

import android.provider.BaseColumns;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import net.henorek.plantit.cache.DBConstants;

import java.util.Date;

import lombok.Data;

@Data
@DatabaseTable(tableName = DBConstants.TACTICS_TABLE)
public class TacticsEntityDb {

    @DatabaseField(id = true, columnName = BaseColumns._ID)
    private long id;

    @DatabaseField
    private String iconUrl;

    @DatabaseField
    private String title;

    @DatabaseField
    private String description;

    @DatabaseField
    private String category;

    @DatabaseField
    private String radarUrl;

    @DatabaseField
    private String mapName;

    @DatabaseField
    private String side;

    @DatabaseField
    private int difficulty;

    @DatabaseField
    private int heGrenades;

    @DatabaseField
    private int flashGrenades;

    @DatabaseField
    private int smokeGrenades;

    @DatabaseField
    private int incendiaryGrenades;

    @DatabaseField
    private int decoyGrenades;

    @DatabaseField
    private String author;

    @DatabaseField
    private Date updateTime;
}
