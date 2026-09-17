package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.DealSummary;
import fpml.consolidated.loan.MoneyWithParticipantShare;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.InstrumentId;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.PartyReference;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class DealSummaryValidator implements Validator<DealSummary> {

	private List<ComparisonResult> getComparisonResults(DealSummary o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("partyReference", (PartyReference) o.getPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("instrumentId", (List<? extends InstrumentId>) o.getInstrumentId() == null ? 0 : o.getInstrumentId().size(), 1, 0), 
				checkCardinality("description", (String) o.getDescription() != null ? 1 : 0, 0, 1), 
				checkCardinality("issuerPartyReference", (PartyReference) o.getIssuerPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("agentPartyReference", (PartyReference) o.getAgentPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("syndicationLeadPartyReference", (PartyReference) o.getSyndicationLeadPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("creditAgreementDate", (ZonedDateTime) o.getCreditAgreementDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("currency", (Currency) o.getCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("issuedAmount", (NonNegativeMoney) o.getIssuedAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("currentDealAmount", (MoneyWithParticipantShare) o.getCurrentDealAmount() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DealSummary o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DealSummary", ValidationResult.ValidationType.CARDINALITY, "DealSummary", path, "", res.getError());
				}
				return success("DealSummary", ValidationResult.ValidationType.CARDINALITY, "DealSummary", path, "");
			})
			.collect(toList());
	}

}
