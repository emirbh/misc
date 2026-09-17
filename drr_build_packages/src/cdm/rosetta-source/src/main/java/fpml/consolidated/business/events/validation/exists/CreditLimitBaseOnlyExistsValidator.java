package fpml.consolidated.business.events.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.CreditLimitBase;
import fpml.consolidated.business.events.LimitId;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.Period;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CreditLimitBaseOnlyExistsValidator implements ValidatorWithArg<CreditLimitBase, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CreditLimitBase> ValidationResult<CreditLimitBase> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("limitId", ExistenceChecker.isSet((LimitId) o.getLimitId()))
				.put("primaryAssetClass", ExistenceChecker.isSet((AssetClass) o.getPrimaryAssetClass()))
				.put("secondaryAssetClass", ExistenceChecker.isSet((List<? extends AssetClass>) o.getSecondaryAssetClass()))
				.put("productType", ExistenceChecker.isSet((List<? extends ProductType>) o.getProductType()))
				.put("productId", ExistenceChecker.isSet((List<? extends ProductId>) o.getProductId()))
				.put("assetClass", ExistenceChecker.isSet((List<? extends AssetClass>) o.getAssetClass()))
				.put("currency", ExistenceChecker.isSet((Currency) o.getCurrency()))
				.put("tenor", ExistenceChecker.isSet((Period) o.getTenor()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CreditLimitBase", ValidationResult.ValidationType.ONLY_EXISTS, "CreditLimitBase", path, "");
		}
		return failure("CreditLimitBase", ValidationResult.ValidationType.ONLY_EXISTS, "CreditLimitBase", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
