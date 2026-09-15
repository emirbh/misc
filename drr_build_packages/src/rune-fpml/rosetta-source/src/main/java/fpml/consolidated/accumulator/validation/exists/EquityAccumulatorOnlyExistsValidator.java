package fpml.consolidated.accumulator.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.accumulator.AccumulatorKnockOut;
import fpml.consolidated.accumulator.EquityAccumulator;
import fpml.consolidated.accumulator.EquityForwardExpiration;
import fpml.consolidated.accumulator.Gearing;
import fpml.consolidated.accumulator.ObservationPeriod;
import fpml.consolidated.asset.Underlyer;
import fpml.consolidated.eqd.PrePayment;
import fpml.consolidated.fpmlenum.SettlementTypeEnum;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import fpml.consolidated.shared.SettlementPriceSource;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class EquityAccumulatorOnlyExistsValidator implements ValidatorWithArg<EquityAccumulator, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends EquityAccumulator> ValidationResult<EquityAccumulator> validate(RosettaPath path, T2 o, Set<String> fields) {
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
				.put("notional", ExistenceChecker.isSet((NonNegativeMoney) o.getNotional()))
				.put("underlyer", ExistenceChecker.isSet((Underlyer) o.getUnderlyer()))
				.put("forwardPrice", ExistenceChecker.isSet((NonNegativeMoney) o.getForwardPrice()))
				.put("spotPrice", ExistenceChecker.isSet((NonNegativeMoney) o.getSpotPrice()))
				.put("numberOfSharesPerDay", ExistenceChecker.isSet((BigDecimal) o.getNumberOfSharesPerDay()))
				.put("maxNoOfTradingDays", ExistenceChecker.isSet((Integer) o.getMaxNoOfTradingDays()))
				.put("gearing", ExistenceChecker.isSet((Gearing) o.getGearing()))
				.put("guaranteedPeriodEndDate", ExistenceChecker.isSet((ZonedDateTime) o.getGuaranteedPeriodEndDate()))
				.put("observationPeriod", ExistenceChecker.isSet((List<? extends ObservationPeriod>) o.getObservationPeriod()))
				.put("expiration", ExistenceChecker.isSet((EquityForwardExpiration) o.getExpiration()))
				.put("prePayment", ExistenceChecker.isSet((PrePayment) o.getPrePayment()))
				.put("settlementType", ExistenceChecker.isSet((SettlementTypeEnum) o.getSettlementType()))
				.put("settlementCurrency", ExistenceChecker.isSet((Currency) o.getSettlementCurrency()))
				.put("settlementPriceSource", ExistenceChecker.isSet((SettlementPriceSource) o.getSettlementPriceSource()))
				.put("knockOut", ExistenceChecker.isSet((AccumulatorKnockOut) o.getKnockOut()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("EquityAccumulator", ValidationResult.ValidationType.ONLY_EXISTS, "EquityAccumulator", path, "");
		}
		return failure("EquityAccumulator", ValidationResult.ValidationType.ONLY_EXISTS, "EquityAccumulator", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
