package fr.mericfournier.unesco

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_critere.*

class CritereActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_critere)

        // navigation

        critère__button__back.setOnClickListener {
            finish()
        }


        // on reccupère quelle catégorie on est entrain d'afficher
        val extras = intent.extras
        if (extras != null) {
            val value = extras.getString("name")
            //The key argument here must match that used in the other activity
            Toast.makeText(this,
                    value,
                    Toast.LENGTH_SHORT)
                    .show()
            critère__title.text = extras.getString("name")
        }
        else {
            Toast.makeText(this,
                    "error",
                    Toast.LENGTH_SHORT)
                    .show()
        }

        // on fait un appel api pour reccupérer le nom de la catégorie


        // on fait un appel API pour reccupérer tous les items appartenant à cette catégorie


    }
}
