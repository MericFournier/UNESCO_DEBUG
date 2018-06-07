package fr.mericfournier.unesco

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.Toast
import com.android.volley.NetworkResponse
import com.android.volley.Request
import com.android.volley.VolleyError
import com.neopixl.spitfire.listener.RequestListener
import com.neopixl.spitfire.request.BaseRequest
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        logInButton.setOnClickListener {
            Toast.makeText(this,
                    "Login in progress",
                    Toast.LENGTH_SHORT)
                    .show()

            tryToLogin()
        }

        unregisteredButton.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }

    }

    private fun tryToLogin() {
        val email = emailEditText.text
        val password = passwordEditText.text

        if (!email.isEmpty() && !password.isEmpty()) {
            // Display success

            Toast.makeText(this,
                    "Success in log in",
                    Toast.LENGTH_SHORT)
                    .show()
<<<<<<< HEAD
            val intent = Intent(this, homeActivity::class.java)
            startActivityForResult(intent, 99)
=======

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
>>>>>>> ac583a2c17dd8e98c2d679278862bc103e694f9d

        } else {
            // Display error

            Toast.makeText(this,
                    "Your can't log in",
                    Toast.LENGTH_SHORT)
                    .show()
        }
    }
}
