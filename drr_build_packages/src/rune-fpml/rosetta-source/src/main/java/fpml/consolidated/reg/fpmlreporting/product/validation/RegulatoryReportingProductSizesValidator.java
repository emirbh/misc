package fpml.consolidated.reg.fpmlreporting.product.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityPhysicalQuantitySchedule;
import fpml.consolidated.reg.fpmlreporting.product.RegulatoryReportingProductSizes;
import fpml.consolidated.shared.NonNegativeMoney;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RegulatoryReportingProductSizesValidator implements Validator<RegulatoryReportingProductSizes> {

	private List<ComparisonResult> getComparisonResults(RegulatoryReportingProductSizes o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("callAmount", (NonNegativeMoney) o.getCallAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("putAmount", (NonNegativeMoney) o.getPutAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("quantitySchedule", (CommodityPhysicalQuantitySchedule) o.getQuantitySchedule() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RegulatoryReportingProductSizes o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RegulatoryReportingProductSizes", ValidationResult.ValidationType.CARDINALITY, "RegulatoryReportingProductSizes", path, "", res.getError());
				}
				return success("RegulatoryReportingProductSizes", ValidationResult.ValidationType.CARDINALITY, "RegulatoryReportingProductSizes", path, "");
			})
			.collect(toList());
	}

}
