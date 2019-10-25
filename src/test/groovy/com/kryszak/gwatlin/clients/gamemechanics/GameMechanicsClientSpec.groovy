package com.kryszak.gwatlin.clients.gamemechanics

import com.google.gson.reflect.TypeToken
import com.kryszak.gwatlin.api.achievement.model.exception.ApiRequestException
import com.kryszak.gwatlin.api.gamemechanics.model.Mastery
import spock.lang.Subject
import spock.lang.Unroll

class GameMechanicsClientSpec extends GameMechanicsStubs {

    @Subject
    def gameMechanicsClient = new GameMechanicsClient()

    def "Should get masteries ids"() {
        given: "Expected list of masteries ids"
        def ids = parseResponse("/responses/gamemechanics/masteries_ids.json")

        and: "External api is stubbed"
        stubMasteriesIdsResponse()

        when: "Retrieving list of masteries ids"
        def idsList = gameMechanicsClient.getMasteriesIds()

        then: "Retrieved list matches expected"
        idsList == ids
    }

    @Unroll
    def "Should get mastery in #lang"() {
        given: "Mastery id"
        def id = 1

        and: "External api is stubbed"
        stub

        when: "Retrieving mastery"
        def mastery = gameMechanicsClient.getMastery(id, language)

        then: "Retrieved mastery matches expected"
        mastery == parseMastery(file)

        where:
        lang               | language | file              | stub
        "default language" | "en"     | "mastery.json"    | stubMasteryResponse()
        "French"           | "fr"     | "mastery_fr.json" | stubMasteryFrenchResponse()
    }

    def "Should throw exception on non existing mastery"() {
        given: "Id of non existing mastery"
        def id = 40

        and: "External api is stubbed"
        stubMasteryErrorResponse()

        when: "Retrieving mastery"
        gameMechanicsClient.getMastery(id, "en")

        then: "Exception is thrown"
        thrown(ApiRequestException)
    }

    def "Should get list of masteries"() {
        given: "Masteries ids"
        def ids = [1, 2]

        and: "External api is stubbed"
        stubMasteriesResponse()

        when: "Retrieving masteries"
        def masteries = gameMechanicsClient.getMasteries(ids, "en")

        then: "Retrieved masteries match expected"
        masteries == parseMasteries()
    }

    private List<Mastery> parseMasteries() {
        gson.fromJson(parseResponseText("/responses/gamemechanics/masteries.json"),
                new TypeToken<List<Mastery>>() {}.getType())
    }

    private Mastery parseMastery(String file) {
        gson.fromJson(parseResponseText("/responses/gamemechanics/$file"), Mastery)
    }
}
