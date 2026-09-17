package cdm.legaldocumentation.master.isda.validation.exists;

import cdm.base.staticdata.party.LegalEntity;
import cdm.base.staticdata.party.Party;
import cdm.legaldocumentation.common.SpecifiedEntityTermsEnum;
import cdm.legaldocumentation.master.isda.SpecifiedEntity;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class SpecifiedEntityOnlyExistsValidator implements ValidatorWithArg<SpecifiedEntity, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends SpecifiedEntity> ValidationResult<SpecifiedEntity> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("party", ExistenceChecker.isSet((Party) o.getParty()))
				.put("specifiedEntityTerms", ExistenceChecker.isSet((SpecifiedEntityTermsEnum) o.getSpecifiedEntityTerms()))
				.put("specifiedEntity", ExistenceChecker.isSet((List<? extends LegalEntity>) o.getSpecifiedEntity()))
				.put("materialSubsidiaryTerms", ExistenceChecker.isSet((String) o.getMaterialSubsidiaryTerms()))
				.put("otherSpecifiedEntityTerms", ExistenceChecker.isSet((String) o.getOtherSpecifiedEntityTerms()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("SpecifiedEntity", ValidationResult.ValidationType.ONLY_EXISTS, "SpecifiedEntity", path, "");
		}
		return failure("SpecifiedEntity", ValidationResult.ValidationType.ONLY_EXISTS, "SpecifiedEntity", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
