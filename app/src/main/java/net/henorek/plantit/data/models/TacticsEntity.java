package net.henorek.plantit.data.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Jarek Jankowski on 2016-01-21.
 * jarosz1994@gmail.com
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class TacticsEntity {

    private long id;

    private String iconUrl;

    private String title;

    private String description;

    private String category;

    private String radarUrl;

    private String mapName;

    private String side;

    private int difficulty;

    private int heGrenades;

    private int flashGrenades;

    private int smokeGrenades;

    private int incendiaryGrenades;

    private int decoyGrenades;

    private String author;
}
