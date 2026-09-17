package fpml.consolidated.ird.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.CapFloor;
import fpml.consolidated.ird.EarlyTerminationProvision;
import fpml.consolidated.ird.InterestRateStream;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.Payment;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CapFloorOnlyExistsValidator implements ValidatorWithArg<CapFloor, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CapFloor> ValidationResult<CapFloor> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("primaryAssetClass", ExistenceChecker.isSet((AssetClass) o.getPrimaryAssetClass()))
				.put("secondaryAssetClass", ExistenceChecker.isSet((List<? extends AssetClass>) o.getSecondaryAssetClass()))
				.put("productType", ExistenceChecker.isSet((List<? extends ProductType>) o.getProductType()))
				.put("productId", ExistenceChecker.isSet((List<? extends ProductId>) o.getProductId()))
				.put("embeddedOptionType", ExistenceChecker.isSet((List<? extends EmbeddedOptionType>) o.getEmbeddedOptionType()))
				.put("assetClass", ExistenceChecker.isSet((List<? extends AssetClass>) o.getAssetClass()))
				.put("capFloorStream", ExistenceChecker.isSet((InterestRateStream) o.getCapFloorStream()))
				.put("premium", ExistenceChecker.isSet((List<? extends Payment>) o.getPremium()))
				.put("additionalPayment", ExistenceChecker.isSet((List<? extends Payment>) o.getAdditionalPayment()))
				.put("earlyTerminationProvision", ExistenceChecker.isSet((EarlyTerminationProvision) o.getEarlyTerminationProvision()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CapFloor", ValidationResult.ValidationType.ONLY_EXISTS, "CapFloor", path, "");
		}
		return failure("CapFloor", ValidationResult.ValidationType.ONLY_EXISTS, "CapFloor", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
