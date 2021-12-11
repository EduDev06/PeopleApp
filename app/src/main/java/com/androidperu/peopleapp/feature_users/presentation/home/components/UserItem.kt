package com.androidperu.peopleapp.feature_users.presentation.home.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.androidperu.peopleapp.feature_users.domain.model.User
import com.androidperu.peopleapp.ui.theme.PeopleAppTheme

@Composable
fun UserItem(
    modifier: Modifier = Modifier,
    user: User,
    onEditUser: () -> Unit,
    onDeleteUser: () -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 14.dp, vertical = 12.dp),
        elevation = 3.dp,
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(verticalArrangement = Arrangement.Center) {
                Text(
                    text = "${user.name}, ${user.lastName}",
                    style = MaterialTheme.typography.h6
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = user.age.toString(),
                    style = MaterialTheme.typography.caption.copy(color = Color.DarkGray)
                )
            }
            Row {
                IconButton(onClick = onEditUser) {
                    Icon(
                        imageVector = Icons.Filled.Edit,
                        contentDescription = null,
                        tint = Color.Green
                    )
                }
                IconButton(onClick = onDeleteUser) {
                    Icon(
                        imageVector = Icons.Filled.Delete,
                        contentDescription = null,
                        tint = Color.Red
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewUserItem() {
    PeopleAppTheme {
        UserItem(
            user = User(name = "Adam", lastName = "Smith", age = 15),
            onEditUser = {},
            onDeleteUser = {}
        )
    }
}