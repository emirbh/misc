package fpml.consolidated.accumulator.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
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
import fpml.consolidated.shared.SettlementPriceSource;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class EquityAccumulatorValidator implements Validator<EquityAccumulator> {

	private List<ComparisonResult> getComparisonResults(EquityAccumulator o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("primaryAssetClass", (AssetClass) o.getPrimaryAssetClass() != null ? 1 : 0, 0, 1), 
				checkCardinality("embeddedOptionType", (List<? extends EmbeddedOptionType>) o.getEmbeddedOptionType() == null ? 0 : o.getEmbeddedOptionType().size(), 0, 2), 
				checkCardinality("buyerPartyReference", (PartyReference) o.getBuyerPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("buyerAccountReference", (AccountReference) o.getBuyerAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("sellerPartyReference", (PartyReference) o.getSellerPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("sellerAccountReference", (AccountReference) o.getSellerAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("notional", (NonNegativeMoney) o.getNotional() != null ? 1 : 0, 1, 1), 
				checkCardinality("underlyer", (Underlyer) o.getUnderlyer() != null ? 1 : 0, 1, 1), 
				checkCardinality("forwardPrice", (NonNegativeMoney) o.getForwardPrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("spotPrice", (NonNegativeMoney) o.getSpotPrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("numberOfSharesPerDay", (BigDecimal) o.getNumberOfSharesPerDay() != null ? 1 : 0, 1, 1), 
				checkCardinality("maxNoOfTradingDays", (Integer) o.getMaxNoOfTradingDays() != null ? 1 : 0, 0, 1), 
				checkCardinality("gearing", (Gearing) o.getGearing() != null ? 1 : 0, 0, 1), 
				checkCardinality("guaranteedPeriodEndDate", (ZonedDateTime) o.getGuaranteedPeriodEndDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("observationPeriod", (List<? extends ObservationPeriod>) o.getObservationPeriod() == null ? 0 : o.getObservationPeriod().size(), 1, 0), 
				checkCardinality("expiration", (EquityForwardExpiration) o.getExpiration() != null ? 1 : 0, 1, 1), 
				checkCardinality("prePayment", (PrePayment) o.getPrePayment() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementType", (SettlementTypeEnum) o.getSettlementType() != null ? 1 : 0, 1, 1), 
				checkCardinality("settlementCurrency", (Currency) o.getSettlementCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementPriceSource", (SettlementPriceSource) o.getSettlementPriceSource() != null ? 1 : 0, 0, 1), 
				checkCardinality("knockOut", (AccumulatorKnockOut) o.getKnockOut() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EquityAccumulator o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EquityAccumulator", ValidationResult.ValidationType.CARDINALITY, "EquityAccumulator", path, "", res.getError());
				}
				return success("EquityAccumulator", ValidationResult.ValidationType.CARDINALITY, "EquityAccumulator", path, "");
			})
			.collect(toList());
	}

}
