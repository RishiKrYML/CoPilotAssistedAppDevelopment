package com.example.copiloytest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //enable jetpack compose
        setContent {
            // create a mutable state list of users inside remember block
            // create a column with 2 elements. First element a button . Second element ScreensElements()
            val listofusers = remember { mutableStateListOf<User>() }
            Column {
                //create a button with text "Fetch all users details"

                // rememberCoroutineScope() is used to create a coroutine scope
                val scope = rememberCoroutineScope()

                Button(onClick = {
                    // create a coroutine scope

                    // launch a coroutine
                    scope.launch {
                        // call the function to fetch all users details and assign it to the listofusers variable but clear it first
                        listofusers.clear()
                        listofusers.addAll(Repository().getAllUsersDetails())
                    }
                }) {
                    // create a Text with text "Fetch all users details" with bottom padding 16 dp
                    Text(text = "Fetch all users details", modifier = Modifier.padding(bottom = 16.dp))
                }

                ScreensElements(listofusers = listofusers)
            }
        }

    }
}

@Composable
private fun ScreensElements(listofusers: MutableList<User>) {
    // list of users with a modifier of padding 16dp and a vertical scroll and content padding 16dp
    LazyColumn(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        // add items from listofusers
        items(listofusers) { user ->
            ListItem(user = user)
        }
    }
}


// create a list item composable function with circular image and first name and last name in row
@OptIn(ExperimentalGlideComposeApi::class)
@Composable
private fun ListItem(user: User) {

    // create a Row with a modifier of padding 16dp
    Row(
        // content vertical alignment is center
        verticalAlignment = Alignment.CenterVertically,
        // content horizontal alignment is start
        horizontalArrangement = Arrangement.Start,

        ) {
        // glide image with size 100dp and circular shape using url from user.avatar
        GlideImage(
            data = user.avatar,
            contentDescription = "User Avatar",
            modifier = Modifier.size(100.dp),
            requestBuilder = {
                // set the image to be circular
                circleCrop()
            }
        )
        // first name and last name in a column with padding 16dp
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = user.firstName)
            Text(text = user.lastName)
        }
    }
}











