package fpml.consolidated.fx.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.FxFlexibleForward;
import fpml.consolidated.fx.FxFlexibleForwardExecutionPeriod;
import fpml.consolidated.fx.FxFlexibleForwardRate;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.BusinessCenterTime;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.Payment;
import fpml.consolidated.shared.PositiveMoney;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import fpml.consolidated.shared.RelativeDateOffset;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxFlexibleForwardOnlyExistsValidator implements ValidatorWithArg<FxFlexibleForward, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxFlexibleForward> ValidationResult<FxFlexibleForward> validate(RosettaPath path, T2 o, Set<String> fields) {
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
				.put("putCurrency", ExistenceChecker.isSet((Currency) o.getPutCurrency()))
				.put("callCurrency", ExistenceChecker.isSet((Currency) o.getCallCurrency()))
				.put("notionalAmount", ExistenceChecker.isSet((NonNegativeMoney) o.getNotionalAmount()))
				.put("minimumExecutionAmount", ExistenceChecker.isSet((PositiveMoney) o.getMinimumExecutionAmount()))
				.put("settlementAmount", ExistenceChecker.isSet((NonNegativeMoney) o.getSettlementAmount()))
				.put("executionPeriodDates", ExistenceChecker.isSet((FxFlexibleForwardExecutionPeriod) o.getExecutionPeriodDates()))
				.put("earliestExecutionTime", ExistenceChecker.isSet((BusinessCenterTime) o.getEarliestExecutionTime()))
				.put("latestExecutionTime", ExistenceChecker.isSet((BusinessCenterTime) o.getLatestExecutionTime()))
				.put("settlementDateOffset", ExistenceChecker.isSet((RelativeDateOffset) o.getSettlementDateOffset()))
				.put("finalSettlementDate", ExistenceChecker.isSet((ZonedDateTime) o.getFinalSettlementDate()))
				.put("forwardRate", ExistenceChecker.isSet((FxFlexibleForwardRate) o.getForwardRate()))
				.put("additionalPayment", ExistenceChecker.isSet((Payment) o.getAdditionalPayment()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxFlexibleForward", ValidationResult.ValidationType.ONLY_EXISTS, "FxFlexibleForward", path, "");
		}
		return failure("FxFlexibleForward", ValidationResult.ValidationType.ONLY_EXISTS, "FxFlexibleForward", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
