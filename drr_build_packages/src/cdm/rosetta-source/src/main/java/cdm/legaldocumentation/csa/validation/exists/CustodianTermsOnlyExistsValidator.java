package cdm.legaldocumentation.csa.validation.exists;

import cdm.base.staticdata.party.LegalEntity;
import cdm.legaldocumentation.csa.CustodianTerms;
import cdm.observable.asset.CreditNotation;
import cdm.observable.asset.Money;
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

public class CustodianTermsOnlyExistsValidator implements ValidatorWithArg<CustodianTerms, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CustodianTerms> ValidationResult<CustodianTerms> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("minimumAssets", ExistenceChecker.isSet((Money) o.getMinimumAssets()))
				.put("minimumRating", ExistenceChecker.isSet((CreditNotation) o.getMinimumRating()))
				.put("initialDesignation", ExistenceChecker.isSet((LegalEntity) o.getInitialDesignation()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CustodianTerms", ValidationResult.ValidationType.ONLY_EXISTS, "CustodianTerms", path, "");
		}
		return failure("CustodianTerms", ValidationResult.ValidationType.ONLY_EXISTS, "CustodianTerms", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
