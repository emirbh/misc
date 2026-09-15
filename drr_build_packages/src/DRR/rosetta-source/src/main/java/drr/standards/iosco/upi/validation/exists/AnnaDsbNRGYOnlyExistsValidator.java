package drr.standards.iosco.upi.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbAdditionalSubProduct;
import drr.standards.iosco.upi.AnnaDsbEmpty;
import drr.standards.iosco.upi.AnnaDsbNRGY;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AnnaDsbNRGYOnlyExistsValidator implements ValidatorWithArg<AnnaDsbNRGY, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AnnaDsbNRGY> ValidationResult<AnnaDsbNRGY> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("RNNG", ExistenceChecker.isSet((AnnaDsbEmpty) o.getRNNG()))
				.put("LGHT", ExistenceChecker.isSet((AnnaDsbEmpty) o.getLGHT()))
				.put("ELEC", ExistenceChecker.isSet((AnnaDsbAdditionalSubProduct) o.getELEC()))
				.put("DIST", ExistenceChecker.isSet((AnnaDsbEmpty) o.getDIST()))
				.put("COAL", ExistenceChecker.isSet((AnnaDsbEmpty) o.getCOAL()))
				.put("INRG", ExistenceChecker.isSet((AnnaDsbEmpty) o.getINRG()))
				.put("OILP", ExistenceChecker.isSet((AnnaDsbAdditionalSubProduct) o.getOILP()))
				.put("NGAS", ExistenceChecker.isSet((AnnaDsbAdditionalSubProduct) o.getNGAS()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AnnaDsbNRGY", ValidationResult.ValidationType.ONLY_EXISTS, "AnnaDsbNRGY", path, "");
		}
		return failure("AnnaDsbNRGY", ValidationResult.ValidationType.ONLY_EXISTS, "AnnaDsbNRGY", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
