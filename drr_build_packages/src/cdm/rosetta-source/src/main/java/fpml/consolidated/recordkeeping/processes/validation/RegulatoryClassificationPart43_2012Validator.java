package fpml.consolidated.recordkeeping.processes.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.ExecutionVenueType;
import fpml.consolidated.doc.ReportingRole;
import fpml.consolidated.recordkeeping.processes.RegulatoryClassificationPart43_2012;
import fpml.consolidated.shared.CollateralizationType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RegulatoryClassificationPart43_2012Validator implements Validator<RegulatoryClassificationPart43_2012> {

	private List<ComparisonResult> getComparisonResults(RegulatoryClassificationPart43_2012 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("reportingRole", (ReportingRole) o.getReportingRole() != null ? 1 : 0, 0, 1), 
				checkCardinality("cancellation", (Boolean) o.getCancellation() != null ? 1 : 0, 0, 1), 
				checkCardinality("cleared", (String) o.getCleared() != null ? 1 : 0, 0, 1), 
				checkCardinality("executionVenueType", (ExecutionVenueType) o.getExecutionVenueType() != null ? 1 : 0, 0, 1), 
				checkCardinality("collateralizationType", (CollateralizationType) o.getCollateralizationType() != null ? 1 : 0, 0, 1), 
				checkCardinality("offMarketPrice", (Boolean) o.getOffMarketPrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("largeSizeTrade", (Boolean) o.getLargeSizeTrade() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RegulatoryClassificationPart43_2012 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RegulatoryClassificationPart43_2012", ValidationResult.ValidationType.CARDINALITY, "RegulatoryClassificationPart43_2012", path, "", res.getError());
				}
				return success("RegulatoryClassificationPart43_2012", ValidationResult.ValidationType.CARDINALITY, "RegulatoryClassificationPart43_2012", path, "");
			})
			.collect(toList());
	}

}
