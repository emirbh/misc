package drr.standards.iosco.upi.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbAGRI;
import drr.standards.iosco.upi.AnnaDsbAdditionalSubProduct;
import drr.standards.iosco.upi.AnnaDsbEmpty;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AnnaDsbAGRIOnlyExistsValidator implements ValidatorWithArg<AnnaDsbAGRI, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AnnaDsbAGRI> ValidationResult<AnnaDsbAGRI> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("SEAF", ExistenceChecker.isSet((AnnaDsbEmpty) o.getSEAF()))
				.put("GRIN", ExistenceChecker.isSet((AnnaDsbAdditionalSubProduct) o.getGRIN()))
				.put("OOLI", ExistenceChecker.isSet((AnnaDsbAdditionalSubProduct) o.getOOLI()))
				.put("POTA", ExistenceChecker.isSet((AnnaDsbEmpty) o.getPOTA()))
				.put("DIRY", ExistenceChecker.isSet((AnnaDsbEmpty) o.getDIRY()))
				.put("FRST", ExistenceChecker.isSet((AnnaDsbEmpty) o.getFRST()))
				.put("SOFT", ExistenceChecker.isSet((AnnaDsbAdditionalSubProduct) o.getSOFT()))
				.put("LSTK", ExistenceChecker.isSet((AnnaDsbEmpty) o.getLSTK()))
				.put("GROS", ExistenceChecker.isSet((AnnaDsbAdditionalSubProduct) o.getGROS()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AnnaDsbAGRI", ValidationResult.ValidationType.ONLY_EXISTS, "AnnaDsbAGRI", path, "");
		}
		return failure("AnnaDsbAGRI", ValidationResult.ValidationType.ONLY_EXISTS, "AnnaDsbAGRI", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
