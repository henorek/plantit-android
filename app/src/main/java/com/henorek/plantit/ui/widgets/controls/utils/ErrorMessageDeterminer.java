package com.henorek.plantit.ui.widgets.controls.utils;

import android.accounts.NetworkErrorException;

public class ErrorMessageDeterminer {

  public String getErrorMessage(Throwable e, boolean pullToRefresh) {
    if (e.getCause() instanceof NetworkErrorException) {
      return "Network Error: Are you connected to the internet?";
    }
    return "An unknown error has occurred";
  }
}
