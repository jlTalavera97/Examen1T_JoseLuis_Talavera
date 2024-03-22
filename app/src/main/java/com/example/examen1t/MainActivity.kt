package com.example.examen1t

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.examen1t.ui.theme.Examen1TTheme
import com.example.examen1t.ui.theme.ExamenUiState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Examen1TTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ExamenApp(modifier = Modifier.padding(40.dp))
                }
            }
        }
    }
}

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun ExamenApp(examenViewModel:ExamenViewModel = viewModel(), modifier: Modifier) {
    val examenUiState by examenViewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            ExamenTopAppBar()
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Text(
                text = stringResource(R.string.welcome),
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .align(alignment = Alignment.Start),
            )
            EditNameField(R.string.input_name,examenViewModel,examenUiState)
            EditSurnameField(R.string.input_surname,examenViewModel,examenUiState)
            EditAgeField(R.string.input_age,examenViewModel,examenUiState)
            EditBirhtLocationField(R.string.input_birthplace,examenViewModel,examenUiState)
            Text(
                //text = "José López tiene 17 años y ha nacido en Madrid",
                text ="${examenViewModel.uiState.value.name} tiene ${examenViewModel.uiState.value.age} años y ha nacido en ${examenViewModel.uiState.value.birthLocation}" ,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}



@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun EditNameField(label: Int, examenViewModel: ExamenViewModel, examenUiState: ExamenUiState) {

    TextField(
        value = examenUiState.name,
        onValueChange = {examenViewModel.updateName(it)},
        label = { Text(stringResource(label)) },
        modifier = Modifier.padding(16.dp)
    )
}


@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun EditSurnameField(label: Int, examenViewModel: ExamenViewModel, examenUiState: ExamenUiState) {

    TextField(
        value = examenUiState.surname,
        onValueChange = {examenViewModel.updateSurname(it)},
        label = { Text(stringResource(label)) },
        modifier = Modifier.padding(16.dp)
    )
}

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun EditBirhtLocationField(label: Int, examenViewModel: ExamenViewModel, examenUiState: ExamenUiState) {

    TextField(
        value = examenUiState.birthLocation,
        onValueChange = {examenViewModel.updateBirthLocation(it)},
        label = { Text(stringResource(label)) },
        modifier = Modifier.padding(16.dp)
    )
}

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun EditAgeField(@StringRes label: Int, examenViewModel: ExamenViewModel, examenUiState: ExamenUiState) {

   TextField(
       value = examenUiState.age.toString(),
       onValueChange = {examenViewModel.updateAge(it.toInt())},
       label = { Text(stringResource(label))},
       modifier = Modifier.padding(16.dp)
   )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExamenTopAppBar(
    modifier: Modifier = Modifier
){
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.headlineSmall,
            )
        },
    )

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Examen1TTheme {
        ExamenApp(modifier = Modifier.padding(40.dp))
    }
}