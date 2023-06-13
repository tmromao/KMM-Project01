package com.example.kmmproject01.android.ui.components

import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.example.kmmproject01.android.DependencyInjectionForPreview
import com.example.kmmproject01.android.R
import com.example.kmmproject01.android.ui.theme.AndroidAppTheme
import com.example.kmmproject01.android.utils.connectivityState
import com.example.kmmproject01.resources.Resources
import com.example.kmmproject01.utils.ConnectivityProperty
import com.example.kmmproject01.utils.ConnectivityState
import com.example.kmmproject01.utils.OfflineProperty
import com.example.kmmproject01.utils.OnlineProperty
import kotlinx.coroutines.delay

// 1) Como definir estados de Online, Offline em KMM e properties
// 2) Como obter/observar o estado de rede de internet em compose
// 3) Como criar um componente reutilizavel para exibir conetividade

@Composable
fun ShowConnectivityStatus(languageChanged: Boolean = false) {
    val connectivityState by connectivityState()
    val isConnected = connectivityState == ConnectivityState.Online

    ConnectivityView(
        isConnected = isConnected || languageChanged,
        online = OnlineProperty(),
        offline = OfflineProperty()
    )
}

@Composable
@Suppress("LiftReturnOrAssignment")
fun ConnectivityView(isConnected: Boolean, online: ConnectivityProperty, offline: ConnectivityProperty) {
    var visibility by remember { mutableStateOf(false) }

    AnimatedVisibility(
        visible = visibility,
        enter = expandVertically(),
        exit = shrinkVertically()
    ) {
        ConnectivityMessage(isConnected = isConnected, online, offline)
    }

    LaunchedEffect(isConnected) {
        if (!isConnected) {
            visibility = true
        } else {
            delay(online.slideOutDurationInSeconds * 1000L)
            visibility = false
        }
    }
}

@Composable
fun ConnectivityMessage(isConnected: Boolean, online: ConnectivityProperty, offline: ConnectivityProperty) {

    val contentAlignment = Alignment.BottomCenter
    val padding = PaddingValues(
        end = 0.dp,
        start = Resources.Dimen.defaultPadding.start,
        top = Resources.Dimen.defaultPadding.top,
        bottom = Resources.Dimen.defaultPadding.bottom
    )

    val icon = if (isConnected) online.icon.id else offline.icon.id
    val iconColor = if (isConnected) online.iconColor.getColor() else offline.iconColor.getColor()
    val text = "Texto" //if (isConnected) online.text.localized else offline.text.localized
    val textColor = if (isConnected) online.textColor.getColor() else offline.textColor.getColor()
    val textSize = if (isConnected) online.textSize.size else offline.textSize.size
    val backgroundColor by animateColorAsState(if (isConnected) online.backgroundColor.getColor() else offline.backgroundColor.getColor())
    ConnectivityStatus(backgroundColor, padding, contentAlignment, icon, iconColor, text, textColor, textSize)
}

@Composable
private fun ConnectivityStatus(
    backgroundColor: Color,
    padding: PaddingValues,
    contentAlignment: Alignment,
    iconId: Int,
    iconColor: Color,
    text: String,
    textColor: Color,
    textSize: TextUnit,
) {
    Box(
        modifier = Modifier
            .background(backgroundColor)
            .fillMaxWidth()
            .padding(padding),
        contentAlignment = contentAlignment
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(iconId),
                contentDescription = "",
                tint = iconColor
            )
            Text(
                modifier = Modifier.padding(Resources.Dimen.defaultPadding.start, 0.dp, 0.dp, 0.dp),
                text = text,
                color = textColor,
                fontSize = textSize
            )
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DeviceConnectivityMessagePreview() {
    DependencyInjectionForPreview()


    val padding = PaddingValues(
        start = Resources.Dimen.defaultPadding.start,
        end = 0.dp,
        top = Resources.Dimen.defaultPadding.top,
        bottom = Resources.Dimen.defaultPadding.bottom
    )

    val onlineProperty = OnlineProperty()
    val offlineProperty = OfflineProperty()

    AndroidAppTheme {
        Column {
            ConnectivityStatus(
                contentAlignment = Alignment.TopCenter,
                textColor = onlineProperty.textColor.getColor(),
                textSize = onlineProperty.textSize.size,
                backgroundColor = onlineProperty.backgroundColor.getColor(),
                padding = padding,
                iconId = R.drawable.wifi,
                iconColor = onlineProperty.iconColor.getColor(),
                text = "Texto", //onlineProperty.text.localized
            )
            Spacer.Big()
            ConnectivityStatus(
                contentAlignment = Alignment.BottomCenter,
                textColor = offlineProperty.textColor.getColor(),
                textSize = offlineProperty.textSize.size,
                backgroundColor = offlineProperty.backgroundColor.getColor(),
                padding = padding,
                iconId = R.drawable.flash,
                iconColor = offlineProperty.iconColor.getColor(),
                text = "offline", //offlineProperty.text.localized
            )
        }
    }
}