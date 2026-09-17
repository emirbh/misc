package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.AmendmentEffectiveDate;
import cdm.legaldocumentation.csa.TerminationCurrencyAmendment;
import cdm.legaldocumentation.csa.TerminationCurrencyElection;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TerminationCurrencyAmendmentValidator implements Validator<TerminationCurrencyAmendment> {

	private List<ComparisonResult> getComparisonResults(TerminationCurrencyAmendment o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("isApplicable", (Boolean) o.getIsApplicable() != null ? 1 : 0, 1, 1), 
				checkCardinality("effectiveDate", (AmendmentEffectiveDate) o.getEffectiveDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("partyElection", (List<? extends TerminationCurrencyElection>) o.getPartyElection() == null ? 0 : o.getPartyElection().size(), 0, 3)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TerminationCurrencyAmendment o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TerminationCurrencyAmendment", ValidationResult.ValidationType.CARDINALITY, "TerminationCurrencyAmendment", path, "", res.getError());
				}
				return success("TerminationCurrencyAmendment", ValidationResult.ValidationType.CARDINALITY, "TerminationCurrencyAmendment", path, "");
			})
			.collect(toList());
	}

}
