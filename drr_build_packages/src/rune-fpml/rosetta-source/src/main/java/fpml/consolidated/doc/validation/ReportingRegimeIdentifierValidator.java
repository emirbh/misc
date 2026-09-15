package fpml.consolidated.doc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.ReportingRegimeIdentifier;
import fpml.consolidated.doc.ReportingRole;
import fpml.consolidated.shared.ActionType;
import fpml.consolidated.shared.ReportingRegimeName;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ReportingRegimeIdentifierValidator implements Validator<ReportingRegimeIdentifier> {

	private List<ComparisonResult> getComparisonResults(ReportingRegimeIdentifier o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("name", (ReportingRegimeName) o.getName() != null ? 1 : 0, 0, 1), 
				checkCardinality("reportingRole", (ReportingRole) o.getReportingRole() != null ? 1 : 0, 0, 1), 
				checkCardinality("actionType", (ActionType) o.getActionType() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReportingRegimeIdentifier o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReportingRegimeIdentifier", ValidationResult.ValidationType.CARDINALITY, "ReportingRegimeIdentifier", path, "", res.getError());
				}
				return success("ReportingRegimeIdentifier", ValidationResult.ValidationType.CARDINALITY, "ReportingRegimeIdentifier", path, "");
			})
			.collect(toList());
	}

}
