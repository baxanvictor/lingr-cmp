@file:OptIn(ExperimentalMaterial3AdaptiveApi::class, ExperimentalMaterial3Api::class)

package dev.vbaxan.workspace.presentation.workspace

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.layout.AnimatedPane
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffold
import androidx.compose.material3.adaptive.navigation.rememberListDetailPaneScaffoldNavigator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dev.vbaxan.workspace.presentation.workspace.components.ScanTargetPicker
import org.koin.compose.viewmodel.koinViewModel

@Composable
internal fun WorkspaceScreen(
    modifier: Modifier = Modifier
) {
    val viewModel = koinViewModel<WorkspaceViewModel>()

    val scaffoldDirective = createNoSpacingPanelScaffoldDirective()
    val scaffoldNavigator = rememberListDetailPaneScaffoldNavigator(
        scaffoldDirective = scaffoldDirective
    )

    val state by viewModel.state.collectAsStateWithLifecycle()

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = state.appInfo.appName,
                        textAlign = TextAlign.Center
                    )
                },
                actions = {
                    ScanTargetPicker(
                        scanTargetsState = state.scanTargets,
                        onClick = {
                            viewModel.onAction(WorkspaceAction.ScanTargets.OnPickerClick)
                        },
                        onDismiss = {
                            viewModel.onAction(WorkspaceAction.ScanTargets.OnPickerDismiss)
                        },
                        recommendedTargetsSelection = viewModel.recommendedTargetsSelection(),
                        onSelectRecommendedTargetsClick = {
                            viewModel.onAction(WorkspaceAction.ScanTargets.OnSelectRecommendedTargetsClick)
                        },
                        onScanTargetItemClick = { scanTarget ->
                            viewModel.onAction(WorkspaceAction.ScanTargets.OnScanTargetClick(scanTarget))
                        }
                    )
                }
            )
        },
        bottomBar = {
            Row(
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Status Bar",
                    textAlign = TextAlign.Center
                )
            }
        }
    ) { innerPadding ->
        ListDetailPaneScaffold(
            modifier = Modifier.padding(innerPadding),
            directive = scaffoldDirective,
            value = scaffoldNavigator.scaffoldValue,
            listPane = {
                AnimatedPane {
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("List screen")
                    }
                }
            },
            detailPane = {
                AnimatedPane {
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Detail screen")
                    }
                }
            }
        )
    }
}