package com.henorek.plantit.data.disk.dao;

import com.j256.ormlite.dao.RuntimeExceptionDao;

import com.henorek.plantit.data.disk.entity.Tactic;
import com.henorek.plantit.di.scope.ApplicationScope;

import java.util.List;

import javax.inject.Inject;

import dagger.Lazy;

@ApplicationScope
public class TacticDao {

    private final Lazy<RuntimeExceptionDao<Tactic, Integer>> dao;

    @Inject
    public TacticDao(Lazy<RuntimeExceptionDao<Tactic, Integer>> dao) {
        this.dao = dao;
    }

    public List<Tactic> getTactics() {
        return dao.get().queryForAll();
    }

    public void save(List<Tactic> tactics) {
        for (Tactic chapter : tactics)
            dao.get().createOrUpdate(chapter);
    }
}