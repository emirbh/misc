package fpml.consolidated.volatility.swaps.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.CountryCode;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import fpml.consolidated.volatility.swaps.VolatilityLeg;
import fpml.consolidated.volatility.swaps.VolatilitySwapTransactionSupplement;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class VolatilitySwapTransactionSupplementOnlyExistsValidator implements ValidatorWithArg<VolatilitySwapTransactionSupplement, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends VolatilitySwapTransactionSupplement> ValidationResult<VolatilitySwapTransactionSupplement> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("primaryAssetClass", ExistenceChecker.isSet((AssetClass) o.getPrimaryAssetClass()))
				.put("secondaryAssetClass", ExistenceChecker.isSet((List<? extends AssetClass>) o.getSecondaryAssetClass()))
				.put("productType", ExistenceChecker.isSet((List<? extends ProductType>) o.getProductType()))
				.put("productId", ExistenceChecker.isSet((List<? extends ProductId>) o.getProductId()))
				.put("embeddedOptionType", ExistenceChecker.isSet((List<? extends EmbeddedOptionType>) o.getEmbeddedOptionType()))
				.put("assetClass", ExistenceChecker.isSet((List<? extends AssetClass>) o.getAssetClass()))
				.put("volatilityLeg", ExistenceChecker.isSet((List<? extends VolatilityLeg>) o.getVolatilityLeg()))
				.put("multipleExchangeIndexAnnexFallback", ExistenceChecker.isSet((Boolean) o.getMultipleExchangeIndexAnnexFallback()))
				.put("componentSecurityIndexAnnexFallback", ExistenceChecker.isSet((Boolean) o.getComponentSecurityIndexAnnexFallback()))
				.put("localJurisdiction", ExistenceChecker.isSet((CountryCode) o.getLocalJurisdiction()))
				.put("relevantJurisdiction", ExistenceChecker.isSet((CountryCode) o.getRelevantJurisdiction()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("VolatilitySwapTransactionSupplement", ValidationResult.ValidationType.ONLY_EXISTS, "VolatilitySwapTransactionSupplement", path, "");
		}
		return failure("VolatilitySwapTransactionSupplement", ValidationResult.ValidationType.ONLY_EXISTS, "VolatilitySwapTransactionSupplement", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
