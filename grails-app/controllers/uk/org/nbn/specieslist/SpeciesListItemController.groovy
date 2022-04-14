package uk.org.nbn.specieslist

class SpeciesListItemController extends au.org.ala.specieslist.SpeciesListItemController{

    //this method was created for the fix implemented in SpeciesListItemInterceptor
    def downloadListFix() {
       super.downloadList()
    }
}
