package fpml.consolidated.sec.lending.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.repo.DeliveryMethod;
import fpml.consolidated.sec.lending.PrepaidRate;
import fpml.consolidated.sec.lending.SecLendInitiation;
import fpml.consolidated.shared.IdentifiedDate;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class SecLendInitiationOnlyExistsValidator implements ValidatorWithArg<SecLendInitiation, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends SecLendInitiation> ValidationResult<SecLendInitiation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("settlementDate", ExistenceChecker.isSet((IdentifiedDate) o.getSettlementDate()))
				.put("deliveryMethod", ExistenceChecker.isSet((DeliveryMethod) o.getDeliveryMethod()))
				.put("collateralSettlementDate", ExistenceChecker.isSet((IdentifiedDate) o.getCollateralSettlementDate()))
				.put("prepaidRate", ExistenceChecker.isSet((PrepaidRate) o.getPrepaidRate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("SecLendInitiation", ValidationResult.ValidationType.ONLY_EXISTS, "SecLendInitiation", path, "");
		}
		return failure("SecLendInitiation", ValidationResult.ValidationType.ONLY_EXISTS, "SecLendInitiation", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
