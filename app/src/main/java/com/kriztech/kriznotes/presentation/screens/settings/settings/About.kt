package com.kriztech.kriznotes.presentation.screens.settings.settings

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ContactSupport
import androidx.compose.material.icons.rounded.BugReport
import androidx.compose.material.icons.rounded.Build
import androidx.compose.material.icons.rounded.Code
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.Language
import androidx.compose.material.icons.rounded.Verified
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.kriztech.kriznotes.R
import com.kriztech.kriznotes.core.constant.ConnectionConst
import com.kriztech.kriznotes.presentation.screens.settings.SettingsScaffold
import com.kriztech.kriznotes.presentation.screens.settings.model.SettingsViewModel
import com.kriztech.kriznotes.presentation.screens.settings.widgets.ActionType
import com.kriztech.kriznotes.presentation.screens.settings.widgets.SettingsBox

@Composable
fun AboutScreen(navController: NavController, settingsViewModel: SettingsViewModel) {
    val uriHandler = LocalUriHandler.current

    SettingsScaffold(
        settingsViewModel = settingsViewModel,
        title = stringResource(id = R.string.about),
        onBackNavClicked = { navController.navigateUp() }
    ) {
        LazyColumn {
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.kriznotes_logo),
                        contentDescription = "KrizNotes Logo",
                        modifier = Modifier
                            .size(80.dp)
                            .clip(CircleShape)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "KrizNotes",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = "Simple, Private & Open Source",
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
            }

            item {
                SettingsBox(
                    settingsViewModel = settingsViewModel,
                    title = stringResource(id = R.string.build_type),
                    description = settingsViewModel.build,
                    icon = Icons.Rounded.Build,
                    actionType = ActionType.TEXT,
                    radius = shapeManager(isFirst = true, radius = settingsViewModel.settings.value.cornerRadius)
                )
            }
            item {
                SettingsBox(
                    settingsViewModel = settingsViewModel,
                    title = stringResource(id = R.string.version),
                    description = settingsViewModel.version,
                    icon = Icons.Rounded.Info,
                    actionType = ActionType.TEXT,
                    radius = shapeManager(isLast = true, radius = settingsViewModel.settings.value.cornerRadius),
                )
                Spacer(modifier = Modifier.height(18.dp))
            }

            item {
                SettingsBox(
                    settingsViewModel = settingsViewModel,
                    title = stringResource(id = R.string.latest_release),
                    icon = Icons.Rounded.Verified,
                    actionType = ActionType.LINK,
                    radius = shapeManager(isFirst = true, radius = settingsViewModel.settings.value.cornerRadius),
                    linkClicked = { uriHandler.openUri(ConnectionConst.GITHUB_RELEASES) }
                )
            }
            item {
                SettingsBox(
                    settingsViewModel = settingsViewModel,
                    title = stringResource(id = R.string.source_code),
                    icon = Icons.Rounded.Code,
                    actionType = ActionType.LINK,
                    radius = shapeManager(isLast = true, radius = settingsViewModel.settings.value.cornerRadius),
                    linkClicked = { uriHandler.openUri(ConnectionConst.GITHUB_SOURCE_CODE) }
                )
                Spacer(modifier = Modifier.height(18.dp))
            }

            item {
                SettingsBox(
                    settingsViewModel = settingsViewModel,
                    title = stringResource(id = R.string.email),
                    description = ConnectionConst.SUPPORT_MAIL,
                    icon = Icons.Rounded.Email,
                    clipboardText = ConnectionConst.SUPPORT_MAIL,
                    actionType = ActionType.CLIPBOARD,
                    radius = shapeManager(isFirst = true, radius = settingsViewModel.settings.value.cornerRadius),
                )
            }
            item {
                SettingsBox(
                    settingsViewModel = settingsViewModel,
                    size = 8.dp,
                    title = "Instagram (@altkriz)",
                    icon = Icons.AutoMirrored.Rounded.ContactSupport,
                    actionType = ActionType.LINK,
                    linkClicked = { uriHandler.openUri(ConnectionConst.SUPPORT_INSTAGRAM) },
                    radius = shapeManager(radius = settingsViewModel.settings.value.cornerRadius),
                )
            }
            item {
                SettingsBox(
                    settingsViewModel = settingsViewModel,
                    size = 8.dp,
                    title = "Website (altkriz.github.io)",
                    icon = Icons.Rounded.Language,
                    actionType = ActionType.LINK,
                    linkClicked = { uriHandler.openUri(ConnectionConst.WEBSITE) },
                    radius = shapeManager(radius = settingsViewModel.settings.value.cornerRadius),
                )
            }
            item {
                SettingsBox(
                    settingsViewModel = settingsViewModel,
                    size = 8.dp,
                    title = stringResource(id = R.string.feature),
                    icon = Icons.Rounded.BugReport,
                    linkClicked = { uriHandler.openUri(ConnectionConst.GITHUB_FEATURE_REQUEST) },
                    actionType = ActionType.LINK,
                    radius = shapeManager(isLast = true, radius = settingsViewModel.settings.value.cornerRadius),
                )
            }
        }
    }
}
