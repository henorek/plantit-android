package net.henorek.plantit.data;


import net.henorek.plantit.data.disk.entity.Tactic;

import java.util.List;

public interface IChapterDisk {

    List<Tactic> get();

    void save(List<Tactic> chapters);

}
