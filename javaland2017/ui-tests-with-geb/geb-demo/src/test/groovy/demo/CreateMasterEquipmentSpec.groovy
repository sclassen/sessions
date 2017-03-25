package demo

import spock.lang.Shared
import spock.lang.Stepwise

@Stepwise
class CreateMasterEquipmentSpec extends BaseSpec {
    public static final String MINIBANK = "Minibank"
    public static final String EXECUTOR_INPUT = "abc@canoo.com"

    @Shared
    private final String testEquipmentName = unique("equip")

    void setupSpec() {
        login(PruefbankOverviewPage)
    }

    void "click on create new equipment"() {
        given:
          p = at PruefbankOverviewPage

        when:
          p = p.createNewEquipment()

        then:
          at EquipmentDetailsEditPage
    }

    void "fill equipment values and save"() {
        given:
          p = at EquipmentDetailsEditPage

        when:
          p.inputPruefbankName << testEquipmentName
          p.inputPruefbankExecutor << EXECUTOR_INPUT
          p.selectPruefbankType(MINIBANK)

        then:
          true
    }

    void "save new equipment"() {
        given:
          p = at EquipmentDetailsEditPage

        when:
          p = p.saveNewEquipment()

        then:
          at PruefbankOverviewPage
    }

    void "click on newly created equipment"() {
        given:
          p = at PruefbankOverviewPage

        when:
          p = p.goToEquipmentWithName(testEquipmentName)

        then:
          at EquipmentDetailsViewPage
    }


    void "check equipment details"() {
        when:
          p = at EquipmentDetailsViewPage

        then:
          p.pruefbankName == testEquipmentName
          p.pruefbankExecutor == EXECUTOR_INPUT
          p.pruefbankType == MINIBANK
    }

    void cleanupSpec(){
        executeQuery("delete * from Pruefbank where name='" + testEquipmentName + "'")
    }
}
