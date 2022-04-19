package uk.org.nbn.specieslist

import au.org.ala.names.model.LinnaeanRankClassification
import au.org.ala.names.model.NameSearchResult
import au.org.ala.names.search.ALANameSearcher
import au.org.ala.specieslist.SpeciesListItem
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(HelperService)
class HelperServiceSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }


    void "test nomenclaturalStatus added to author"() {
        setup:
        def rankClassification = Mock(LinnaeanRankClassification)
        def nsr = Mock(NameSearchResult)
        service.cbIdxSearcher = Mock(ALANameSearcher)

        service.cbIdxSearcher.searchForAcceptedRecordDefaultHandling(*_) >> nsr
        rankClassification.getAuthorship() >> "authorship"
        rankClassification.getNomenclaturalStatus() >> "nomenclaturalStatus"
        nsr.getRankClassification() >> rankClassification

        def sli = new SpeciesListItem()
        sli.rawScientificName = "rawScientificName"

        when:
        service.matchNameToSpeciesListItem("name", sli)

        then:
        sli.author == "authorship nomenclaturalStatus"
    }
}
