package net.henorek.plantit.ui.widgets.controls;

import android.accounts.NetworkErrorException;

/**
 * Created by Jarek Jankowski on 2016-01-22.
 * jarosz1994@gmail.com
 */
public class ErrorMessageDeterminer {

    public String getErrorMessage(Throwable e, boolean pullToRefresh) {
        if (e.getCause() instanceof NetworkErrorException) {
            return "Network Error: Are you connected to the internet?";
        }
        return "An unknown error has occurred";
    }
}
