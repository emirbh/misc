package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LenderClassification;
import fpml.consolidated.loan.TransferFeeDefinition;
import fpml.consolidated.loan.TransferFeeDefinitionChoice;
import fpml.consolidated.shared.NonNegativeMoney;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TransferFeeDefinitionOnlyExistsValidator implements ValidatorWithArg<TransferFeeDefinition, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TransferFeeDefinition> ValidationResult<TransferFeeDefinition> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("amount", ExistenceChecker.isSet((NonNegativeMoney) o.getAmount()))
				.put("transferFeeDefinitionChoice", ExistenceChecker.isSet((List<? extends TransferFeeDefinitionChoice>) o.getTransferFeeDefinitionChoice()))
				.put("lenderTypeWaived", ExistenceChecker.isSet((List<? extends LenderClassification>) o.getLenderTypeWaived()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TransferFeeDefinition", ValidationResult.ValidationType.ONLY_EXISTS, "TransferFeeDefinition", path, "");
		}
		return failure("TransferFeeDefinition", ValidationResult.ValidationType.ONLY_EXISTS, "TransferFeeDefinition", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
