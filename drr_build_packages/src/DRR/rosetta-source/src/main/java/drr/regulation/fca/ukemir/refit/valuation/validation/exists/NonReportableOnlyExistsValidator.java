package drr.regulation.fca.ukemir.refit.valuation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.enrichment.common.EnrichmentData;
import drr.regulation.fca.ukemir.refit.valuation.NonReportable;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class NonReportableOnlyExistsValidator implements ValidatorWithArg<NonReportable, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends NonReportable> ValidationResult<NonReportable> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("enrichment", ExistenceChecker.isSet((EnrichmentData) o.getEnrichment()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("NonReportable", ValidationResult.ValidationType.ONLY_EXISTS, "NonReportable", path, "");
		}
		return failure("NonReportable", ValidationResult.ValidationType.ONLY_EXISTS, "NonReportable", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
