package fr.mericfournier.unesco

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.Toast
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

    fun tryToLogin() {
        val email = emailEditText.text
        val password = passwordEditText.text

        if (!email.isEmpty() && !password.isEmpty()) {
            // Display success

            Toast.makeText(this,
                    "Success in log in",
                    Toast.LENGTH_SHORT)
                    .show()
            val intent = Intent(this, homeActivity::class.java)
            startActivityForResult(intent, 99)

        } else {
            // Display error

            val builder = AlertDialog.Builder(this@LoginActivity)
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
