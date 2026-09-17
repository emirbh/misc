package fpml.consolidated.doc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.AllocationReportingStatus;
import fpml.consolidated.doc.ClearingStatusValue;
import fpml.consolidated.doc.ExecutionDateTime;
import fpml.consolidated.doc.ExecutionVenueType;
import fpml.consolidated.doc.PackageInformation;
import fpml.consolidated.doc.TradeProcessingTimestamps;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PackageInformationValidator implements Validator<PackageInformation> {

	private List<ComparisonResult> getComparisonResults(PackageInformation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("executionDateTime", (ExecutionDateTime) o.getExecutionDateTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("timestamps", (TradeProcessingTimestamps) o.getTimestamps() != null ? 1 : 0, 0, 1), 
				checkCardinality("intentToAllocate", (Boolean) o.getIntentToAllocate() != null ? 1 : 0, 0, 1), 
				checkCardinality("allocationStatus", (AllocationReportingStatus) o.getAllocationStatus() != null ? 1 : 0, 0, 1), 
				checkCardinality("intentToClear", (Boolean) o.getIntentToClear() != null ? 1 : 0, 0, 1), 
				checkCardinality("clearingStatus", (ClearingStatusValue) o.getClearingStatus() != null ? 1 : 0, 0, 1), 
				checkCardinality("executionVenueType", (ExecutionVenueType) o.getExecutionVenueType() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PackageInformation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PackageInformation", ValidationResult.ValidationType.CARDINALITY, "PackageInformation", path, "", res.getError());
				}
				return success("PackageInformation", ValidationResult.ValidationType.CARDINALITY, "PackageInformation", path, "");
			})
			.collect(toList());
	}

}
