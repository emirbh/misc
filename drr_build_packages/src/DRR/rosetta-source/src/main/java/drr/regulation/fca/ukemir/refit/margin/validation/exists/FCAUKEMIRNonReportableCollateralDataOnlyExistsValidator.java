package drr.regulation.fca.ukemir.refit.margin.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.enrichment.common.EnrichmentData;
import drr.regulation.fca.ukemir.refit.margin.FCAUKEMIRNonReportableCollateralData;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FCAUKEMIRNonReportableCollateralDataOnlyExistsValidator implements ValidatorWithArg<FCAUKEMIRNonReportableCollateralData, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FCAUKEMIRNonReportableCollateralData> ValidationResult<FCAUKEMIRNonReportableCollateralData> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("enrichment", ExistenceChecker.isSet((EnrichmentData) o.getEnrichment()))
				.put("mic", ExistenceChecker.isSet((String) o.getMic()))
				.put("relationshipRecord", ExistenceChecker.isSet((String) o.getRelationshipRecord()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FCAUKEMIRNonReportableCollateralData", ValidationResult.ValidationType.ONLY_EXISTS, "FCAUKEMIRNonReportableCollateralData", path, "");
		}
		return failure("FCAUKEMIRNonReportableCollateralData", ValidationResult.ValidationType.ONLY_EXISTS, "FCAUKEMIRNonReportableCollateralData", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
