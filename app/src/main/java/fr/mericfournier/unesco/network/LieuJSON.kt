package fr.mericfournier.unesco.network

import com.fasterxml.jackson.annotation.JsonIgnoreProperties


@JsonIgnoreProperties(ignoreUnknown = true)  // Trick: pas viable en production
class LieuJSON {
    var Id: Int = 0
    var Name: String = ""
    var Description: String = ""
    var Longitude: Int = 0
    var Latitude: Int = 0

}

