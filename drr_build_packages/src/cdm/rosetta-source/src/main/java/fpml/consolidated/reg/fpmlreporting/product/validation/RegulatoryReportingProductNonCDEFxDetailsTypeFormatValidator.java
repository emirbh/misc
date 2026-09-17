package fpml.consolidated.reg.fpmlreporting.product.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.reg.fpmlreporting.product.RegulatoryReportingProductNonCDEFxDetails;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RegulatoryReportingProductNonCDEFxDetailsTypeFormatValidator implements Validator<RegulatoryReportingProductNonCDEFxDetails> {

	private List<ComparisonResult> getComparisonResults(RegulatoryReportingProductNonCDEFxDetails o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RegulatoryReportingProductNonCDEFxDetails o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RegulatoryReportingProductNonCDEFxDetails", ValidationResult.ValidationType.TYPE_FORMAT, "RegulatoryReportingProductNonCDEFxDetails", path, "", res.getError());
				}
				return success("RegulatoryReportingProductNonCDEFxDetails", ValidationResult.ValidationType.TYPE_FORMAT, "RegulatoryReportingProductNonCDEFxDetails", path, "");
			})
			.collect(toList());
	}

}
