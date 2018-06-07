package fr.mericfournier.unesco;

import android.app.Application
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

class LoginApplication : Application() {

    companion object {
        lateinit var instance: LoginApplication
    }

    lateinit var requestQueue: RequestQueue

    override fun onCreate() {
        super.onCreate()

        LoginApplication.instance = this

        requestQueue = Volley.newRequestQueue(this)
    }
}