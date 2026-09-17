package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.Lien;
import fpml.consolidated.loan.AbstractFacilityChoice;
import fpml.consolidated.loan.AccruingPikOption;
import fpml.consolidated.loan.CommitmentSchedule;
import fpml.consolidated.loan.DealReference;
import fpml.consolidated.loan.FacilityCommitment;
import fpml.consolidated.loan.FxTerms;
import fpml.consolidated.loan.LetterOfCreditFacility;
import fpml.consolidated.loan.MoneyWithParticipantShare;
import fpml.consolidated.loan.MultiCurrency;
import fpml.consolidated.loan.PeriodRate;
import fpml.consolidated.shared.CreditSeniority;
import fpml.consolidated.shared.GoverningLaw;
import fpml.consolidated.shared.InstrumentId;
import fpml.consolidated.shared.PartyReference;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LetterOfCreditFacilityValidator implements Validator<LetterOfCreditFacility> {

	private List<ComparisonResult> getComparisonResults(LetterOfCreditFacility o) {
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
				checkCardinality("dealFxRate", (FxTerms) o.getDealFxRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("governingLaw", (GoverningLaw) o.getGoverningLaw() != null ? 1 : 0, 0, 1), 
				checkCardinality("lien", (Lien) o.getLien() != null ? 1 : 0, 0, 1), 
				checkCardinality("seniority", (CreditSeniority) o.getSeniority() != null ? 1 : 0, 0, 1), 
				checkCardinality("abstractFacilityChoice", (List<? extends AbstractFacilityChoice>) o.getAbstractFacilityChoice() == null ? 0 : o.getAbstractFacilityChoice().size(), 1, 0), 
				checkCardinality("accruingPikOption", (AccruingPikOption) o.getAccruingPikOption() != null ? 1 : 0, 0, 1), 
				checkCardinality("defaultRate", (PeriodRate) o.getDefaultRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("mandatoryCostRate", (PeriodRate) o.getMandatoryCostRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("penaltyRate", (PeriodRate) o.getPenaltyRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("multiCurrency", (MultiCurrency) o.getMultiCurrency() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LetterOfCreditFacility o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LetterOfCreditFacility", ValidationResult.ValidationType.CARDINALITY, "LetterOfCreditFacility", path, "", res.getError());
				}
				return success("LetterOfCreditFacility", ValidationResult.ValidationType.CARDINALITY, "LetterOfCreditFacility", path, "");
			})
			.collect(toList());
	}

}
