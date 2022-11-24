package uk.org.nbn.specieslist

import au.org.ala.names.ws.api.NameUsageMatch
import au.org.ala.specieslist.SpeciesListItem
import grails.testing.services.ServiceUnitTest
import spock.lang.Ignore
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
class HelperServiceSpec extends Specification implements ServiceUnitTest<HelperService> {


    @Ignore
//Needs re-writing for upgrade
    void "test nomenclaturalStatus added to author"() {
        setup:
//        def rankClassification = Mock(LinnaeanRankClassification)
        def nsr = Mock(NameUsageMatch)
        nsr.authorship >> "authorship"
        nsr.nomenclaturalStatus >> "nomenclaturalStatus"

        service.findAcceptedConceptByScientificName(*_) >> nsr

//        rankClassification.getAuthorship() >> "authorship"
//        rankClassification.getNomenclaturalStatus() >> "nomenclaturalStatus"
//        nsr.getRankClassification() >> rankClassification

        def sli = new SpeciesListItem()
        sli.rawScientificName = "rawScientificName"

        when:
        service.matchNameToSpeciesListItem("name", sli)

        then:
        sli.author == "authorship nomenclaturalStatus"
    }
}
