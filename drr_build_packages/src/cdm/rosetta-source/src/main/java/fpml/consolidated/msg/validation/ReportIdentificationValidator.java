package fpml.consolidated.msg.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.msg.ReportId;
import fpml.consolidated.msg.ReportIdentification;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ReportIdentificationValidator implements Validator<ReportIdentification> {

	private List<ComparisonResult> getComparisonResults(ReportIdentification o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("reportId", (ReportId) o.getReportId() != null ? 1 : 0, 0, 1), 
				checkCardinality("sectionNumber", (Integer) o.getSectionNumber() != null ? 1 : 0, 0, 1), 
				checkCardinality("numberOfSections", (Integer) o.getNumberOfSections() != null ? 1 : 0, 0, 1), 
				checkCardinality("submissionsComplete", (Boolean) o.getSubmissionsComplete() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReportIdentification o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReportIdentification", ValidationResult.ValidationType.CARDINALITY, "ReportIdentification", path, "", res.getError());
				}
				return success("ReportIdentification", ValidationResult.ValidationType.CARDINALITY, "ReportIdentification", path, "");
			})
			.collect(toList());
	}

}
