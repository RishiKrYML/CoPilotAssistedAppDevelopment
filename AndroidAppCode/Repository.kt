package com.example.copiloytest

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class Repository {

    // create a function named 'getAllUsersDetails' with no parameters and return type of List of User
    // make an api call to api https://reqres.in/api/users?page=2 and get the list of users
    // create a function named 'getAllUsersDetails' with no parameters and return type of List of User
    suspend fun getAllUsersDetails(): List<User> {
        // create a list of users
        val users = mutableListOf<User>()
        // launch suspend function and wait for it to finish
        // create a coroutine scope
        val scope = CoroutineScope(Dispatchers.IO)
        // launch a coroutine
        scope.launch {
            // make an api call to api https://reqres.in/api/users?page=2 and get the list of users
            val response = RetrofitInstance.api.getAllUsers()
            // check if the response is successful
            if (response.isSuccessful) {
                // get the list of users from the response
                val list = response.body()?.data
                // check if the list is not null
                if (list != null) {
                    // add the list of users to the users list
                    users.addAll(list)
                }
            }
        }
            // wait for the coroutine to finish
        .join()

        // return the list of users
        return users
    }
}


// create a RetrofitInstance class with a companion object that will create a retrofit instance and an api object that will be used to make api calls
class RetrofitInstance {
    companion object {
        // create a retrofit instance
        private val retrofit by lazy {
            Retrofit.Builder()
                .baseUrl("https://reqres.in/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
       // create an api object that will be used to make api calls
        val api: Api by lazy {
            retrofit.create(Api::class.java)
        }
    }
}


// create an Api interface that will be used to make api calls
interface Api {
    // create a function named 'getAllUsers' with no parameters and return type of Response of List of User and annotate it with @GET with path /api/users?page=2
    @GET("/api/users?page=2")
    suspend fun getAllUsers(): Response<ResponseData>
}

// create a USER data model class with 4 properties first name , last name , id and avatar
data class User(
    val first_name: String,
    val last_name: String,
    val id: Int,
    val avatar: String
)

// create a response data model class with page , per page , total and total pages properties and list of users
data class ResponseData(
    val page: Int,
    val per_page: Int,
    val total: Int,
    val total_pages: Int,
    val data: List<User>
)