package com.kriztech.kriznotes.presentation.navigation

import androidx.annotation.Nullable
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDeepLink
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.kriztech.kriznotes.presentation.components.defaultScreenEnterAnimation
import com.kriztech.kriznotes.presentation.components.defaultScreenExitAnimation
import com.kriztech.kriznotes.presentation.components.slideScreenEnterAnimation
import com.kriztech.kriznotes.presentation.components.slideScreenExitAnimation
import kotlin.reflect.typeOf

fun NavGraphBuilder.animatedComposable(
    route: String,
    arguments: List<NamedNavArgument> = emptyList(),
    deepLinks: List<NavDeepLink> = emptyList(),
    content: @Composable AnimatedVisibilityScope.(NavBackStackEntry) -> Unit
) = composable(
    route = route,
    arguments = arguments,
    deepLinks = deepLinks,
    enterTransition = { defaultScreenEnterAnimation() },
    exitTransition = { defaultScreenExitAnimation() },
    popEnterTransition = { defaultScreenEnterAnimation() },
    popExitTransition = { defaultScreenExitAnimation() },
    content = content
)

fun NavGraphBuilder.slideInComposable(
    route: String,
    arguments: List<NamedNavArgument> = emptyList(),
    deepLinks: List<NavDeepLink> = emptyList(),
    content: @Composable AnimatedVisibilityScope.(NavBackStackEntry) -> Unit
) = composable(
    route = route,
    arguments = arguments,
    deepLinks = deepLinks,
    enterTransition = { slideScreenEnterAnimation() },
    exitTransition = { defaultScreenExitAnimation() },
    popEnterTransition = { defaultScreenEnterAnimation() },
    popExitTransition = { slideScreenExitAnimation() },
    content = content
)