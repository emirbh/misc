package fpml.consolidated.fx.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.FxFixingScheduleSimple;
import fpml.consolidated.fx.FxPerformanceFixedLeg;
import fpml.consolidated.fx.FxPerformanceFloatingLeg;
import fpml.consolidated.fx.FxValuationDateOffset;
import fpml.consolidated.fx.FxVolatilitySwap;
import fpml.consolidated.shared.AdjustableOrAdjustedDate;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.FxCashSettlementSimple;
import fpml.consolidated.shared.FxSpotRateSource;
import fpml.consolidated.shared.NonNegativeMoney;
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

public class FxVolatilitySwapOnlyExistsValidator implements ValidatorWithArg<FxVolatilitySwap, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxVolatilitySwap> ValidationResult<FxVolatilitySwap> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("primaryAssetClass", ExistenceChecker.isSet((AssetClass) o.getPrimaryAssetClass()))
				.put("secondaryAssetClass", ExistenceChecker.isSet((List<? extends AssetClass>) o.getSecondaryAssetClass()))
				.put("productType", ExistenceChecker.isSet((List<? extends ProductType>) o.getProductType()))
				.put("productId", ExistenceChecker.isSet((List<? extends ProductId>) o.getProductId()))
				.put("embeddedOptionType", ExistenceChecker.isSet((List<? extends EmbeddedOptionType>) o.getEmbeddedOptionType()))
				.put("assetClass", ExistenceChecker.isSet((List<? extends AssetClass>) o.getAssetClass()))
				.put("quotedCurrencyPair", ExistenceChecker.isSet((QuotedCurrencyPair) o.getQuotedCurrencyPair()))
				.put("vegaNotional", ExistenceChecker.isSet((NonNegativeMoney) o.getVegaNotional()))
				.put("notional", ExistenceChecker.isSet((NonNegativeMoney) o.getNotional()))
				.put("fixedLeg", ExistenceChecker.isSet((FxPerformanceFixedLeg) o.getFixedLeg()))
				.put("floatingLeg", ExistenceChecker.isSet((FxPerformanceFloatingLeg) o.getFloatingLeg()))
				.put("fixingInformationSource", ExistenceChecker.isSet((FxSpotRateSource) o.getFixingInformationSource()))
				.put("fixingSchedule", ExistenceChecker.isSet((FxFixingScheduleSimple) o.getFixingSchedule()))
				.put("valuationDate", ExistenceChecker.isSet((ZonedDateTime) o.getValuationDate()))
				.put("valuationDateOffset", ExistenceChecker.isSet((FxValuationDateOffset) o.getValuationDateOffset()))
				.put("settlementDate", ExistenceChecker.isSet((AdjustableOrAdjustedDate) o.getSettlementDate()))
				.put("annualizationFactor", ExistenceChecker.isSet((BigDecimal) o.getAnnualizationFactor()))
				.put("meanAdjustment", ExistenceChecker.isSet((Boolean) o.getMeanAdjustment()))
				.put("additionalPayment", ExistenceChecker.isSet((List<? extends Payment>) o.getAdditionalPayment()))
				.put("cashSettlement", ExistenceChecker.isSet((FxCashSettlementSimple) o.getCashSettlement()))
				.put("numberOfReturns", ExistenceChecker.isSet((Integer) o.getNumberOfReturns()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxVolatilitySwap", ValidationResult.ValidationType.ONLY_EXISTS, "FxVolatilitySwap", path, "");
		}
		return failure("FxVolatilitySwap", ValidationResult.ValidationType.ONLY_EXISTS, "FxVolatilitySwap", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
