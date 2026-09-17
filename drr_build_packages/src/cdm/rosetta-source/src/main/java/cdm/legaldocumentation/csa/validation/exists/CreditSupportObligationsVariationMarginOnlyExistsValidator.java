package cdm.legaldocumentation.csa.validation.exists;

import cdm.legaldocumentation.csa.CreditSupportObligationsVariationMargin;
import cdm.legaldocumentation.csa.IneligibleCreditSupport;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import com.rosetta.model.metafields.FieldWithMetaString;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CreditSupportObligationsVariationMarginOnlyExistsValidator implements ValidatorWithArg<CreditSupportObligationsVariationMargin, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CreditSupportObligationsVariationMargin> ValidationResult<CreditSupportObligationsVariationMargin> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("ineligibleCreditSupport", ExistenceChecker.isSet((IneligibleCreditSupport) o.getIneligibleCreditSupport()))
				.put("majorCurrency", ExistenceChecker.isSet((List<? extends FieldWithMetaString>) o.getMajorCurrency()))
				.put("fxHaircut", ExistenceChecker.isSet((String) o.getFxHaircut()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CreditSupportObligationsVariationMargin", ValidationResult.ValidationType.ONLY_EXISTS, "CreditSupportObligationsVariationMargin", path, "");
		}
		return failure("CreditSupportObligationsVariationMargin", ValidationResult.ValidationType.ONLY_EXISTS, "CreditSupportObligationsVariationMargin", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
