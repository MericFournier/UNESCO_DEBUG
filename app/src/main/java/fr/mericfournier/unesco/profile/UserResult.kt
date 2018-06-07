package fr.mericfournier.unesco.profile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class UserResult {
    var results = arrayListOf<UserJSON>()
}