package fpml.consolidated.fx.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.FxFixingScheduleSimple;
import fpml.consolidated.fx.FxPerformanceFixedLeg;
import fpml.consolidated.fx.FxPerformanceFloatingLeg;
import fpml.consolidated.fx.FxPerformanceSwap;
import fpml.consolidated.fx.FxValuationDateOffset;
import fpml.consolidated.shared.AdjustableOrAdjustedDate;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.FxCashSettlementSimple;
import fpml.consolidated.shared.FxSpotRateSource;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.QuotedCurrencyPair;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxPerformanceSwapValidator implements Validator<FxPerformanceSwap> {

	private List<ComparisonResult> getComparisonResults(FxPerformanceSwap o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("primaryAssetClass", (AssetClass) o.getPrimaryAssetClass() != null ? 1 : 0, 0, 1), 
				checkCardinality("embeddedOptionType", (List<? extends EmbeddedOptionType>) o.getEmbeddedOptionType() == null ? 0 : o.getEmbeddedOptionType().size(), 0, 2), 
				checkCardinality("quotedCurrencyPair", (QuotedCurrencyPair) o.getQuotedCurrencyPair() != null ? 1 : 0, 1, 1), 
				checkCardinality("vegaNotional", (NonNegativeMoney) o.getVegaNotional() != null ? 1 : 0, 1, 1), 
				checkCardinality("notional", (NonNegativeMoney) o.getNotional() != null ? 1 : 0, 0, 1), 
				checkCardinality("fixedLeg", (FxPerformanceFixedLeg) o.getFixedLeg() != null ? 1 : 0, 1, 1), 
				checkCardinality("floatingLeg", (FxPerformanceFloatingLeg) o.getFloatingLeg() != null ? 1 : 0, 1, 1), 
				checkCardinality("fixingInformationSource", (FxSpotRateSource) o.getFixingInformationSource() != null ? 1 : 0, 0, 1), 
				checkCardinality("fixingSchedule", (FxFixingScheduleSimple) o.getFixingSchedule() != null ? 1 : 0, 1, 1), 
				checkCardinality("valuationDate", (ZonedDateTime) o.getValuationDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("valuationDateOffset", (FxValuationDateOffset) o.getValuationDateOffset() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementDate", (AdjustableOrAdjustedDate) o.getSettlementDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("annualizationFactor", (BigDecimal) o.getAnnualizationFactor() != null ? 1 : 0, 1, 1), 
				checkCardinality("meanAdjustment", (Boolean) o.getMeanAdjustment() != null ? 1 : 0, 1, 1), 
				checkCardinality("cashSettlement", (FxCashSettlementSimple) o.getCashSettlement() != null ? 1 : 0, 0, 1), 
				checkCardinality("numberOfReturns", (Integer) o.getNumberOfReturns() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxPerformanceSwap o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxPerformanceSwap", ValidationResult.ValidationType.CARDINALITY, "FxPerformanceSwap", path, "", res.getError());
				}
				return success("FxPerformanceSwap", ValidationResult.ValidationType.CARDINALITY, "FxPerformanceSwap", path, "");
			})
			.collect(toList());
	}

}
