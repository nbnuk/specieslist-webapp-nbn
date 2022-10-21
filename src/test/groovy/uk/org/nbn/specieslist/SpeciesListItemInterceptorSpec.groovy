package uk.org.nbn.specieslist

import grails.testing.web.interceptor.InterceptorUnitTest
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
class SpeciesListItemInterceptorSpec extends Specification implements InterceptorUnitTest<SpeciesListItemInterceptor>{

    def setup() {
    }

    def cleanup() {

    }

    void "Test speciesListItem interceptor matching"() {

        when:"A request matches the interceptor"
            withRequest(controller:"speciesListItem", action: "downloadList")

        then:"The interceptor does match"
            interceptor.doesMatch()
            interceptor.redirect(controller:"speciesListItem", action:"downloadListFix")
    }

    void "Test speciesListItem interceptor redirects"() {

        when:"A request matches the interceptor"
        withRequest(controller:"speciesListItem", action: "downloadList")

        then:"The interceptor does match"
        interceptor.doesMatch()
        interceptor.redirect(controller:"speciesListItem", action:"downloadListFix")
    }

    void "Test speciesListItem interceptor cleans params"() {

        setup:
        interceptor.params["&amp;id"]="a"
        interceptor.params["&amp;fq"]="b"
        interceptor.params["q"]="c"
        def cleanParams = ["id":"a","fq":"b","q":"c"]

        when:"A request matches the interceptor"
        withRequest(controller:"speciesListItem", action: "downloadList")

        then:"The interceptor does match"
        interceptor.doesMatch()
        interceptor.redirect(controller:"speciesListItem", action:"downloadListFix", params:cleanParams)
    }


}
