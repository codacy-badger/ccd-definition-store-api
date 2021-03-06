package uk.gov.hmcts.ccd.definition.store.repository;

import java.util.List;

import uk.gov.hmcts.ccd.definition.store.repository.entity.SearchInputCaseFieldEntity;

public interface SearchInputCaseFieldRepository extends DefinitionRepository<SearchInputCaseFieldEntity, Integer> {

    List<SearchInputCaseFieldEntity> findByCaseTypeId(Integer caseTypeId);

}
