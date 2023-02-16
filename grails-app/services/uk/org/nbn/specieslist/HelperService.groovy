package uk.org.nbn.specieslist

import au.org.ala.names.ws.api.NameUsageMatch
import au.org.ala.specieslist.SpeciesListItem
//import grails.transaction.NotTransactional
//import grails.transaction.Transactional

//@Transactional
class HelperService extends au.org.ala.specieslist.HelperService{


    def matchNameToSpeciesListItem(String name, SpeciesListItem sli){
        super.matchNameToSpeciesListItem(name,sli)

        NameUsageMatch nsr = findAcceptedConceptByScientificName(sli.rawScientificName) ?:
                findAcceptedConceptByCommonName(sli.rawScientificName) ?:
                        findAcceptedConceptByLSID(sli.rawScientificName) ?:
                                findAcceptedConceptByNameFamily(sli.matchedName, sli.family)
        if(nsr){
            if (nsr.getNomenclaturalStatus()) {
                sli.author += " " + nsr.getNomenclaturalStatus()
            }
        }
    }

//    @Override
//    @NotTransactional
//    //overriding transactional methods produces stackoverflow ( fixed in > Gorm 6.1.4)
//    def matchNameToSpeciesListItem(String name, SpeciesListItem sli){
//        matchNameToSpeciesListItemTransactional(name, sli) //This transactional wrapper fixes the stackoverflow
//    }
//
//    private void matchNameToSpeciesListItemTransactional(String name, SpeciesListItem sli){
//        super.matchNameToSpeciesListItem(name,sli)
//
//        NameUsageMatch nsr = findAcceptedConceptByScientificName(sli.rawScientificName) ?:
//                findAcceptedConceptByCommonName(sli.rawScientificName) ?:
//                        findAcceptedConceptByLSID(sli.rawScientificName) ?:
//                                findAcceptedConceptByNameFamily(sli.matchedName, sli.family)
//        if(nsr){
//            if (nsr.getRankClassification().getNomenclaturalStatus()) {
//                sli.author += " " + nsr.getRankClassification().getNomenclaturalStatus()
//            }
//        }
//    }

}
