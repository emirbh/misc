package fpml.consolidated.reg.fpmlreporting.product.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityFixedPrice;
import fpml.consolidated.com.CommodityQuantityFrequency;
import fpml.consolidated.com.InterconnectionPoint;
import fpml.consolidated.fpmlenum.LoadTypeEnum;
import fpml.consolidated.reg.fpmlreporting.product.RegulatoryReportingNonCDEProductCommodityDetails;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RegulatoryReportingNonCDEProductCommodityDetailsValidator implements Validator<RegulatoryReportingNonCDEProductCommodityDetails> {

	private List<ComparisonResult> getComparisonResults(RegulatoryReportingNonCDEProductCommodityDetails o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("loadType", (LoadTypeEnum) o.getLoadType() != null ? 1 : 0, 0, 1), 
				checkCardinality("quantity", (BigDecimal) o.getQuantity() != null ? 1 : 0, 0, 1), 
				checkCardinality("quantityFrequency", (CommodityQuantityFrequency) o.getQuantityFrequency() != null ? 1 : 0, 0, 1), 
				checkCardinality("fixedPrice", (CommodityFixedPrice) o.getFixedPrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("interconnectionPoint", (InterconnectionPoint) o.getInterconnectionPoint() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RegulatoryReportingNonCDEProductCommodityDetails o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RegulatoryReportingNonCDEProductCommodityDetails", ValidationResult.ValidationType.CARDINALITY, "RegulatoryReportingNonCDEProductCommodityDetails", path, "", res.getError());
				}
				return success("RegulatoryReportingNonCDEProductCommodityDetails", ValidationResult.ValidationType.CARDINALITY, "RegulatoryReportingNonCDEProductCommodityDetails", path, "");
			})
			.collect(toList());
	}

}
