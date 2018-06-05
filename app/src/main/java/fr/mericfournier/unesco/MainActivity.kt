package fr.mericfournier.unesco

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

    }
}
