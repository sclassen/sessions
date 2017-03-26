package demo

import geb.Page

class PruefbankOverviewPage extends Page {

    static url = "/#/equipmentmanagement/list/Pruefbank"

    static at = {
        title == 'Equipment Management'
        equipmentsGrid.displayed
    }

    static content = {
        equipmentsGrid { $('#equipmentsGrid') }
        createEquipmentButton { $("#createEquipmentButton") }
        equipmentsTableInputFilter { $('#equipmentsTableInputFilter') }
        equipmentTableRows { equipmentsGrid.find('div.ui-grid-viewport').find('div.ui-grid-row') }
    }

    void filterByName(String filterString) {
        equipmentsTableInputFilter.value(filterString)
    }

    EquipmentDetailsViewPage goToEquipmentWithName(String name) {
        filterByName(name)
        equipmentTableRows.first().click()

        return browser.at(EquipmentDetailsViewPage)
    }

    EquipmentCreatePage createNewEquipment() {
        createEquipmentButton.click()

        return browser.at(EquipmentCreatePage)
    }

}
