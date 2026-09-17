package fpml.consolidated.dividend.swaps.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.dividend.swaps.DividendSwapOptionTransactionSupplement;
import fpml.consolidated.dividend.swaps.DividendSwapTransactionSupplement;
import fpml.consolidated.eq.shared.EquityPremium;
import fpml.consolidated.eqd.EquityExerciseValuationSettlement;
import fpml.consolidated.fpmlenum.MethodOfAdjustmentEnum;
import fpml.consolidated.fpmlenum.OptionTypeEnum;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import fpml.consolidated.shared.SwaptionPhysicalSettlement;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class DividendSwapOptionTransactionSupplementOnlyExistsValidator implements ValidatorWithArg<DividendSwapOptionTransactionSupplement, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends DividendSwapOptionTransactionSupplement> ValidationResult<DividendSwapOptionTransactionSupplement> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("primaryAssetClass", ExistenceChecker.isSet((AssetClass) o.getPrimaryAssetClass()))
				.put("secondaryAssetClass", ExistenceChecker.isSet((List<? extends AssetClass>) o.getSecondaryAssetClass()))
				.put("productType", ExistenceChecker.isSet((List<? extends ProductType>) o.getProductType()))
				.put("productId", ExistenceChecker.isSet((List<? extends ProductId>) o.getProductId()))
				.put("embeddedOptionType", ExistenceChecker.isSet((List<? extends EmbeddedOptionType>) o.getEmbeddedOptionType()))
				.put("assetClass", ExistenceChecker.isSet((List<? extends AssetClass>) o.getAssetClass()))
				.put("buyerPartyReference", ExistenceChecker.isSet((PartyReference) o.getBuyerPartyReference()))
				.put("buyerAccountReference", ExistenceChecker.isSet((AccountReference) o.getBuyerAccountReference()))
				.put("sellerPartyReference", ExistenceChecker.isSet((PartyReference) o.getSellerPartyReference()))
				.put("sellerAccountReference", ExistenceChecker.isSet((AccountReference) o.getSellerAccountReference()))
				.put("optionType", ExistenceChecker.isSet((OptionTypeEnum) o.getOptionType()))
				.put("equityPremium", ExistenceChecker.isSet((EquityPremium) o.getEquityPremium()))
				.put("equityExercise", ExistenceChecker.isSet((EquityExerciseValuationSettlement) o.getEquityExercise()))
				.put("exchangeLookAlike", ExistenceChecker.isSet((Boolean) o.getExchangeLookAlike()))
				.put("methodOfAdjustment", ExistenceChecker.isSet((MethodOfAdjustmentEnum) o.getMethodOfAdjustment()))
				.put("optionEntitlement", ExistenceChecker.isSet((BigDecimal) o.getOptionEntitlement()))
				.put("multiplier", ExistenceChecker.isSet((BigDecimal) o.getMultiplier()))
				.put("clearingInstructions", ExistenceChecker.isSet((SwaptionPhysicalSettlement) o.getClearingInstructions()))
				.put("dividendSwapTransactionSupplement", ExistenceChecker.isSet((DividendSwapTransactionSupplement) o.getDividendSwapTransactionSupplement()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("DividendSwapOptionTransactionSupplement", ValidationResult.ValidationType.ONLY_EXISTS, "DividendSwapOptionTransactionSupplement", path, "");
		}
		return failure("DividendSwapOptionTransactionSupplement", ValidationResult.ValidationType.ONLY_EXISTS, "DividendSwapOptionTransactionSupplement", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
