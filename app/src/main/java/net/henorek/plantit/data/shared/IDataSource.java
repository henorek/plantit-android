package net.henorek.plantit.data.shared;

import net.henorek.plantit.data.disk.entity.Tactic;

import java.util.List;

import rx.Observable;

public interface IDataSource {

    Observable<List<Tactic>> getTactics(String title);

}
