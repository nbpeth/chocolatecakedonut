package com.chocolatecakedonut.scoreKeeper.service

import com.chocolatecakedonut.scoreKeeper.domain.Score
import com.chocolatecakedonut.scoreKeeper.repo.ScoreRepo
import groovy.json.JsonSlurper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Component

@Component
class ScoreService {
    @Autowired
    ScoreRepo scoreRepo

    private static Sort descendingScore(){
        new Sort(Sort.Direction.DESC, ["score"])
    }

    def getAllScores(){
        scoreRepo.findAll(descendingScore())
    }

    def getScoresBy(String player){
        scoreRepo.findByPlayer(player, descendingScore())
    }

    def saveScore(String scoreData){
        def scoreJson = new JsonSlurper().parseText(scoreData)

        Score score = new Score(
            player: scoreJson.player,
            date: new Date(),
            score: scoreJson.score,
            startLevel: scoreJson.startLevel
        )

        scoreRepo.save(score)
    }

}
