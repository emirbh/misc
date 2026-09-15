package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.AveragePriceLeg;
import fpml.consolidated.com.CommodityForward;
import fpml.consolidated.com.CommodityMarketDisruption;
import fpml.consolidated.com.NonPeriodicFixedPriceLeg;
import fpml.consolidated.com.PhysicalLegBase;
import fpml.consolidated.fpmlenum.CommodityBullionSettlementDisruptionEnum;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.Rounding;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CommodityForwardValidator implements Validator<CommodityForward> {

	private List<ComparisonResult> getComparisonResults(CommodityForward o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("primaryAssetClass", (AssetClass) o.getPrimaryAssetClass() != null ? 1 : 0, 0, 1), 
				checkCardinality("embeddedOptionType", (List<? extends EmbeddedOptionType>) o.getEmbeddedOptionType() == null ? 0 : o.getEmbeddedOptionType().size(), 0, 2), 
				checkCardinality("valueDate", (AdjustableOrRelativeDate) o.getValueDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("fixedLeg", (NonPeriodicFixedPriceLeg) o.getFixedLeg() != null ? 1 : 0, 0, 1), 
				checkCardinality("averagePriceLeg", (AveragePriceLeg) o.getAveragePriceLeg() != null ? 1 : 0, 0, 1), 
				checkCardinality("physicalCommodityForwardLeg", (PhysicalLegBase) o.getPhysicalCommodityForwardLeg() != null ? 1 : 0, 0, 1), 
				checkCardinality("commonPricing", (Boolean) o.getCommonPricing() != null ? 1 : 0, 0, 1), 
				checkCardinality("marketDisruption", (CommodityMarketDisruption) o.getMarketDisruption() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementDisruption", (CommodityBullionSettlementDisruptionEnum) o.getSettlementDisruption() != null ? 1 : 0, 0, 1), 
				checkCardinality("rounding", (Rounding) o.getRounding() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityForward o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityForward", ValidationResult.ValidationType.CARDINALITY, "CommodityForward", path, "", res.getError());
				}
				return success("CommodityForward", ValidationResult.ValidationType.CARDINALITY, "CommodityForward", path, "");
			})
			.collect(toList());
	}

}
