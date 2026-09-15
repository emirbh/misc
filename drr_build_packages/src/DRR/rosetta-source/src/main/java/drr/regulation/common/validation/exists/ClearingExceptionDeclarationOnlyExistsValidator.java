package drr.regulation.common.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.ClearingExceptionDeclaration;
import drr.regulation.common.CreditDocumentEnum;
import drr.regulation.common.OrganizationCharacteristicEnum;
import drr.regulation.common.TransactionCharacteristicEnum;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ClearingExceptionDeclarationOnlyExistsValidator implements ValidatorWithArg<ClearingExceptionDeclaration, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ClearingExceptionDeclaration> ValidationResult<ClearingExceptionDeclaration> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("creditDocument", ExistenceChecker.isSet((List<CreditDocumentEnum>) o.getCreditDocument()))
				.put("organizationCharacteristic", ExistenceChecker.isSet((List<OrganizationCharacteristicEnum>) o.getOrganizationCharacteristic()))
				.put("transactionCharacteristic", ExistenceChecker.isSet((List<TransactionCharacteristicEnum>) o.getTransactionCharacteristic()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ClearingExceptionDeclaration", ValidationResult.ValidationType.ONLY_EXISTS, "ClearingExceptionDeclaration", path, "");
		}
		return failure("ClearingExceptionDeclaration", ValidationResult.ValidationType.ONLY_EXISTS, "ClearingExceptionDeclaration", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
