package com.kriztech.kriznotes.presentation.screens.settings

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Code
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Language
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.kriztech.kriznotes.R
import com.kriztech.kriznotes.core.constant.ConnectionConst
import com.kriztech.kriznotes.presentation.screens.settings.model.SettingsViewModel
import com.kriztech.kriznotes.presentation.screens.settings.settings.shapeManager
import com.kriztech.kriznotes.presentation.screens.settings.widgets.ActionType
import com.kriztech.kriznotes.presentation.screens.settings.widgets.SettingsBox

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SupportContent(
    navController: NavController,
    settingsViewModel: SettingsViewModel,
    onExit: () -> Unit
) {
    val uriHandler = LocalUriHandler.current

    ModalBottomSheet(
        containerColor = MaterialTheme.colorScheme.surfaceContainerLow,
        onDismissRequest = { onExit() }
    ) {
        Column(
            modifier = Modifier.padding(20.dp, 0.dp, 20.dp, 28.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.kriznotes_logo),
                contentDescription = "KrizNotes Logo",
                modifier = Modifier
                    .size(72.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "KrizNotes",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = "We don't need money from our users — we believe in giving you free and open source tools. We just want your love and support!",
                fontSize = 13.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center,
                lineHeight = 18.sp
            )
            Spacer(modifier = Modifier.height(20.dp))
            SettingsBox(
                size = 8.dp,
                title = "Instagram (@altkriz)",
                icon = Icons.Rounded.Favorite,
                isCentered = true,
                actionType = ActionType.LINK,
                radius = shapeManager(isFirst = true, radius = settingsViewModel.settings.value.cornerRadius),
                linkClicked = { uriHandler.openUri(ConnectionConst.SUPPORT_INSTAGRAM) }
            )
            SettingsBox(
                title = "GitHub (altkriz/KrizNotes)",
                size = 8.dp,
                isCentered = true,
                icon = Icons.Rounded.Code,
                radius = shapeManager(radius = settingsViewModel.settings.value.cornerRadius),
                actionType = ActionType.LINK,
                linkClicked = { uriHandler.openUri(ConnectionConst.GITHUB_SOURCE_CODE) }
            )
            SettingsBox(
                title = "Website (altkriz.github.io)",
                size = 8.dp,
                icon = Icons.Rounded.Language,
                isCentered = true,
                actionType = ActionType.LINK,
                radius = shapeManager(radius = settingsViewModel.settings.value.cornerRadius, isLast = true),
                linkClicked = { uriHandler.openUri(ConnectionConst.WEBSITE) }
            )
        }
    }
}
