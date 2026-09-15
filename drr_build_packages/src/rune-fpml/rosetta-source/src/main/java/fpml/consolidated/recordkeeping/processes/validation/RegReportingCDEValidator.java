package fpml.consolidated.recordkeeping.processes.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.ClearingStatusValue;
import fpml.consolidated.recordkeeping.processes.RegReportingCDE;
import fpml.consolidated.shared.PartyReference;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RegReportingCDEValidator implements Validator<RegReportingCDE> {

	private List<ComparisonResult> getComparisonResults(RegReportingCDE o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("buyerPartyReference", (PartyReference) o.getBuyerPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("sellerPartyReference", (PartyReference) o.getSellerPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("finalContractualSettlementDate", (ZonedDateTime) o.getFinalContractualSettlementDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("earlyTerminationDate", (ZonedDateTime) o.getEarlyTerminationDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("clearingStatus", (ClearingStatusValue) o.getClearingStatus() != null ? 1 : 0, 0, 1), 
				checkCardinality("confirmationStatus", (String) o.getConfirmationStatus() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RegReportingCDE o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RegReportingCDE", ValidationResult.ValidationType.CARDINALITY, "RegReportingCDE", path, "", res.getError());
				}
				return success("RegReportingCDE", ValidationResult.ValidationType.CARDINALITY, "RegReportingCDE", path, "");
			})
			.collect(toList());
	}

}
