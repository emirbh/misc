package cdm.legaldocumentation.csa.validation.exists;

import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.legaldocumentation.csa.IneligibleCreditSupport;
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

public class IneligibleCreditSupportOnlyExistsValidator implements ValidatorWithArg<IneligibleCreditSupport, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends IneligibleCreditSupport> ValidationResult<IneligibleCreditSupport> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("totalIneligibilityDate", ExistenceChecker.isSet((String) o.getTotalIneligibilityDate()))
				.put("transferIneligibilityDate", ExistenceChecker.isSet((String) o.getTransferIneligibilityDate()))
				.put("specifiedParty", ExistenceChecker.isSet((List<? extends ReferenceWithMetaParty>) o.getSpecifiedParty()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("IneligibleCreditSupport", ValidationResult.ValidationType.ONLY_EXISTS, "IneligibleCreditSupport", path, "");
		}
		return failure("IneligibleCreditSupport", ValidationResult.ValidationType.ONLY_EXISTS, "IneligibleCreditSupport", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
