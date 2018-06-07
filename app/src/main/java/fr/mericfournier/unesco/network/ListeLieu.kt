package fr.mericfournier.unesco.network

import com.mikepenz.fastadapter.items.AbstractItem
import fr.mericfournier.unesco.R
import fr.mericfournier.unesco.item.LieuItem
import fr.mericfournier.unesco.model.Lieu
import java.util.Arrays


class ListeLieu {





    companion object {
        fun getLieu(): ArrayList<Lieu> {

            val lieuList = arrayListOf<Lieu>()

            lieuList.add(Lieu("Place 1", 20, 3, 48, "c'est un joli endroit"))
            lieuList.add(Lieu("Lieu 2", 30, 3, 48, "c'est un joli endroit"))
            lieuList.add(Lieu("Lieu 3", 50, 3, 48, "c'est un joli endroit"))
            lieuList.add(Lieu("Lieu 4", 60, 3, 48, "c'est un joli endroit"))



            println(lieuList)




            return lieuList
        }
    }
}
