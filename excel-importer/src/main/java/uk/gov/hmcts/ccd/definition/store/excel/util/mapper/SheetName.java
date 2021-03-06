package uk.gov.hmcts.ccd.definition.store.excel.util.mapper;

/**
 * Enum to track all valid Sheet names for a Case Definition import
 */
public enum SheetName {
    JURISDICTION("Jurisdiction"),
    CASE_TYPE("CaseType"),
    CASE_FIELD("CaseField"),
    STATE("State"),
    CASE_EVENT("CaseEvent"),
    CASE_EVENT_TO_FIELDS("CaseEventToFields"),
    WORK_BASKET_INPUT_FIELD("WorkBasketInputFields"),
    WORK_BASKET_RESULT_FIELDS("WorkBasketResultFields"),
    CASE_TYPE_TAB("CaseTypeTab"),
    SEARCH_INPUT_FIELD("SearchInputFields"),
    SEARCH_RESULT_FIELD("SearchResultFields"),
    USER_PROFILE("UserProfile"),
    FIXED_LISTS("FixedLists"),
    COMPLEX_TYPES("ComplexTypes"),
    AUTHORISATION_CASE_TYPE("AuthorisationCaseType"),
    AUTHORISATION_CASE_FIELD("AuthorisationCaseField"),
    AUTHORISATION_CASE_EVENT("AuthorisationCaseEvent"),
    AUTHORISATION_CASE_STATE("AuthorisationCaseState");

    private final String name;

    SheetName(String sheetName) {
        this.name = sheetName;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public static SheetName forName(String name) {
        for (SheetName sheetName : SheetName.values()) {
            if (name.equals(sheetName.getName())) {
                return sheetName;
            }
        }

        return null;
    }
}
