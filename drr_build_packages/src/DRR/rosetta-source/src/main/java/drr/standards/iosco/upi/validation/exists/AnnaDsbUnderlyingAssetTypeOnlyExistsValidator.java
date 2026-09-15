package drr.standards.iosco.upi.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbCDSIndex;
import drr.standards.iosco.upi.AnnaDsbCDSSingleName;
import drr.standards.iosco.upi.AnnaDsbIndexTranche;
import drr.standards.iosco.upi.AnnaDsbOther;
import drr.standards.iosco.upi.AnnaDsbSingleName;
import drr.standards.iosco.upi.AnnaDsbSingleStock;
import drr.standards.iosco.upi.AnnaDsbUnderlyingAssetType;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AnnaDsbUnderlyingAssetTypeOnlyExistsValidator implements ValidatorWithArg<AnnaDsbUnderlyingAssetType, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AnnaDsbUnderlyingAssetType> ValidationResult<AnnaDsbUnderlyingAssetType> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("CDSIndex", ExistenceChecker.isSet((AnnaDsbCDSIndex) o.getCDSIndex()))
				.put("SingleName", ExistenceChecker.isSet((AnnaDsbSingleName) o.getSingleName()))
				.put("CDSSingleName", ExistenceChecker.isSet((AnnaDsbCDSSingleName) o.getCDSSingleName()))
				.put("Options", ExistenceChecker.isSet((AnnaDsbSingleStock) o.getOptions()))
				.put("Futures", ExistenceChecker.isSet((AnnaDsbSingleStock) o.getFutures()))
				.put("SingleStock", ExistenceChecker.isSet((AnnaDsbSingleStock) o.getSingleStock()))
				.put("Forwards", ExistenceChecker.isSet((AnnaDsbSingleStock) o.getForwards()))
				.put("Swaps", ExistenceChecker.isSet((AnnaDsbCDSSingleName) o.getSwaps()))
				.put("Index", ExistenceChecker.isSet((AnnaDsbCDSIndex) o.getIndex()))
				.put("IndexTranche", ExistenceChecker.isSet((AnnaDsbIndexTranche) o.getIndexTranche()))
				.put("CDSIndexTranche", ExistenceChecker.isSet((AnnaDsbCDSIndex) o.getCDSIndexTranche()))
				.put("Other", ExistenceChecker.isSet((AnnaDsbOther) o.getOther()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AnnaDsbUnderlyingAssetType", ValidationResult.ValidationType.ONLY_EXISTS, "AnnaDsbUnderlyingAssetType", path, "");
		}
		return failure("AnnaDsbUnderlyingAssetType", ValidationResult.ValidationType.ONLY_EXISTS, "AnnaDsbUnderlyingAssetType", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
