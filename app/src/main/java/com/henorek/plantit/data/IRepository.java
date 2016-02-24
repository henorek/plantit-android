package com.henorek.plantit.data;

import com.henorek.plantit.data.disk.entity.Tactic;

import java.util.List;

import rx.Observable;

public interface IRepository {

    Observable<List<Tactic>> getTactics(String title, boolean forceRefresh);

}
