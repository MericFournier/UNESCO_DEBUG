package fr.mericfournier.unesco.network

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

/**
 * Created by Yvan Moté on 09/05/2018.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
class LieuResult {
    var results = arrayListOf<LieuJSON>()
}