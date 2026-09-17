package fpml.consolidated.reg.fpmlreporting.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.reg.fpmlreporting.shared.RegulatoryReportingCollateralization;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RegulatoryReportingCollateralizationTypeFormatValidator implements Validator<RegulatoryReportingCollateralization> {

	private List<ComparisonResult> getComparisonResults(RegulatoryReportingCollateralization o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RegulatoryReportingCollateralization o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RegulatoryReportingCollateralization", ValidationResult.ValidationType.TYPE_FORMAT, "RegulatoryReportingCollateralization", path, "", res.getError());
				}
				return success("RegulatoryReportingCollateralization", ValidationResult.ValidationType.TYPE_FORMAT, "RegulatoryReportingCollateralization", path, "");
			})
			.collect(toList());
	}

}
