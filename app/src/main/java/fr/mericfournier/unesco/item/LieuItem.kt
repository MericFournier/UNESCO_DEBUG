package fr.mericfournier.unesco.item

import android.view.View
import android.widget.TextView
import fr.mericfournier.unesco.model.Lieu
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem
import kotlinx.android.synthetic.main.row_lieu.view.*
import fr.mericfournier.unesco.R


class LieuItem(var lieu: Lieu): AbstractItem<LieuItem, LieuItem.LieuViewHolder>() {
    override fun getType(): Int {
        // on retourne un identifiant unique pour un type de cellule
        return R.id.lieuNameTextView
    }

    // Méthode appelée pour créer une cellule (ex : appelée 11 fois seulement)
    override fun getViewHolder(v: View?): LieuViewHolder {
        return LieuViewHolder(v)
    }

    // On retourne la référance du layout de la cellule à charger
    // Ensuite la méthode getViewHolder sera appelée
    override fun getLayoutRes(): Int {
        return R.layout.row_lieu
    }

    // classe "recyclée" correspondant à la cellule graphique (View -> row_contact)
    class LieuViewHolder: FastAdapter.ViewHolder<LieuItem> {

        private var nameTextView: TextView?
        private var idTextView: TextView?
        private var descriptionTextView: TextView?
        private var longitudeTextView: TextView?
        private var latitudeTextView: TextView?


        constructor(view: View?) : super(view) {
            //récupération des textviews et compagnie
            nameTextView = view?.findViewById<TextView>(R.id.lieuNameTextView)

            // view?.findViewById, si view est null => findViewById retournera null

            idTextView = view?.findViewById<TextView>(R.id.lieuIdTextView)

            descriptionTextView = view?.findViewById<TextView>(R.id.lieuDescriptionTextView)

            latitudeTextView = view?.findViewById<TextView>(R.id.lieuLatitudeTextView)

            longitudeTextView = view?.findViewById<TextView>(R.id.lieuLongitudeTextView)

        }

        // quand la cellule devra être recyclée
        override fun unbindView(item: LieuItem?) {
            //Nettoyage de la cellule avant ré-utilisation
            nameTextView?.text = null
            idTextView?.text = null
            descriptionTextView?.text = null
            latitudeTextView?.text = null
            longitudeTextView?.text = null
        }

        // quand la cellule devra être affichée
        override fun bindView(item: LieuItem?, payloads: MutableList<Any>?) {
            // refresh UI

            val lieu = item?.lieu // -> Contact? => un objet Contact potentiellement nul

            nameTextView?.text = lieu?.name
            idTextView?.text = lieu?.id.toString()
            descriptionTextView?.text = lieu?.description
            latitudeTextView?.text = lieu?.latitude.toString()
            longitudeTextView?.text = lieu?.longitude.toString()
        }


    }

}