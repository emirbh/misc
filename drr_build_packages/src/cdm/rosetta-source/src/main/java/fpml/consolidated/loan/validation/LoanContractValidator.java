package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.FacilityReference;
import fpml.consolidated.loan.FixedRateAccrual;
import fpml.consolidated.loan.FxTerms;
import fpml.consolidated.loan.LegacyFloatingRateAccrual;
import fpml.consolidated.loan.LoanContract;
import fpml.consolidated.loan.LoanFloatingRateAccrual;
import fpml.consolidated.loan.MoneyWithParticipantShare;
import fpml.consolidated.shared.PartyReference;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LoanContractValidator implements Validator<LoanContract> {

	private List<ComparisonResult> getComparisonResults(LoanContract o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("partyReference", (PartyReference) o.getPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("facilityReference", (FacilityReference) o.getFacilityReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("effectiveDate", (ZonedDateTime) o.getEffectiveDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("borrowerPartyReference", (PartyReference) o.getBorrowerPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("guarantorPartyReference", (PartyReference) o.getGuarantorPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("amount", (MoneyWithParticipantShare) o.getAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("repricingDate", (ZonedDateTime) o.getRepricingDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("maturityDate", (ZonedDateTime) o.getMaturityDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("fixedRateAccrual", (FixedRateAccrual) o.getFixedRateAccrual() != null ? 1 : 0, 0, 1), 
				checkCardinality("floatingRateAccrual", (LoanFloatingRateAccrual) o.getFloatingRateAccrual() != null ? 1 : 0, 0, 1), 
				checkCardinality("legacyFloatingRateAccrual", (LegacyFloatingRateAccrual) o.getLegacyFloatingRateAccrual() != null ? 1 : 0, 0, 1), 
				checkCardinality("facilityFxRate", (FxTerms) o.getFacilityFxRate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanContract o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanContract", ValidationResult.ValidationType.CARDINALITY, "LoanContract", path, "", res.getError());
				}
				return success("LoanContract", ValidationResult.ValidationType.CARDINALITY, "LoanContract", path, "");
			})
			.collect(toList());
	}

}
