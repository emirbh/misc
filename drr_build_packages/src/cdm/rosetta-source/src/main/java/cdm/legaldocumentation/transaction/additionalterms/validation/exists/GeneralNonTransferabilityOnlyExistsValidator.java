package cdm.legaldocumentation.transaction.additionalterms.validation.exists;

import cdm.legaldocumentation.transaction.additionalterms.EscrowArrangement;
import cdm.legaldocumentation.transaction.additionalterms.FxSubstitutionProvisionTypeEnum;
import cdm.legaldocumentation.transaction.additionalterms.GeneralNonTransferability;
import cdm.legaldocumentation.transaction.additionalterms.NonDeliverableSubstitute;
import cdm.observable.asset.ValuationPostponement;
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

public class GeneralNonTransferabilityOnlyExistsValidator implements ValidatorWithArg<GeneralNonTransferability, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends GeneralNonTransferability> ValidationResult<GeneralNonTransferability> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("generalNonTransferabilityIsApplicable", ExistenceChecker.isSet((Boolean) o.getGeneralNonTransferabilityIsApplicable()))
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
			return success("GeneralNonTransferability", ValidationResult.ValidationType.ONLY_EXISTS, "GeneralNonTransferability", path, "");
		}
		return failure("GeneralNonTransferability", ValidationResult.ValidationType.ONLY_EXISTS, "GeneralNonTransferability", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
