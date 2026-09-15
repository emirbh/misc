package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityMarketDisruption;
import fpml.consolidated.com.CommodityPerformanceSwapBase;
import fpml.consolidated.com.CommodityPerformanceSwapLeg;
import fpml.consolidated.fpmlenum.CommodityBullionSettlementDisruptionEnum;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.IdentifiedCurrency;
import fpml.consolidated.shared.Rounding;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CommodityPerformanceSwapBaseValidator implements Validator<CommodityPerformanceSwapBase> {

	private List<ComparisonResult> getComparisonResults(CommodityPerformanceSwapBase o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("primaryAssetClass", (AssetClass) o.getPrimaryAssetClass() != null ? 1 : 0, 0, 1), 
				checkCardinality("embeddedOptionType", (List<? extends EmbeddedOptionType>) o.getEmbeddedOptionType() == null ? 0 : o.getEmbeddedOptionType().size(), 0, 2), 
				checkCardinality("effectiveDate", (AdjustableOrRelativeDate) o.getEffectiveDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("terminationDate", (AdjustableOrRelativeDate) o.getTerminationDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementCurrency", (IdentifiedCurrency) o.getSettlementCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("commodityPerformanceSwapLeg", (List<? extends CommodityPerformanceSwapLeg>) o.getCommodityPerformanceSwapLeg() == null ? 0 : o.getCommodityPerformanceSwapLeg().size(), 0, 2), 
				checkCardinality("commonPricing", (Boolean) o.getCommonPricing() != null ? 1 : 0, 0, 1), 
				checkCardinality("marketDisruption", (CommodityMarketDisruption) o.getMarketDisruption() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementDisruption", (CommodityBullionSettlementDisruptionEnum) o.getSettlementDisruption() != null ? 1 : 0, 0, 1), 
				checkCardinality("rounding", (Rounding) o.getRounding() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityPerformanceSwapBase o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityPerformanceSwapBase", ValidationResult.ValidationType.CARDINALITY, "CommodityPerformanceSwapBase", path, "", res.getError());
				}
				return success("CommodityPerformanceSwapBase", ValidationResult.ValidationType.CARDINALITY, "CommodityPerformanceSwapBase", path, "");
			})
			.collect(toList());
	}

}
