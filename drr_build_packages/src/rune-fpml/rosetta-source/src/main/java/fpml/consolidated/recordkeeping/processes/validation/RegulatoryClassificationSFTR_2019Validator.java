package fpml.consolidated.recordkeeping.processes.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.ReportingLevel;
import fpml.consolidated.doc.ReportingRole;
import fpml.consolidated.recordkeeping.processes.RegulatoryClassificationSFTR_2019;
import fpml.consolidated.shared.ActionType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RegulatoryClassificationSFTR_2019Validator implements Validator<RegulatoryClassificationSFTR_2019> {

	private List<ComparisonResult> getComparisonResults(RegulatoryClassificationSFTR_2019 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("reportingRole", (ReportingRole) o.getReportingRole() != null ? 1 : 0, 0, 1), 
				checkCardinality("reportingLevel", (ReportingLevel) o.getReportingLevel() != null ? 1 : 0, 0, 1), 
				checkCardinality("actionType", (ActionType) o.getActionType() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RegulatoryClassificationSFTR_2019 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RegulatoryClassificationSFTR_2019", ValidationResult.ValidationType.CARDINALITY, "RegulatoryClassificationSFTR_2019", path, "", res.getError());
				}
				return success("RegulatoryClassificationSFTR_2019", ValidationResult.ValidationType.CARDINALITY, "RegulatoryClassificationSFTR_2019", path, "");
			})
			.collect(toList());
	}

}
