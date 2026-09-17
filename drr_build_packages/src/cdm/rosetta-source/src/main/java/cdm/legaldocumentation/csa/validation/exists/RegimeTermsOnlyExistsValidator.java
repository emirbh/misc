package cdm.legaldocumentation.csa.validation.exists;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.csa.ExceptionEnum;
import cdm.legaldocumentation.csa.RegimeTerms;
import cdm.legaldocumentation.csa.RetrospectiveEffect;
import cdm.legaldocumentation.csa.SimmException;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class RegimeTermsOnlyExistsValidator implements ValidatorWithArg<RegimeTerms, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends RegimeTerms> ValidationResult<RegimeTerms> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("party", ExistenceChecker.isSet((CounterpartyRoleEnum) o.getParty()))
				.put("isApplicable", ExistenceChecker.isSet((ExceptionEnum) o.getIsApplicable()))
				.put("asSpecified", ExistenceChecker.isSet((String) o.getAsSpecified()))
				.put("simmException", ExistenceChecker.isSet((SimmException) o.getSimmException()))
				.put("retrospectiveEffect", ExistenceChecker.isSet((RetrospectiveEffect) o.getRetrospectiveEffect()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("RegimeTerms", ValidationResult.ValidationType.ONLY_EXISTS, "RegimeTerms", path, "");
		}
		return failure("RegimeTerms", ValidationResult.ValidationType.ONLY_EXISTS, "RegimeTerms", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
