package fr.mericfournier.unesco

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.Toast
import fr.mericfournier.unesco.model.User
import fr.mericfournier.unesco.profile.UserJSON
import fr.mericfournier.unesco.profile.UserService
import kotlinx.android.synthetic.main.activity_profile.*
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
        val firstname = firstnameEditText.text
        val lastname = lastnameEditText.text
        val email = emailEditText.text
        val password = passwordEditText.text

        if (!firstname.isEmpty() && !lastname.isEmpty() && !email.isEmpty() && !password.isEmpty()) {
            // Display success

            // Appel au WS
            //UserService.getUser(object: UserService.UserServiceListener{
                //override fun onReceiveResult(users: List<UserJSON>) {

                    //val UserList = arrayListOf<User>()

                    //UserList.add(User("firstname","lastname", "email", "password"))

                    //itemAdapter.clear() // nettoyage de la liste avant de la remplir

                    // Remplissage de l'adapter à partir des objets UserJSON, retransformé en Contact -> ContactItem
                    //for(UserJSON in users) {
                        //UserList.add(User("firstname", "lastname", "email", "password"))
                    //}
                //}

                //override fun onFailed() {

                //}

            //})

            Toast.makeText(this,
                    "Your account has been created",
                    Toast.LENGTH_SHORT)
                    .show()

            val intent = Intent(this, MainActivity::class.java)
            startActivityForResult(intent,43)

        } else {
            // Display error

            Toast.makeText(this,
                    "Your account can't be created",
                    Toast.LENGTH_SHORT)
                    .show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 43) {
            if (resultCode == Activity.RESULT_OK) {
                Toast.makeText(this, "SUCCESS", Toast.LENGTH_SHORT).show()

                if (data != null) {
                    val firstname = data.extras.getString("firstname");
                    firstnameProfileTextView.setText(firstname)
                    val lastname = data.extras.getString("lastname");
                    lastnameProfileTextView.setText(lastname)
                }
            }
        }
    }
}
