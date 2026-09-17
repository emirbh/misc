package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.LcAutoAdjustEnum;
import fpml.consolidated.loan.EvergreenOption;
import fpml.consolidated.loan.FacilityReference;
import fpml.consolidated.loan.FxTerms;
import fpml.consolidated.loan.LcAccrual;
import fpml.consolidated.loan.LcPurpose;
import fpml.consolidated.loan.LcType;
import fpml.consolidated.loan.LetterOfCredit;
import fpml.consolidated.loan.MoneyWithParticipantShare;
import fpml.consolidated.shared.PartyReference;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LetterOfCreditValidator implements Validator<LetterOfCredit> {

	private List<ComparisonResult> getComparisonResults(LetterOfCredit o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("partyReference", (PartyReference) o.getPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("facilityReference", (FacilityReference) o.getFacilityReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("type", (LcType) o._getType() != null ? 1 : 0, 1, 1), 
				checkCardinality("effectiveDate", (ZonedDateTime) o.getEffectiveDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("borrowerPartyReference", (PartyReference) o.getBorrowerPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("issuingBankPartyReference", (PartyReference) o.getIssuingBankPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("beneficiaryPartyReference", (PartyReference) o.getBeneficiaryPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("amount", (MoneyWithParticipantShare) o.getAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("expiryDate", (ZonedDateTime) o.getExpiryDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("finalExpiryDate", (ZonedDateTime) o.getFinalExpiryDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("lcAccrual", (LcAccrual) o.getLcAccrual() != null ? 1 : 0, 1, 1), 
				checkCardinality("purpose", (LcPurpose) o.getPurpose() != null ? 1 : 0, 0, 1), 
				checkCardinality("evergreenOption", (EvergreenOption) o.getEvergreenOption() != null ? 1 : 0, 0, 1), 
				checkCardinality("lcAutoAdjust", (LcAutoAdjustEnum) o.getLcAutoAdjust() != null ? 1 : 0, 0, 1), 
				checkCardinality("minLcIssuanceFeeAmount", (MoneyWithParticipantShare) o.getMinLcIssuanceFeeAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("facilityFxRate", (FxTerms) o.getFacilityFxRate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LetterOfCredit o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LetterOfCredit", ValidationResult.ValidationType.CARDINALITY, "LetterOfCredit", path, "", res.getError());
				}
				return success("LetterOfCredit", ValidationResult.ValidationType.CARDINALITY, "LetterOfCredit", path, "");
			})
			.collect(toList());
	}

}
