package fpml.consolidated.com.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.AbsoluteTolerance;
import fpml.consolidated.com.OilDelivery;
import fpml.consolidated.com.OilPipelineDelivery;
import fpml.consolidated.com.OilTransferDelivery;
import fpml.consolidated.com.PercentageTolerance;
import fpml.consolidated.shared.PartyReference;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class OilDeliveryOnlyExistsValidator implements ValidatorWithArg<OilDelivery, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends OilDelivery> ValidationResult<OilDelivery> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("pipeline", ExistenceChecker.isSet((OilPipelineDelivery) o.getPipeline()))
				.put("transfer", ExistenceChecker.isSet((OilTransferDelivery) o.getTransfer()))
				.put("importerOfRecord", ExistenceChecker.isSet((PartyReference) o.getImporterOfRecord()))
				.put("absoluteTolerance", ExistenceChecker.isSet((AbsoluteTolerance) o.getAbsoluteTolerance()))
				.put("percentageTolerance", ExistenceChecker.isSet((PercentageTolerance) o.getPercentageTolerance()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("OilDelivery", ValidationResult.ValidationType.ONLY_EXISTS, "OilDelivery", path, "");
		}
		return failure("OilDelivery", ValidationResult.ValidationType.ONLY_EXISTS, "OilDelivery", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
