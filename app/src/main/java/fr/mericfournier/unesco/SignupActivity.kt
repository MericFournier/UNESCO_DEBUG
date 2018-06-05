package fr.mericfournier.unesco

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_signup.*

class SignupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        signUpButton.setOnClickListener {
            Toast.makeText(this,
                    "Sign up in progress",
                    Toast.LENGTH_SHORT)
                    .show()

            tryToLogin()
        }

        registeredButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

    }

    fun tryToLogin() {
        val email = emailEditText.text
        val password = passwordEditText.text

        if (!email.isEmpty() && !password.isEmpty()) {
            // Display success
            Toast.makeText(this,
                    "Your account has been created",
                    Toast.LENGTH_SHORT)
                    .show()

            //val intent = Intent(this, HomePageActivity::class.java)
            //startActivityForResult(intent, 99)

        } else {
            // Display error

            val builder = AlertDialog.Builder(this@SignupActivity)
            builder.setMessage("Message d'information !")
                    .setTitle("Alerte")
                    .setCancelable(true)
                    .setNegativeButton("NON", { view, which ->

                    })
                    .setPositiveButton("OUI", { view, which ->

                    })

            val dialog = builder.create()
            dialog.show()
        }
    }
}
