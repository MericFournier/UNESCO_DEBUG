package fr.mericfournier.unesco.network

import com.fasterxml.jackson.annotation.JsonIgnoreProperties


@JsonIgnoreProperties(ignoreUnknown = true)  // Trick: pas viable en production
class LieuJSON {
    lateinit var Id: java.lang.Integer
    lateinit var Name: String
    lateinit var Description: String
    lateinit var Longitude: java.lang.Double
    lateinit var Latitude: java.lang.Double

}

