package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.Underlyer;
import fpml.consolidated.com.CommodityMarketDisruption;
import fpml.consolidated.fpmlenum.DisruptionFallbacksEnum;
import fpml.consolidated.fpmlenum.MarketDisruptionEventsEnum;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CommodityMarketDisruptionValidator implements Validator<CommodityMarketDisruption> {

	private List<ComparisonResult> getComparisonResults(CommodityMarketDisruption o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("marketDisruptionEvents", (MarketDisruptionEventsEnum) o.getMarketDisruptionEvents() != null ? 1 : 0, 0, 1), 
				checkCardinality("disruptionFallbacks", (DisruptionFallbacksEnum) o.getDisruptionFallbacks() != null ? 1 : 0, 0, 1), 
				checkCardinality("fallbackReferencePrice", (Underlyer) o.getFallbackReferencePrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("maximumNumberOfDaysOfDisruption", (Integer) o.getMaximumNumberOfDaysOfDisruption() != null ? 1 : 0, 0, 1), 
				checkCardinality("priceMaterialityPercentage", (BigDecimal) o.getPriceMaterialityPercentage() != null ? 1 : 0, 0, 1), 
				checkCardinality("minimumFuturesContracts", (Integer) o.getMinimumFuturesContracts() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityMarketDisruption o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityMarketDisruption", ValidationResult.ValidationType.CARDINALITY, "CommodityMarketDisruption", path, "", res.getError());
				}
				return success("CommodityMarketDisruption", ValidationResult.ValidationType.CARDINALITY, "CommodityMarketDisruption", path, "");
			})
			.collect(toList());
	}

}
