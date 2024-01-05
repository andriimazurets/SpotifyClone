package com.example.spotifyclone.exoplayer

import android.content.Context
import android.support.v4.media.session.MediaSessionCompat
import com.example.spotifyclone.R
import com.google.android.exoplayer2.ui.PlayerNotificationManager

class MusicNotificationManager(
    private val context: Context,
    sessionToken: MediaSessionCompat.Token,
    notificationListener: PlayerNotificationManager.NotificationListener,
    private val newSongCallback: () -> Unit
) {
    private val notificationManager: PlayerNotificationManager

    init {
        notificationManager = PlayerNotificationManager.Builder(
            context,
            NOTIFICATION_ID, NOTIFICATION_CHANNEL_ID)
            .setChannelNameResourceId(R.string.notification_channel_name)
            .setChannelDescriptionResourceId(R.string.notification_channel_description)
            .setMediaDescriptionAdapter(DescriptionAdapter(mediaController))
            .setNotificationListener(notificationListener)
            .build()
            .apply {
                setSmallIcon(R.drawable.ic_music)
                setMediaSessionToken(sessionToken)
            }


    }
}