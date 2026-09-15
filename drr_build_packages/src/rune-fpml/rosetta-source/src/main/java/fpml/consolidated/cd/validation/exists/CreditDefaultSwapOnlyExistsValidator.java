package fpml.consolidated.cd.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.cd.CreditDefaultSwap;
import fpml.consolidated.cd.CreditDefaultSwapChoice;
import fpml.consolidated.cd.FeeLeg;
import fpml.consolidated.cd.GeneralTerms;
import fpml.consolidated.cd.ProtectionTerms;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CreditDefaultSwapOnlyExistsValidator implements ValidatorWithArg<CreditDefaultSwap, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CreditDefaultSwap> ValidationResult<CreditDefaultSwap> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("primaryAssetClass", ExistenceChecker.isSet((AssetClass) o.getPrimaryAssetClass()))
				.put("secondaryAssetClass", ExistenceChecker.isSet((List<? extends AssetClass>) o.getSecondaryAssetClass()))
				.put("productType", ExistenceChecker.isSet((List<? extends ProductType>) o.getProductType()))
				.put("productId", ExistenceChecker.isSet((List<? extends ProductId>) o.getProductId()))
				.put("embeddedOptionType", ExistenceChecker.isSet((List<? extends EmbeddedOptionType>) o.getEmbeddedOptionType()))
				.put("assetClass", ExistenceChecker.isSet((List<? extends AssetClass>) o.getAssetClass()))
				.put("generalTerms", ExistenceChecker.isSet((GeneralTerms) o.getGeneralTerms()))
				.put("feeLeg", ExistenceChecker.isSet((FeeLeg) o.getFeeLeg()))
				.put("protectionTerms", ExistenceChecker.isSet((List<? extends ProtectionTerms>) o.getProtectionTerms()))
				.put("creditDefaultSwapChoice", ExistenceChecker.isSet((List<? extends CreditDefaultSwapChoice>) o.getCreditDefaultSwapChoice()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CreditDefaultSwap", ValidationResult.ValidationType.ONLY_EXISTS, "CreditDefaultSwap", path, "");
		}
		return failure("CreditDefaultSwap", ValidationResult.ValidationType.ONLY_EXISTS, "CreditDefaultSwap", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
