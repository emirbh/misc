package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.CommitmentSchedule;
import fpml.consolidated.loan.DealReference;
import fpml.consolidated.loan.FacilityCommitment;
import fpml.consolidated.loan.FacilitySummary;
import fpml.consolidated.loan.FxTerms;
import fpml.consolidated.loan.MoneyWithParticipantShare;
import fpml.consolidated.shared.InstrumentId;
import fpml.consolidated.shared.PartyReference;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FacilitySummaryValidator implements Validator<FacilitySummary> {

	private List<ComparisonResult> getComparisonResults(FacilitySummary o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("partyReference", (PartyReference) o.getPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("instrumentId", (List<? extends InstrumentId>) o.getInstrumentId() == null ? 0 : o.getInstrumentId().size(), 1, 0), 
				checkCardinality("description", (String) o.getDescription() != null ? 1 : 0, 0, 1), 
				checkCardinality("dealReference", (DealReference) o.getDealReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("borrowerPartyReference", (PartyReference) o.getBorrowerPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("agentPartyReference", (PartyReference) o.getAgentPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("startDate", (ZonedDateTime) o.getStartDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("expiryDate", (ZonedDateTime) o.getExpiryDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("maturityDate", (ZonedDateTime) o.getMaturityDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("currentCommitment", (FacilityCommitment) o.getCurrentCommitment() != null ? 1 : 0, 1, 1), 
				checkCardinality("originalCommitment", (MoneyWithParticipantShare) o.getOriginalCommitment() != null ? 1 : 0, 0, 1), 
				checkCardinality("commitmentSchedule", (CommitmentSchedule) o.getCommitmentSchedule() != null ? 1 : 0, 0, 1), 
				checkCardinality("dealFxRate", (FxTerms) o.getDealFxRate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FacilitySummary o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FacilitySummary", ValidationResult.ValidationType.CARDINALITY, "FacilitySummary", path, "", res.getError());
				}
				return success("FacilitySummary", ValidationResult.ValidationType.CARDINALITY, "FacilitySummary", path, "");
			})
			.collect(toList());
	}

}
