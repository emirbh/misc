package fpml.consolidated.recordkeeping.processes.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.ExecutionVenueType;
import fpml.consolidated.doc.ReportingRole;
import fpml.consolidated.recordkeeping.processes.RegReportingPackageInfo;
import fpml.consolidated.recordkeeping.processes.RegulatoryClassificationPart43_2019;
import fpml.consolidated.shared.CollateralizationType;
import fpml.consolidated.shared.PartyReference;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RegulatoryClassificationPart43_2019Validator implements Validator<RegulatoryClassificationPart43_2019> {

	private List<ComparisonResult> getComparisonResults(RegulatoryClassificationPart43_2019 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("reportingRole", (ReportingRole) o.getReportingRole() != null ? 1 : 0, 0, 1), 
				checkCardinality("cancellationOfPublicReporting", (Boolean) o.getCancellationOfPublicReporting() != null ? 1 : 0, 0, 1), 
				checkCardinality("cleared", (String) o.getCleared() != null ? 1 : 0, 0, 1), 
				checkCardinality("endUserException", (Boolean) o.getEndUserException() != null ? 1 : 0, 0, 1), 
				checkCardinality("executionVenueType", (ExecutionVenueType) o.getExecutionVenueType() != null ? 1 : 0, 0, 1), 
				checkCardinality("collateralizationType", (CollateralizationType) o.getCollateralizationType() != null ? 1 : 0, 0, 1), 
				checkCardinality("offMarketPrice", (Boolean) o.getOffMarketPrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("largeSizeTrade", (Boolean) o.getLargeSizeTrade() != null ? 1 : 0, 0, 1), 
				checkCardinality("clearingService", (PartyReference) o.getClearingService() != null ? 1 : 0, 0, 1), 
				checkCardinality("packageInfo", (RegReportingPackageInfo) o.getPackageInfo() != null ? 1 : 0, 0, 1), 
				checkCardinality("disseminationTime", (ZonedDateTime) o.getDisseminationTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("disseminationId", (String) o.getDisseminationId() != null ? 1 : 0, 0, 1), 
				checkCardinality("originalDisseminationId", (String) o.getOriginalDisseminationId() != null ? 1 : 0, 0, 1), 
				checkCardinality("postPricedIndicator", (Boolean) o.getPostPricedIndicator() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RegulatoryClassificationPart43_2019 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RegulatoryClassificationPart43_2019", ValidationResult.ValidationType.CARDINALITY, "RegulatoryClassificationPart43_2019", path, "", res.getError());
				}
				return success("RegulatoryClassificationPart43_2019", ValidationResult.ValidationType.CARDINALITY, "RegulatoryClassificationPart43_2019", path, "");
			})
			.collect(toList());
	}

}
