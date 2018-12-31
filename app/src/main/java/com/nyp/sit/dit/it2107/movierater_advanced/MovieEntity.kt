package com.nyp.sit.dit.it2107.movierater_advanced

import android.app.Application

class MovieItems(m_title: String, m_overview: String, m_release_date: String, m_ratingNum: Float,
                 reviewText: String, language: String, ageLimit: Boolean, reasonLanguage: Boolean,
                 reasonViolence: Boolean): Application() {
    var m_title: String = m_title
    var m_overview: String = m_overview
    var m_release_date: String = m_release_date
    var m_ratingNum: Float = m_ratingNum
    var reviewText: String = reviewText
    var language: String = language
    var ageLimit: Boolean = ageLimit
    var reasonLanguage: Boolean = reasonLanguage
    var reasonViolence: Boolean = reasonViolence

}