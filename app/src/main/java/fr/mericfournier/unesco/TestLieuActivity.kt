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




class TestLieuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_contact)

        val lieuList = arrayListOf<Lieu>()

        //lieuList.add(Lieu("Lieu 1", 20, 3.4536, 48.7463, "c'est un joli endroit"))
        //lieuList.add(Lieu("Lieu 2",30, 5.4029, 49.7463, "c'est cool ici"))
        //lieuList.add(Lieu("Lieu 3",40, 1.0938, 47.7463, "c'est styley"))

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


        // Appel au WS
        LieuService.getLieu(object: LieuService.LieuServiceListener{
            override fun onReceiveResult(lieus: List<LieuJSON>) {
                Log.d("okay","on a reussi")
                itemAdapter.clear() // nettoyage de la liste avant de la remplir

                // Remplissage de l'adapter à partir des objets ContactJSON, retransformé en Contact -> ContactItem
                for(lieuJSON in lieus) {


                    itemAdapter.add(LieuItem(Lieu(lieuJSON.Name.toString(),lieuJSON.Id, lieuJSON.Longitude, lieuJSON.Latitude, lieuJSON.Description.toString())))
                }
            }

            override fun onFailed() {
                Log.d("okay","c la merde")
            }

        })


    }
}
