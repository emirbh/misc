package cdm.legaldocumentation.transaction.additionalterms.validation.exists;

import cdm.legaldocumentation.transaction.additionalterms.EscrowArrangement;
import cdm.legaldocumentation.transaction.additionalterms.FxSubstitutionProvisionTypeEnum;
import cdm.legaldocumentation.transaction.additionalterms.NonDeliverableSubstitute;
import cdm.legaldocumentation.transaction.additionalterms.SpecificNonTransferability;
import cdm.observable.asset.ValuationPostponement;
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

public class SpecificNonTransferabilityOnlyExistsValidator implements ValidatorWithArg<SpecificNonTransferability, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends SpecificNonTransferability> ValidationResult<SpecificNonTransferability> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("specificNonTransferabilityIsApplicable", ExistenceChecker.isSet((Boolean) o.getSpecificNonTransferabilityIsApplicable()))
				.put("relevantClass", ExistenceChecker.isSet((List<String>) o.getRelevantClass()))
				.put("localSubstituteProvisionType", ExistenceChecker.isSet((FxSubstitutionProvisionTypeEnum) o.getLocalSubstituteProvisionType()))
				.put("maximumDaysOfDisruption", ExistenceChecker.isSet((ValuationPostponement) o.getMaximumDaysOfDisruption()))
				.put("nonDeliverableSubstitute", ExistenceChecker.isSet((NonDeliverableSubstitute) o.getNonDeliverableSubstitute()))
				.put("escrowArrangement", ExistenceChecker.isSet((EscrowArrangement) o.getEscrowArrangement()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("SpecificNonTransferability", ValidationResult.ValidationType.ONLY_EXISTS, "SpecificNonTransferability", path, "");
		}
		return failure("SpecificNonTransferability", ValidationResult.ValidationType.ONLY_EXISTS, "SpecificNonTransferability", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
