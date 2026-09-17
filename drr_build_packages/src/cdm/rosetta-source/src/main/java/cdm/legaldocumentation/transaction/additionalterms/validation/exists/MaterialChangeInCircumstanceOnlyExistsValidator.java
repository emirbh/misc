package cdm.legaldocumentation.transaction.additionalterms.validation.exists;

import cdm.legaldocumentation.transaction.additionalterms.EscrowArrangement;
import cdm.legaldocumentation.transaction.additionalterms.MaterialChangeInCircumstance;
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

public class MaterialChangeInCircumstanceOnlyExistsValidator implements ValidatorWithArg<MaterialChangeInCircumstance, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends MaterialChangeInCircumstance> ValidationResult<MaterialChangeInCircumstance> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("materialChangeInCircumstanceIsApplicable", ExistenceChecker.isSet((Boolean) o.getMaterialChangeInCircumstanceIsApplicable()))
				.put("escrowArrangement", ExistenceChecker.isSet((EscrowArrangement) o.getEscrowArrangement()))
				.put("maximumDaysOfDisruption", ExistenceChecker.isSet((ValuationPostponement) o.getMaximumDaysOfDisruption()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("MaterialChangeInCircumstance", ValidationResult.ValidationType.ONLY_EXISTS, "MaterialChangeInCircumstance", path, "");
		}
		return failure("MaterialChangeInCircumstance", ValidationResult.ValidationType.ONLY_EXISTS, "MaterialChangeInCircumstance", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
