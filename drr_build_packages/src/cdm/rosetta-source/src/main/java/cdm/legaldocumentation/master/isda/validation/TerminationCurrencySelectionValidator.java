package cdm.legaldocumentation.master.isda.validation;

import cdm.legaldocumentation.master.isda.PartyTerminationCurrencySelection;
import cdm.legaldocumentation.master.isda.TerminationCurrencySelection;
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

public class TerminationCurrencySelectionValidator implements Validator<TerminationCurrencySelection> {

	private List<ComparisonResult> getComparisonResults(TerminationCurrencySelection o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("statedCurrency", (String) o.getStatedCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("fallbackCurrency", (String) o.getFallbackCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("partyElection", (List<? extends PartyTerminationCurrencySelection>) o.getPartyElection() == null ? 0 : o.getPartyElection().size(), 0, 2), 
				checkCardinality("bothAffected", (String) o.getBothAffected() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TerminationCurrencySelection o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TerminationCurrencySelection", ValidationResult.ValidationType.CARDINALITY, "TerminationCurrencySelection", path, "", res.getError());
				}
				return success("TerminationCurrencySelection", ValidationResult.ValidationType.CARDINALITY, "TerminationCurrencySelection", path, "");
			})
			.collect(toList());
	}

}
