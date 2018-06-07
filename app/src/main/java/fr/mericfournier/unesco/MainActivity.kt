package fr.mericfournier.unesco

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
<<<<<<< HEAD
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

=======
import kotlinx.android.synthetic.main.activity_main.*
>>>>>>> ac583a2c17dd8e98c2d679278862bc103e694f9d

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

<<<<<<< HEAD
        Log.d("KOTLIN_APP",
                ""+"teest")

        fun test1() {
            Toast.makeText(this,
                    "Ok",
                    Toast.LENGTH_SHORT)
                    .show()
        }

        home__1.setOnClickListener {
            test1()
        }

=======
>>>>>>> ac583a2c17dd8e98c2d679278862bc103e694f9d
    }
}
