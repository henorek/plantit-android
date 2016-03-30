package com.henorek.plantit.data.utils

import android.media.AudioManager
import android.telephony.TelephonyManager
import com.github.pwittchen.reactivenetwork.library.ConnectivityStatus
import rx.subjects.PublishSubject
import javax.inject.Inject

class ConnectionUtils @Inject
constructor(private val telephonyManager: ConnectivityStatus) {

  //    private val subject = PublishSubject.create<ConnectivityStatus>()
  //    val audioFocusListener = AudioManager.OnAudioFocusChangeListener { focusChange ->
  //        if (telephonyManager.callState != TelephonyManager.CALL_STATE_IDLE) {
  //            subject.onNext(LOSS_INCOMING_CALL)
  //        } else {
  //            when (focusChange) {
  //                AudioManager.AUDIOFOCUS_GAIN -> subject.onNext(GAIN)
  //                AudioManager.AUDIOFOCUS_LOSS -> subject.onNext(LOSS)
  //                AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK -> subject.onNext(LOSS_TRANSIENT_CAN_DUCK)
  //                AudioManager.AUDIOFOCUS_LOSS_TRANSIENT -> subject.onNext(LOSS_TRANSIENT)
  //            }
  //        }
  //    }
  //
  //    fun observable() = subject.asObservable()

}