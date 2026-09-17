package fpml.consolidated.reg.fpmlreporting.product.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.reg.fpmlreporting.product.RegulatoryReportingProductParties;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RegulatoryReportingProductPartiesTypeFormatValidator implements Validator<RegulatoryReportingProductParties> {

	private List<ComparisonResult> getComparisonResults(RegulatoryReportingProductParties o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RegulatoryReportingProductParties o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RegulatoryReportingProductParties", ValidationResult.ValidationType.TYPE_FORMAT, "RegulatoryReportingProductParties", path, "", res.getError());
				}
				return success("RegulatoryReportingProductParties", ValidationResult.ValidationType.TYPE_FORMAT, "RegulatoryReportingProductParties", path, "");
			})
			.collect(toList());
	}

}
