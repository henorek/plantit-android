package net.henorek.plantit.ui.base;

/**
 * Created by Jarek Jankowski on 2016-01-18.
 * jarosz1994@gmail.com
 */
public abstract class BasePresenter<T extends IBaseView> {

    public abstract void loadData(boolean refresh);

}
