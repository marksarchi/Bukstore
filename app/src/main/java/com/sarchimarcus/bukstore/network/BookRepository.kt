package com.sarchimarcus.bukstore.network

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.sarchimarcus.bukstore.models.Volumes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import retrofit2.await
import javax.security.auth.callback.Callback

class BookRepository {

    // Create a Coroutine scope using a job to be able to cancel when needed
    private var bookRepoJob = Job()
    private val context: Context?=null

    // the Coroutine runs using the Main (UI) dispatcher
    private val coroutineScope = CoroutineScope(bookRepoJob + Dispatchers.Main)
    private val result = MutableLiveData<Volumes>()


    fun getBooks(searchText:String): MutableLiveData<Volumes> {
        coroutineScope.launch {
            var getBooksDeferred  = BookApi.retrofitService.getBooks(searchText)
            Log.e("BookRepository",getBooksDeferred.toString())
            try{
                val listResult = getBooksDeferred.await()
                Log.e("BookRepository","FetchSuccessful")

                result.value=listResult
            }
            catch (e:Exception){
                Log.e("BookRepository","FetchFailed" + e.localizedMessage)


            }
        }
        return result

    }
}
/*  coroutineScope.launch {
      var getBooksDeferred  = BookApi.retrofitService.getBooks(searchText)
      Log.e("BookRepository",getBooksDeferred.toString())
      try{
          val listResult = getBooksDeferred.await()
          Log.e("BookRepository","FetchSuccessful")

          result.value=listResult
      }
      catch (e:Exception){
          Log.e("BookRepository","FetchFailed" + e.localizedMessage)


      }
  }
 return result
*/
/* val call: Call<Volumes> = BookApi.retrofitService.getBooks(searchText)
        Log.e("BookRepository", "Call:" + call.request().url())
        Log.e("BookRepository", "SearchText:$searchText")

        val bookData = MutableLiveData<Volumes?>()
        call.enqueue(object : retrofit2.Callback<Volumes?> {
            override fun onResponse(
                call: Call<Volumes?>,
                response: Response<Volumes?>
            ) {
                if (response.isSuccessful) {
                    Log.e("BookRepository", "FETCH Successful ")
                    bookData.setValue(response.body())
                }
            }

            override fun onFailure(call: Call<Volumes?>, t: Throwable) {
                bookData.setValue(null)
                Toast.makeText(context, t.localizedMessage, Toast.LENGTH_SHORT).show()
                Log.e("BookRepository", "FETCH FAILED ")
            }
        })
        return bookData*/
