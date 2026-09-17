package fpml.consolidated.msg.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.msg.ReportSectionIdentification;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class ReportSectionIdentificationTypeFormatValidator implements Validator<ReportSectionIdentification> {

	private List<ComparisonResult> getComparisonResults(ReportSectionIdentification o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("sectionNumber", o.getSectionNumber(), empty(), of(0), of(new BigDecimal("1")), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReportSectionIdentification o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReportSectionIdentification", ValidationResult.ValidationType.TYPE_FORMAT, "ReportSectionIdentification", path, "", res.getError());
				}
				return success("ReportSectionIdentification", ValidationResult.ValidationType.TYPE_FORMAT, "ReportSectionIdentification", path, "");
			})
			.collect(toList());
	}

}
