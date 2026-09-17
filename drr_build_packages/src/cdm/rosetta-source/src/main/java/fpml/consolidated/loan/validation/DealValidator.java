package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.Deal;
import fpml.consolidated.loan.DealSequence;
import fpml.consolidated.loan.MoneyWithParticipantShare;
import fpml.consolidated.loan.TransferFeeDefinition;
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

public class DealValidator implements Validator<Deal> {

	private List<ComparisonResult> getComparisonResults(Deal o) {
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
				checkCardinality("currentDealAmount", (MoneyWithParticipantShare) o.getCurrentDealAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("transferFee", (TransferFeeDefinition) o.getTransferFee() != null ? 1 : 0, 0, 1), 
				checkCardinality("dealSequence", (List<? extends DealSequence>) o.getDealSequence() == null ? 0 : o.getDealSequence().size(), 1, 0)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Deal o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Deal", ValidationResult.ValidationType.CARDINALITY, "Deal", path, "", res.getError());
				}
				return success("Deal", ValidationResult.ValidationType.CARDINALITY, "Deal", path, "");
			})
			.collect(toList());
	}

}
