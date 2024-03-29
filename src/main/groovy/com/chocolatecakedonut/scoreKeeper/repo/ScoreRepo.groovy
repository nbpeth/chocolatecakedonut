package com.chocolatecakedonut.scoreKeeper.repo

import com.chocolatecakedonut.scoreKeeper.domain.Score
import org.springframework.data.domain.Sort
import org.springframework.data.repository.CrudRepository

interface ScoreRepo extends CrudRepository<Score, Long> {
    List<Score> findByPlayer(String player, Sort sort)

    List<Score> findAll(Sort sort)

}
