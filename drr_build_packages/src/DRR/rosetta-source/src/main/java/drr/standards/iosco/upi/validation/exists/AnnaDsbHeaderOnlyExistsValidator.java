package drr.standards.iosco.upi.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbAssetClassEnum;
import drr.standards.iosco.upi.AnnaDsbHeader;
import drr.standards.iosco.upi.AnnaDsbInstrumentTypeEnum;
import drr.standards.iosco.upi.AnnaDsbLevelEnum;
import drr.standards.iosco.upi.AnnaDsbUseCaseEnum;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AnnaDsbHeaderOnlyExistsValidator implements ValidatorWithArg<AnnaDsbHeader, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AnnaDsbHeader> ValidationResult<AnnaDsbHeader> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("InstrumentType", ExistenceChecker.isSet((AnnaDsbInstrumentTypeEnum) o.getInstrumentType()))
				.put("UseCase", ExistenceChecker.isSet((AnnaDsbUseCaseEnum) o.getUseCase()))
				.put("Level", ExistenceChecker.isSet((AnnaDsbLevelEnum) o.getLevel()))
				.put("AssetClass", ExistenceChecker.isSet((AnnaDsbAssetClassEnum) o.getAssetClass()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AnnaDsbHeader", ValidationResult.ValidationType.ONLY_EXISTS, "AnnaDsbHeader", path, "");
		}
		return failure("AnnaDsbHeader", ValidationResult.ValidationType.ONLY_EXISTS, "AnnaDsbHeader", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
