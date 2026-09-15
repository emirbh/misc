package drr.enrichment.common.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.enrichment.common.EnrichmentData;
import drr.enrichment.lei.LeiData;
import drr.enrichment.upi.UpiData;
import drr.standards.iso.MicData;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class EnrichmentDataOnlyExistsValidator implements ValidatorWithArg<EnrichmentData, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends EnrichmentData> ValidationResult<EnrichmentData> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("micData", ExistenceChecker.isSet((List<? extends MicData>) o.getMicData()))
				.put("leiData", ExistenceChecker.isSet((List<? extends LeiData>) o.getLeiData()))
				.put("upiData", ExistenceChecker.isSet((List<? extends UpiData>) o.getUpiData()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("EnrichmentData", ValidationResult.ValidationType.ONLY_EXISTS, "EnrichmentData", path, "");
		}
		return failure("EnrichmentData", ValidationResult.ValidationType.ONLY_EXISTS, "EnrichmentData", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
