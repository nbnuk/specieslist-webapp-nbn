package uk.org.nbn.specieslist


class SpeciesListItemInterceptor {

    SpeciesListItemInterceptor() {
        match(controller: 'speciesListItem', action: "downloadList")
    }

    boolean before() {
        //This is a bug fix that was extracted from the customised platform. It was not a very good fix but it will have to remain for now
        def removeEncodedAmpersandTransformation = { String key ->  key.startsWith('amp;')?  key.substring(4): key }
        Map cleanParams = params.collectEntries { [(removeEncodedAmpersandTransformation.call(it.key)): it.value] }

        redirect(controller:"speciesListItem", action:"downloadListFix", params:cleanParams)
    }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
