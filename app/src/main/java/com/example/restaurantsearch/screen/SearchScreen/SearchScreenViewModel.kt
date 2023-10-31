//package com.example.restaurantsearch.screen.SearchScreen
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.restaurantsearch.data.Restaurant
//import com.example.restaurantsearch.data.RestaurantApi
//import com.example.restaurantsearch.data.api.RestaurantRepository
//import com.example.restaurantsearch.data.api.request.API_KEY
//import com.example.restaurantsearch.data.dataSource.Article
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.launch
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//import retrofit2.create
//
////class SearchScreenViewModel : ViewModel() {
////    private val repository = RestaurantRepository()
////    fun searchRestaurants(apiKey: String, keyword: String, onResult: (List<Article>?) -> Unit) {
////        viewModelScope.launch(Dispatchers.IO) {
////            try {
////                val result = repository.searchRestaurants(apiKey, keyword)
////                onResult(result)
////            } catch (e: Exception) {
////                // エラーハンドリングを行う
////                onResult(null)
////            }
////        }
////    }
////}
////
////fun fetchRestaurants(apiKey: String, keyword: String): List<Restaurant> {
////    val retrofit = Retrofit.Builder()
////        .baseUrl("http://webservice.recruit.co.jp/hotpepper/gourmet/")
////        .addConverterFactory(GsonConverterFactory.create())
////        .build()
////
////    val restaurantApi = retrofit.create<RestaurantApi>()
////
////    val response = restaurantApi.searchRestaurants(API_KEY, keyword)
////
////    if (response.isSuccessful) {
////        return response.body()?.results?.shop ?: emptyList()
////    } else {
////        throw Exception("Failed to fetch data from the API")
////    }
////}