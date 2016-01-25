package net.henorek.plantit.data.models;

import lombok.Data;

@Data
public class GameLevel {

    private long id;

    private String iconUrl;

    private String name;

    private String radarUrl;

    private String backgroundUrl;
}
