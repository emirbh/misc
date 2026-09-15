package fpml.consolidated.msg.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.msg.ReportId;
import fpml.consolidated.msg.ReportSectionIdentification;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ReportSectionIdentificationValidator implements Validator<ReportSectionIdentification> {

	private List<ComparisonResult> getComparisonResults(ReportSectionIdentification o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("reportId", (ReportId) o.getReportId() != null ? 1 : 0, 0, 1), 
				checkCardinality("sectionNumber", (Integer) o.getSectionNumber() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReportSectionIdentification o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReportSectionIdentification", ValidationResult.ValidationType.CARDINALITY, "ReportSectionIdentification", path, "", res.getError());
				}
				return success("ReportSectionIdentification", ValidationResult.ValidationType.CARDINALITY, "ReportSectionIdentification", path, "");
			})
			.collect(toList());
	}

}
