package fr.mericfournier.unesco.profile;

import android.util.Log
import android.widget.Toast
import com.android.volley.NetworkResponse
import com.android.volley.Request
import com.android.volley.VolleyError
import fr.mericfournier.unesco.LoginApplication
import com.neopixl.spitfire.listener.RequestListener
import com.neopixl.spitfire.request.BaseRequest

class UserService {
    interface UserServiceListener {
        fun onReceiveResult(users: List<UserJSON>)
        fun onFailed()
    }

    companion object {
        fun getUser(listener: UserServiceListener) {

            val url = UrlBuilder.getUserUrl()

            var request = BaseRequest
                    // appel une URL en POST et parse le JSON pour faire un objet de type UserResult
                    .Builder<UserResult>(Request.Method.POST, url, UserResult::class.java)
                    .listener(object: RequestListener<UserResult>{
                        override fun onSuccess(request: Request<*>?, response: NetworkResponse?, result: UserResult?) {
                            // La requête s'est bien déroulée

                            if(result is UserResult) {
                                listener.onReceiveResult(result.results)
                            }

                        }

                        override fun onFailure(request: Request<*>?, response: NetworkResponse?, error: VolleyError?) {
                            // La requête a échouée (erreur réseau ou parsing JSON)
                            listener.onFailed()
                        }

                    })

            // Envoi de la requête (appel WS) dans la requestQueue principale
            LoginApplication.instance
                    .requestQueue.add(request.build())

        }
    }

}
