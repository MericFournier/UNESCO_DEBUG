package fr.mericfournier.unesco

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.mikepenz.fastadapter.IAdapter
import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter
import com.mikepenz.fastadapter.listeners.OnClickListener
import fr.mericfournier.unesco.item.LieuItem
import fr.mericfournier.unesco.model.Lieu
import fr.mericfournier.unesco.network.LieuJSON
import fr.mericfournier.unesco.network.LieuService
import kotlinx.android.synthetic.main.activity_test_contact.*
import android.support.v7.widget.RecyclerView
import android.util.Log
import fr.mericfournier.unesco.network.ListeLieu


class TestLieuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_contact)

        val lieuList = ListeLieu.getLieu()


        // configuration de l'affichage à la verticale

        // LinearLayoutManager || GridLayoutManager
        //lieuRecyclerView.layoutManager = LinearLayoutManager(this,
        //LinearLayoutManager.VERTICAL, false);


        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val myList = findViewById(R.id.lieuRecyclerView) as RecyclerView
        myList.layoutManager = layoutManager




        val itemAdapter = FastItemAdapter<LieuItem>()

        // liaison de l'adaptateur à la liste (RecyclerView)
        lieuRecyclerView.adapter = itemAdapter

        for(lieu in lieuList) {
            val lieuItem = LieuItem(lieu)
            itemAdapter.add(lieuItem)
        }

        // Ajout de la gestion du clic sur une cellule :

        itemAdapter.withOnClickListener(object : OnClickListener<LieuItem> {
            override fun onClick(v: View?, adapter: IAdapter<LieuItem>?, item: LieuItem?, position: Int): Boolean {

                val lieu = item?.lieu

                if(lieu is Lieu) {
                    Toast
                            .makeText(this@TestLieuActivity,
                                    "lieu  : ${lieu.Name}",
                                    Toast.LENGTH_SHORT)
                            .show()

                    val intent = Intent(this@TestLieuActivity, LieuActivity::class.java)
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);

                }



                return true
            }



        })





    }
}
