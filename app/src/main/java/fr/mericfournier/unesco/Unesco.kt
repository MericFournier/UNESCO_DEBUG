package fr.mericfournier.unesco

import android.app.Application
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

// Classe centrale (instanciée au démarrage de l'app)
class UnescoApp: Application() {

    companion object {
        lateinit var instance: UnescoApp
    }

    lateinit var requestQueue: RequestQueue

    // Méthode appelée au démarrage de l'app (une seule fois)
    override fun onCreate() {
        super.onCreate()

        UnescoApp.instance = this


        requestQueue = Volley.newRequestQueue(applicationContext)
        requestQueue?.start()
    }

}