package fpml.consolidated.reg.fpmlreporting.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.ReportingRole;
import fpml.consolidated.reg.fpmlreporting.shared.RegulationName;
import fpml.consolidated.reg.fpmlreporting.shared.RegulatorReportingStatusCode;
import fpml.consolidated.reg.fpmlreporting.shared.ReportingStatus;
import fpml.consolidated.shared.ReportingRegimeName;
import fpml.consolidated.shared.SupervisoryBody;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ReportingStatusValidator implements Validator<ReportingStatus> {

	private List<ComparisonResult> getComparisonResults(ReportingStatus o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("regimeName", (ReportingRegimeName) o.getRegimeName() != null ? 1 : 0, 0, 1), 
				checkCardinality("supervisoryBody", (SupervisoryBody) o.getSupervisoryBody() != null ? 1 : 0, 1, 1), 
				checkCardinality("regulation", (RegulationName) o.getRegulation() != null ? 1 : 0, 0, 1), 
				checkCardinality("reportingRole", (ReportingRole) o.getReportingRole() != null ? 1 : 0, 0, 1), 
				checkCardinality("status", (RegulatorReportingStatusCode) o.getStatus() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReportingStatus o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReportingStatus", ValidationResult.ValidationType.CARDINALITY, "ReportingStatus", path, "", res.getError());
				}
				return success("ReportingStatus", ValidationResult.ValidationType.CARDINALITY, "ReportingStatus", path, "");
			})
			.collect(toList());
	}

}
