package com.chocolatecakedonut.scoreKeeper.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Score {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    Integer score
    String player
    Date date
    Integer startLevel
}
