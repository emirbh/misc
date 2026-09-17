package fpml.consolidated.recordkeeping.processes.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.ReportingRole;
import fpml.consolidated.recordkeeping.processes.RegulatoryClassificationCSA_2016;
import fpml.consolidated.shared.ActionType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RegulatoryClassificationCSA_2016Validator implements Validator<RegulatoryClassificationCSA_2016> {

	private List<ComparisonResult> getComparisonResults(RegulatoryClassificationCSA_2016 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("reportingRole", (ReportingRole) o.getReportingRole() != null ? 1 : 0, 0, 1), 
				checkCardinality("interAffiliate", (Boolean) o.getInterAffiliate() != null ? 1 : 0, 0, 1), 
				checkCardinality("actionType", (ActionType) o.getActionType() != null ? 1 : 0, 0, 1), 
				checkCardinality("eventType", (String) o.getEventType() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RegulatoryClassificationCSA_2016 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RegulatoryClassificationCSA_2016", ValidationResult.ValidationType.CARDINALITY, "RegulatoryClassificationCSA_2016", path, "", res.getError());
				}
				return success("RegulatoryClassificationCSA_2016", ValidationResult.ValidationType.CARDINALITY, "RegulatoryClassificationCSA_2016", path, "");
			})
			.collect(toList());
	}

}
