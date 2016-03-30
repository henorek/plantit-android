package com.henorek.plantit.data.disk.entity;

import android.provider.BaseColumns;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.util.Date;
import lombok.Data;

@Data @DatabaseTable(tableName = "GAME_LEVEL_TABLE") public class GameLevel {

  @DatabaseField(id = true, columnName = BaseColumns._ID) private int id;

  @DatabaseField private String iconUrl;

  @DatabaseField private String name;

  @DatabaseField private String radarUrl;

  @DatabaseField private String backgroundUrl;

  @DatabaseField private Date updateTime;
}
