package fr.mericfournier.unesco

import android.content.Intent
import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.res.ResourcesCompat
<<<<<<< HEAD
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast
import android.support.annotation.NonNull
import android.support.design.widget.BottomNavigationView


//import android.os.Bundle
//import android.support.design.widget.BottomNavigationView
//import android.support.v7.app.AppCompatActivity
//import android.view.MenuItem
import android.view.View
//import android.widget.Toast

=======
import fr.mericfournier.unesco.profile.UserJSON
import fr.mericfournier.unesco.profile.UserService
>>>>>>> ac583a2c17dd8e98c2d679278862bc103e694f9d

class homeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)



        // **********
        //
        // Navigation Bottom
        //
        // **********

        val bottomNavigation = findViewById<View>(R.id.bottom_navigation) as BottomNavigationView
        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.botom__nav__home -> {
                    val intent = Intent(this, TestLieuActivity::class.java)
                    startActivityForResult(intent, 99)
                }
                R.id.botom__nav__profile -> {
                    val intent = Intent(this, LieuActivity::class.java)
                    startActivityForResult(intent, 99)
                }
                R.id.botom__nav__like -> {
                    val intent = Intent(this, FavorisActivity::class.java)
                    startActivityForResult(intent, 99)
                }
            }
             true
        }

        // **********
        //
        // Navigation Links
        //
        // **********

        // button search
        buttonHomeSearch.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
            startActivityForResult(intent, 99)
        }

        // function de redirection vers la page critere
        fun goToSearch(str: String, data: Int) {
            val name = str
            val id = data
            val i = Intent(this@homeActivity, CritereActivity::class.java)
            i.putExtra("name", name)
            i.putExtra("id", id)
            startActivity(i)
        }

        // button Masterpiece of humanity
        imgbtn1.setOnClickListener {
            val name = getResources().getString(R.string.home__btn1)
            goToSearch(name, 0)
        }

        // button Exchange influence
        imgbtn2.setOnClickListener {
            val name = getResources().getString(R.string.home__btn2)
            goToSearch(name, 1)
        }

        // button Testimonials
        imgbtn3.setOnClickListener {
            val name = getResources().getString(R.string.home__btn3)
            goToSearch(name, 2)
        }

        // button Historical Architectures
        imgbtn5.setOnClickListener {
            val name = getResources().getString(R.string.home__btn4)
            goToSearch(name, 3)
        }

        // button Traditional Establishments
        imgbtn6.setOnClickListener {
            val name = getResources().getString(R.string.home__btn5)
            goToSearch(name, 4)
        }

        // button Living Traditions
        imgbtn7.setOnClickListener {
            val name = getResources().getString(R.string.home__btn6)
            goToSearch(name, 5)
        }

        // button Natural beauties
        imgbtn71.setOnClickListener {
            val name = getResources().getString(R.string.home__btn7)
            goToSearch(name, 6)
        }

        // button History of the earth
        imgbtn8.setOnClickListener {
            val name = getResources().getString(R.string.home__btn8)
            goToSearch(name, 7)
        }

        // button History of the earth 2
        imgbtn9.setOnClickListener {
            val name = getResources().getString(R.string.home__btn9)
            goToSearch(name, 8)
        }

        // button Natural habitats
        imgbtn10.setOnClickListener {
            val name = getResources().getString(R.string.home__btn10)
            goToSearch(name, 9)
        }







    }
}
