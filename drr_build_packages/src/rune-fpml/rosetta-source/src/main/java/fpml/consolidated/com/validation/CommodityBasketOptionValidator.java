package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityBasketByNotional;
import fpml.consolidated.com.CommodityBasketByPercentage;
import fpml.consolidated.com.CommodityBasketOption;
import fpml.consolidated.com.CommodityCalculationPeriodsSchedule;
import fpml.consolidated.com.CommodityExerciseBasket;
import fpml.consolidated.com.CommodityMarketDisruption;
import fpml.consolidated.com.CommodityPremium;
import fpml.consolidated.com.CommodityStrikeSchedule;
import fpml.consolidated.com.FloatingStrikePrice;
import fpml.consolidated.com.StrikePriceBasketReference;
import fpml.consolidated.com.StrikePriceUnderlyingReference;
import fpml.consolidated.fpmlenum.CommodityBullionSettlementDisruptionEnum;
import fpml.consolidated.fpmlenum.PutCallEnum;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AdjustableDates;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.Rounding;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CommodityBasketOptionValidator implements Validator<CommodityBasketOption> {

	private List<ComparisonResult> getComparisonResults(CommodityBasketOption o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("primaryAssetClass", (AssetClass) o.getPrimaryAssetClass() != null ? 1 : 0, 0, 1), 
				checkCardinality("embeddedOptionType", (List<? extends EmbeddedOptionType>) o.getEmbeddedOptionType() == null ? 0 : o.getEmbeddedOptionType().size(), 0, 2), 
				checkCardinality("buyerPartyReference", (PartyReference) o.getBuyerPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("buyerAccountReference", (AccountReference) o.getBuyerAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("sellerPartyReference", (PartyReference) o.getSellerPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("sellerAccountReference", (AccountReference) o.getSellerAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("optionType", (PutCallEnum) o.getOptionType() != null ? 1 : 0, 1, 1), 
				checkCardinality("effectiveDate", (AdjustableOrRelativeDate) o.getEffectiveDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("terminationDate", (AdjustableOrRelativeDate) o.getTerminationDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculationPeriodsSchedule", (CommodityCalculationPeriodsSchedule) o.getCalculationPeriodsSchedule() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculationPeriods", (AdjustableDates) o.getCalculationPeriods() != null ? 1 : 0, 0, 1), 
				checkCardinality("notionalQuantityBasket", (CommodityBasketByNotional) o.getNotionalQuantityBasket() != null ? 1 : 0, 0, 1), 
				checkCardinality("notionalAmountBasket", (CommodityBasketByPercentage) o.getNotionalAmountBasket() != null ? 1 : 0, 0, 1), 
				checkCardinality("strikePriceUnderlyingReference", (StrikePriceUnderlyingReference) o.getStrikePriceUnderlyingReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("strikePriceBasketReference", (StrikePriceBasketReference) o.getStrikePriceBasketReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("strikePricePerUnit", (NonNegativeMoney) o.getStrikePricePerUnit() != null ? 1 : 0, 0, 1), 
				checkCardinality("strikePricePerUnitSchedule", (CommodityStrikeSchedule) o.getStrikePricePerUnitSchedule() != null ? 1 : 0, 0, 1), 
				checkCardinality("floatingStrikePricePerUnit", (FloatingStrikePrice) o.getFloatingStrikePricePerUnit() != null ? 1 : 0, 0, 1), 
				checkCardinality("floatingStrikePricePerUnitSchedule", (CommodityCalculationPeriodsSchedule) o.getFloatingStrikePricePerUnitSchedule() != null ? 1 : 0, 0, 1), 
				checkCardinality("exercise", (CommodityExerciseBasket) o.getExercise() != null ? 1 : 0, 1, 1), 
				checkCardinality("premium", (List<? extends CommodityPremium>) o.getPremium() == null ? 0 : o.getPremium().size(), 1, 0), 
				checkCardinality("commonPricing", (Boolean) o.getCommonPricing() != null ? 1 : 0, 0, 1), 
				checkCardinality("marketDisruption", (CommodityMarketDisruption) o.getMarketDisruption() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementDisruption", (CommodityBullionSettlementDisruptionEnum) o.getSettlementDisruption() != null ? 1 : 0, 0, 1), 
				checkCardinality("rounding", (Rounding) o.getRounding() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityBasketOption o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityBasketOption", ValidationResult.ValidationType.CARDINALITY, "CommodityBasketOption", path, "", res.getError());
				}
				return success("CommodityBasketOption", ValidationResult.ValidationType.CARDINALITY, "CommodityBasketOption", path, "");
			})
			.collect(toList());
	}

}
