package cdm.legaldocumentation.csa.validation.exists;

import cdm.legaldocumentation.csa.AmendmentEffectiveDate;
import cdm.legaldocumentation.csa.ElectiveAmountElection;
import cdm.legaldocumentation.csa.MinimumTransferAmountAmendment;
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

public class MinimumTransferAmountAmendmentOnlyExistsValidator implements ValidatorWithArg<MinimumTransferAmountAmendment, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends MinimumTransferAmountAmendment> ValidationResult<MinimumTransferAmountAmendment> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("isApplicable", ExistenceChecker.isSet((Boolean) o.getIsApplicable()))
				.put("effectiveDate", ExistenceChecker.isSet((AmendmentEffectiveDate) o.getEffectiveDate()))
				.put("partyElections", ExistenceChecker.isSet((List<? extends ElectiveAmountElection>) o.getPartyElections()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("MinimumTransferAmountAmendment", ValidationResult.ValidationType.ONLY_EXISTS, "MinimumTransferAmountAmendment", path, "");
		}
		return failure("MinimumTransferAmountAmendment", ValidationResult.ValidationType.ONLY_EXISTS, "MinimumTransferAmountAmendment", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
