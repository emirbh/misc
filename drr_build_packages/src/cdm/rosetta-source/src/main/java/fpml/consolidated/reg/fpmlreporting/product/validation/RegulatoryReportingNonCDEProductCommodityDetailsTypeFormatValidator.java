package fpml.consolidated.reg.fpmlreporting.product.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.reg.fpmlreporting.product.RegulatoryReportingNonCDEProductCommodityDetails;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RegulatoryReportingNonCDEProductCommodityDetailsTypeFormatValidator implements Validator<RegulatoryReportingNonCDEProductCommodityDetails> {

	private List<ComparisonResult> getComparisonResults(RegulatoryReportingNonCDEProductCommodityDetails o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RegulatoryReportingNonCDEProductCommodityDetails o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RegulatoryReportingNonCDEProductCommodityDetails", ValidationResult.ValidationType.TYPE_FORMAT, "RegulatoryReportingNonCDEProductCommodityDetails", path, "", res.getError());
				}
				return success("RegulatoryReportingNonCDEProductCommodityDetails", ValidationResult.ValidationType.TYPE_FORMAT, "RegulatoryReportingNonCDEProductCommodityDetails", path, "");
			})
			.collect(toList());
	}

}
