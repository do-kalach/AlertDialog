package com.example.alertdialog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.alertdialog.ui.theme.AlertDialogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlertDialogTheme {
                DialogBox()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, showSystemUi = true, name = "FirstView")
@Composable
private fun DialogBox() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.secondaryContainer),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val openDialogOne = remember { mutableStateOf(false) }
        val openDialogSecond = remember { mutableStateOf(false) }
        val openDialogThird = remember { mutableStateOf(false) }
        val openDialog = remember { mutableStateOf(false) }
        var text by remember { mutableStateOf("") }

        Button(onClick = { openDialogOne.value = true }, content = {
            Text(text = "Dialog")
        })
        /** 2 */
        Button(onClick = { openDialogSecond.value = true }, content = {
            Text(text = "Dialog With Icon")
        })
        /** 3 */
        Button(onClick = { openDialogThird.value = true }, content = {
            Text(text = "Dialog With TextField")
        })
        /** 4 */
        Button(onClick = { openDialog.value = true }, content = {
            Text(text = "Dialog With Content")
        })

        if (openDialogOne.value) { //check the state for dialog open or not
            AlertDialog(onDismissRequest = { openDialogOne.value = false },//to close dialog
                confirmButton = {
                    //onclick TextButton Cancel Dialog
                    TextButton(onClick = { openDialogOne.value = false }) {
                        Text(text = "Confirm")
                    }

                }, title = {
                    Text(text = "My Dialog Title")
                }, text = {
                    Text(text = "Normal Basic Text Here ")
                }, dismissButton = {
                    TextButton(onClick = { openDialogOne.value = false }) {
                        Text(text = "Cancel")
                    }
                }

            )
        }

        /** 2nd Dialog*/
        if (openDialogSecond.value) {

            AlertDialog(onDismissRequest = { openDialogSecond.value = false },
                confirmButton = {
                    TextButton(onClick = { openDialogSecond.value = false }) {
                        Text(text = "Confirm")
                    }
                },
                text = { Text(text = "Basic Text ") },
                title = { Text(text = "My Title") },
                icon = {
                    Icon(
                        imageVector = Icons.Default.Info, contentDescription = null
                    )
                },
                dismissButton = {
                    TextButton(onClick = { openDialogSecond.value = false }) {
                        Text(text = "Cancel")
                    }
                }


            )
        }

        /** 3rd Dialog*/
        if (openDialogThird.value) {

            AlertDialog(onDismissRequest = { openDialogThird.value = false },
                confirmButton = {
                    Row(
                        modifier = Modifier.padding(8.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Button(
                            onClick = { openDialogThird.value = false },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(text = "Confirm")
                        }

                    }
                },
                title = {
                    Text(text = "My Title 3")
                },
                text = {
                    Column {
                        OutlinedTextField(
                            value = text,
                            onValueChange = { text = it },
                            label = {
                                Text(text = "Enter the Name")
                            }
                        )
                        Text(text = "Normal Text if you need ")
                        Checkbox(checked = false, onCheckedChange = {})
                    }

                }
            )


        }

        /** 4th Dialog */

        if (openDialog.value) {
            Dialog(onDismissRequest = { openDialog.value = false }) {
                Surface(
                    modifier = Modifier
                        .wrapContentWidth()
                        .wrapContentHeight()
                ) {

                    Column(Modifier.padding(8.dp)) {
                        Text(text = stringResource(id = R.string.dummy_text))
                        Spacer(modifier = Modifier.height(24.dp))
                        TextButton(
                            onClick = { openDialog.value = false },
                            modifier = Modifier.align(Alignment.End)
                        ) {
                            Text(text = "Cancel")
                        }
                    }

                }

            }

        }

    }
}