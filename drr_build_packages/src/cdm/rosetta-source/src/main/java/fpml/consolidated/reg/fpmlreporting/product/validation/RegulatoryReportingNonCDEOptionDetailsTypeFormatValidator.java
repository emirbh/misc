package fpml.consolidated.reg.fpmlreporting.product.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.reg.fpmlreporting.product.RegulatoryReportingNonCDEOptionDetails;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RegulatoryReportingNonCDEOptionDetailsTypeFormatValidator implements Validator<RegulatoryReportingNonCDEOptionDetails> {

	private List<ComparisonResult> getComparisonResults(RegulatoryReportingNonCDEOptionDetails o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RegulatoryReportingNonCDEOptionDetails o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RegulatoryReportingNonCDEOptionDetails", ValidationResult.ValidationType.TYPE_FORMAT, "RegulatoryReportingNonCDEOptionDetails", path, "", res.getError());
				}
				return success("RegulatoryReportingNonCDEOptionDetails", ValidationResult.ValidationType.TYPE_FORMAT, "RegulatoryReportingNonCDEOptionDetails", path, "");
			})
			.collect(toList());
	}

}
