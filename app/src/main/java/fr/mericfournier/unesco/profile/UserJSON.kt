package fr.mericfournier.unesco.profile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)  // Trick: pas viable en production
class UserJSON {
    var firstname = ""
    var lastname = ""
    var email = ""
    var password = ""
}