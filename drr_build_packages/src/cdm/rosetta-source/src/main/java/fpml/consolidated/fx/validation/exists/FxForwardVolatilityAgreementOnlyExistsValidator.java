package fpml.consolidated.fx.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.FxForwardVolatilityAgreement;
import fpml.consolidated.fx.FxStraddle;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.BusinessCenterTime;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.Payment;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import fpml.consolidated.shared.QuotedCurrencyPair;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxForwardVolatilityAgreementOnlyExistsValidator implements ValidatorWithArg<FxForwardVolatilityAgreement, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxForwardVolatilityAgreement> ValidationResult<FxForwardVolatilityAgreement> validate(RosettaPath path, T2 o, Set<String> fields) {
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
				.put("quotedCurrencyPair", ExistenceChecker.isSet((QuotedCurrencyPair) o.getQuotedCurrencyPair()))
				.put("fixingDate", ExistenceChecker.isSet((ZonedDateTime) o.getFixingDate()))
				.put("fixingTime", ExistenceChecker.isSet((BusinessCenterTime) o.getFixingTime()))
				.put("forwardVolatilityStrikePrice", ExistenceChecker.isSet((BigDecimal) o.getForwardVolatilityStrikePrice()))
				.put("straddle", ExistenceChecker.isSet((FxStraddle) o.getStraddle()))
				.put("additionalPayment", ExistenceChecker.isSet((List<? extends Payment>) o.getAdditionalPayment()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxForwardVolatilityAgreement", ValidationResult.ValidationType.ONLY_EXISTS, "FxForwardVolatilityAgreement", path, "");
		}
		return failure("FxForwardVolatilityAgreement", ValidationResult.ValidationType.ONLY_EXISTS, "FxForwardVolatilityAgreement", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
