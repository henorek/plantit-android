package net.henorek.plantit.data.models;

import lombok.Data;

@Data
public class TacticsEntityApi {

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
