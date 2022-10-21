package uk.org.nbn.specieslist

import au.org.ala.specieslist.SpeciesList
import au.org.ala.specieslist.SpeciesListItem
import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@Unroll
class EditorControllerSpec implements ControllerUnitTest<EditorController> {

    void setupSpec() {
        mockDomains(SpeciesListItem, SpeciesList)
    }

    def setup() {
        SpeciesList sl =new SpeciesList(listName: "list", username: "fred", dataResourceUid: "dr1").save(flush: true, failOnError: true)
        new SpeciesListItem(mylist:sl,itemOrder:1, dataResourceUid:"dr1", rawScientificName:"rawScientificName").save(flush: true, failOnError: true)
    }

    def cleanup() {
    }

    void "if more than one id param, only the first is used"() {
        when:
        params['id']= ['dr1','dr2'] as String[]
        controller.addRecordScreen()

        then:
            params['id']=='dr1'
    }

    void "if just one id param, dont change it, just use that"() {
        when:
        params['id']= 'dr0'
        controller.addRecordScreen()

        then:
        params['id']=='dr0'
    }
}
