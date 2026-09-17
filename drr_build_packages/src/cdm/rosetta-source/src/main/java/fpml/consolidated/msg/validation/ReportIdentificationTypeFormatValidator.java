package fpml.consolidated.msg.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.msg.ReportIdentification;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class ReportIdentificationTypeFormatValidator implements Validator<ReportIdentification> {

	private List<ComparisonResult> getComparisonResults(ReportIdentification o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("sectionNumber", o.getSectionNumber(), empty(), of(0), of(new BigDecimal("1")), empty()), 
				checkNumber("numberOfSections", o.getNumberOfSections(), empty(), of(0), of(new BigDecimal("1")), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReportIdentification o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReportIdentification", ValidationResult.ValidationType.TYPE_FORMAT, "ReportIdentification", path, "", res.getError());
				}
				return success("ReportIdentification", ValidationResult.ValidationType.TYPE_FORMAT, "ReportIdentification", path, "");
			})
			.collect(toList());
	}

}
