package fr.mericfournier.unesco.network

import com.fasterxml.jackson.annotation.JsonIgnoreProperties


@JsonIgnoreProperties(ignoreUnknown = true)  // Trick: pas viable en production
class LieuJSON {
    var id = Int
    var name = String
    var description = String
    var longitude = Double
    var latitude = Double

}

