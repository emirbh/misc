package fpml.consolidated.repo.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.AssetReference;
import fpml.consolidated.repo.CollateralValuation;
import fpml.consolidated.repo.RelativePrice;
import fpml.consolidated.shared.Money;
import fpml.consolidated.shared.NonNegativeMoney;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CollateralValuationOnlyExistsValidator implements ValidatorWithArg<CollateralValuation, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CollateralValuation> ValidationResult<CollateralValuation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("nominalAmount", ExistenceChecker.isSet((Money) o.getNominalAmount()))
				.put("quantity", ExistenceChecker.isSet((BigDecimal) o.getQuantity()))
				.put("cleanPrice", ExistenceChecker.isSet((BigDecimal) o.getCleanPrice()))
				.put("accruals", ExistenceChecker.isSet((BigDecimal) o.getAccruals()))
				.put("dirtyPrice", ExistenceChecker.isSet((BigDecimal) o.getDirtyPrice()))
				.put("relativePrice", ExistenceChecker.isSet((RelativePrice) o.getRelativePrice()))
				.put("yieldToMaturity", ExistenceChecker.isSet((BigDecimal) o.getYieldToMaturity()))
				.put("inflationFactor", ExistenceChecker.isSet((BigDecimal) o.getInflationFactor()))
				.put("allInPrice", ExistenceChecker.isSet((BigDecimal) o.getAllInPrice()))
				.put("accrualsAmount", ExistenceChecker.isSet((Money) o.getAccrualsAmount()))
				.put("numberOfUnits", ExistenceChecker.isSet((BigDecimal) o.getNumberOfUnits()))
				.put("unitPrice", ExistenceChecker.isSet((NonNegativeMoney) o.getUnitPrice()))
				.put("assetReference", ExistenceChecker.isSet((AssetReference) o.getAssetReference()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CollateralValuation", ValidationResult.ValidationType.ONLY_EXISTS, "CollateralValuation", path, "");
		}
		return failure("CollateralValuation", ValidationResult.ValidationType.ONLY_EXISTS, "CollateralValuation", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
