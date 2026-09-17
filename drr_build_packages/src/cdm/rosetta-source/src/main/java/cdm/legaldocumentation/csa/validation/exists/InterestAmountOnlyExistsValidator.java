package cdm.legaldocumentation.csa.validation.exists;

import cdm.legaldocumentation.csa.InterestAmount;
import cdm.product.collateral.DeliveryAmount;
import cdm.product.collateral.ReturnAmount;
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

public class InterestAmountOnlyExistsValidator implements ValidatorWithArg<InterestAmount, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends InterestAmount> ValidationResult<InterestAmount> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("returnAmount", ExistenceChecker.isSet((ReturnAmount) o.getReturnAmount()))
				.put("deliveryAmount", ExistenceChecker.isSet((DeliveryAmount) o.getDeliveryAmount()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("InterestAmount", ValidationResult.ValidationType.ONLY_EXISTS, "InterestAmount", path, "");
		}
		return failure("InterestAmount", ValidationResult.ValidationType.ONLY_EXISTS, "InterestAmount", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
