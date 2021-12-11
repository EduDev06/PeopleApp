package com.androidperu.peopleapp.feature_users.presentation.edit

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.androidperu.peopleapp.R
import com.androidperu.peopleapp.feature_users.presentation.edit.components.UserInputText
import com.androidperu.peopleapp.ui.theme.PeopleAppTheme
import kotlinx.coroutines.flow.collectLatest

@Composable
fun EditScreen(
    navController: NavController,
    viewModel: EditViewModel = hiltViewModel()
) {
    val nameState = viewModel.userName.value
    val lastNameState = viewModel.userLastName.value
    val ageState = viewModel.userAge.value

    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is EditViewModel.UiEvent.SaveUser -> {
                    navController.navigateUp()
                }
            }
        }
    }
    
    Scaffold(
        topBar = {
            EditTopBar(
                topAppBarText = stringResource(id = R.string.add_user)
            )
        },
        content = {
            EditContent(
                name = nameState.text,
                lastName = lastNameState.text,
                age = ageState.text,
                onEvent = { viewModel.onEvent(it) }
            )
        },
        bottomBar = {
            EditBottomBar(
                onInsertUser = { viewModel.onEvent(EditEvent.InsertUser) }
            )
        }
    )
}

@Composable
fun EditTopBar(topAppBarText: String) {
    TopAppBar(
        title = {
            Text(
                text = topAppBarText,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
            )
        },
        backgroundColor = MaterialTheme.colors.surface
    )
}

@Composable
fun EditContent(
    name: String,
    lastName: String,
    age: String,
    onEvent: (EditEvent) -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Spacer(modifier = Modifier.height(44.dp))
        UserInputText(
            text = name,
            hint = stringResource(id = R.string.name),
            onTextChange = { onEvent(EditEvent.EnteredName(it)) }
        )
        UserInputText(
            text = lastName,
            hint = stringResource(id = R.string.last_name),
            onTextChange = { onEvent(EditEvent.EnteredLastName(it)) }
        )
        UserInputText(
            text = age,
            hint = stringResource(id = R.string.age),
            onTextChange = { onEvent(EditEvent.EnteredAge(it)) }
        )
    }
}

@Composable
fun EditBottomBar(
    modifier: Modifier = Modifier,
    onInsertUser: () -> Unit
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 14.dp),
        onClick = { onInsertUser() }
    ) {
        Text(text = stringResource(id = R.string.add_user))
    }
}

@Preview
@Composable
fun PreviewAddEditUserTopBar() {
    PeopleAppTheme {
        EditTopBar(
            topAppBarText = stringResource(id = R.string.add_user)
        )
    }
}

@Preview
@Composable
fun PreviewAddEditUserContent() {
    PeopleAppTheme {
        EditContent(
            name = "Ada",
            lastName = "Smith",
            age = "20",
            onEvent = { }
        )
    }
}

@Preview
@Composable
fun PreviewAddEditBottomBar() {
    PeopleAppTheme {
        EditBottomBar {}
    }
}