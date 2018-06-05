package fr.mericfournier.unesco.network

import com.android.volley.NetworkResponse
import com.android.volley.Request
import com.android.volley.VolleyError
import com.neopixl.spitfire.listener.RequestListener
import com.neopixl.spitfire.request.BaseRequest
import fr.mericfournier.unesco.UnescoApp

// perso
import java.util.Arrays
import android.util.Log


class LieuService {

    interface LieuServiceListener {
        fun onReceiveResult(contacts: List<LieuJSON>)
        fun onFailed()
    }

    companion object {
        fun getLieu(listener: LieuServiceListener) {

            val url = "https://unesco.antoine-dunn.fr/api/v1/site/12"

            var request = BaseRequest
                    // appel une URL en GET et parse le JSON pour faire un objet de type ContactResult
                    .Builder<LieuResult>(Request.Method.GET, url, LieuResult::class.java)
                    .listener(object: RequestListener<LieuResult>{
                        override fun onSuccess(request: Request<*>?, response: NetworkResponse?, result: LieuResult?) {
                            // La requête s'est bien déroulée

                            if(result is LieuResult) {
                                listener.onReceiveResult(result.results)
                                Log.d("result","its bad")

                            }

                        }

                        override fun onFailure(request: Request<*>?, response: NetworkResponse?, error: VolleyError?) {
                            // La requête a échouée (erreur réseau ou parsing JSON)
                            listener.onFailed()
                            Log.d("result","its bad")
                        }

                    })

            // Envoi de la requête (appel WS) dans la requestQueue principale
            UnescoApp.instance
                    .requestQueue.add(request.build())

        }
    }

}