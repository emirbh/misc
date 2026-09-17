package cdm.legaldocumentation.master.isla.validation.exists;

import cdm.legaldocumentation.master.isla.GlobalMasterSecuritiesLendingAgreement;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class GlobalMasterSecuritiesLendingAgreementOnlyExistsValidator implements ValidatorWithArg<GlobalMasterSecuritiesLendingAgreement, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends GlobalMasterSecuritiesLendingAgreement> ValidationResult<GlobalMasterSecuritiesLendingAgreement> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("GlobalMasterSecuritiesLendingAgreement", ValidationResult.ValidationType.ONLY_EXISTS, "GlobalMasterSecuritiesLendingAgreement", path, "");
		}
		return failure("GlobalMasterSecuritiesLendingAgreement", ValidationResult.ValidationType.ONLY_EXISTS, "GlobalMasterSecuritiesLendingAgreement", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
