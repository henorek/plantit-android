package com.henorek.plantit.data;


import com.henorek.plantit.data.disk.entity.Tactic;

import java.util.List;

public interface IChapterDisk {

    List<Tactic> get();

    void save(List<Tactic> chapters);

}
