package com.lolduo.riotapiserver.controller

import com.lolduo.riotapiserver.controller.response.ChampionResponse
import com.lolduo.riotapiserver.controller.response.champion.ImageResponse
import com.lolduo.riotapiserver.controller.response.champion.InfoResponse
import com.lolduo.riotapiserver.controller.response.champion.StatsResponse
import com.lolduo.riotapiserver.service.riotApi.response.Champion
import org.springframework.stereotype.Component

@Component
class ConvertResponse {
    fun convertChampion(champion: Champion) : ChampionResponse {
        return ChampionResponse(
            champion.version,
            champion.id,
            champion.key,
            champion.name,
            champion.title,
            champion.blurb,
            InfoResponse(
                champion.info.attack,
                champion.info.defense,
                champion.info.magic,
                champion.info.difficulty
            ),
            ImageResponse(
                champion.image.full,
                champion.image.sprite,
                champion.image.group,
                champion.image.x,
                champion.image.y,
                champion.image.w,
                champion.image.h
            ),
            champion.tags,
            champion.partype,
            StatsResponse(
                champion.stats.hp,
                champion.stats.hpperlevel,
                champion.stats.mp,
                champion.stats.mpperlevel,
                champion.stats.movespeed,
                champion.stats.armor,
                champion.stats.armorperlevel,
                champion.stats.spellblock,
                champion.stats.spellblockperlevel,
                champion.stats.attackrange,
                champion.stats.hpregen,
                champion.stats.hpregenperlevel,
                champion.stats.mpregen,
                champion.stats.mpregenperlevel,
                champion.stats.crit,
                champion.stats.critperlevel,
                champion.stats.attackdamage,
                champion.stats.attackdamageperlevel,
                champion.stats.attackspeedperlevel,
                champion.stats.attackspeed
            )
        )
    }
}