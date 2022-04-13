package uk.org.nbn.specieslist

class EditorController extends au.org.ala.specieslist.EditorController{

    /**
     * Provides (ajax) content for adding a (single species) record model popup
     */
    @Override
    def addRecordScreen() {
        if (params.id.getClass().isArray()) {
            params.id = params.id.first() //TODO: sometimes this is an array with the data resource uid repeated twice. Fix this properly

        }
        super.addRecordScreen()
    }
}
