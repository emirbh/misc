package cdm.legaldocumentation.csa.validation.exists;

import cdm.legaldocumentation.csa.PostedCreditSupportItem;
import cdm.observable.asset.Money;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class PostedCreditSupportItemOnlyExistsValidator implements ValidatorWithArg<PostedCreditSupportItem, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends PostedCreditSupportItem> ValidationResult<PostedCreditSupportItem> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("cashOrSecurityValue", ExistenceChecker.isSet((Money) o.getCashOrSecurityValue()))
				.put("haircutPercentage", ExistenceChecker.isSet((BigDecimal) o.getHaircutPercentage()))
				.put("fxHaircutPercentage", ExistenceChecker.isSet((BigDecimal) o.getFxHaircutPercentage()))
				.put("additionalHaircutPercentage", ExistenceChecker.isSet((BigDecimal) o.getAdditionalHaircutPercentage()))
				.put("disputedCashOrSecurityValue", ExistenceChecker.isSet((Money) o.getDisputedCashOrSecurityValue()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PostedCreditSupportItem", ValidationResult.ValidationType.ONLY_EXISTS, "PostedCreditSupportItem", path, "");
		}
		return failure("PostedCreditSupportItem", ValidationResult.ValidationType.ONLY_EXISTS, "PostedCreditSupportItem", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
