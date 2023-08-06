package com.martinbove.paging3compose.data.mappers

import com.martinbove.paging3compose.data.local.BeerEntity
import com.martinbove.paging3compose.data.remote.BeerDetailsDto
import com.martinbove.paging3compose.data.remote.BeerDto
import com.martinbove.paging3compose.domain.model.Beer
import com.martinbove.paging3compose.domain.model.BeerDetails

/**
 * Created by Martín Bove on 28/07/2023.
 * E-mail: mbove77@gmail.com
 */

fun BeerDto.toBeerEntity(): BeerEntity {
    return BeerEntity(
        id = id,
        name = name,
        tagline = tagline,
        description = description,
        firstBrewed = first_brewed,
        imageUrl = image_url
    )
}

fun BeerDto.toBeer(): Beer {
    return Beer(
        id = id,
        name = name,
        tagline = tagline,
        description = description,
        firstBrew = first_brewed,
        imageUrl = image_url,
        beerDetails = null
    )
}

fun BeerEntity.toBeer(): Beer {
    return Beer(
        id = id,
        name = name,
        tagline = tagline,
        description = description,
        firstBrew = firstBrewed,
        imageUrl = imageUrl,
        beerDetails = null
    )
}

fun BeerDetailsDto.toBeer(): Beer {
    return Beer(
        id = id,
        name = name,
        tagline = tagline,
        description = description,
        firstBrew = first_brewed,
        imageUrl = image_url,
        beerDetails = BeerDetails(
            foodPairing = food_pairing,
            brewersTips = brewers_tips,
            abv = abv,
            ibu = ibu,
            targetFg = target_fg,
            targetOg = target_og,
            ebc = ebc,
            srm = srm,
            ph = ph,
            attenuationLevel = attenuation_level
        )
    )
}
