package cdm.legaldocumentation.master.isda.validation;

import cdm.legaldocumentation.master.isda.PartyOptionTerminationCurrency;
import cdm.legaldocumentation.master.isda.TerminationCurrency;
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

public class TerminationCurrencyValidator implements Validator<TerminationCurrency> {

	private List<ComparisonResult> getComparisonResults(TerminationCurrency o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("statedTerminationCurrency", (TerminationCurrencySelection) o.getStatedTerminationCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("partyOptionTerminationCurrency", (PartyOptionTerminationCurrency) o.getPartyOptionTerminationCurrency() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TerminationCurrency o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TerminationCurrency", ValidationResult.ValidationType.CARDINALITY, "TerminationCurrency", path, "", res.getError());
				}
				return success("TerminationCurrency", ValidationResult.ValidationType.CARDINALITY, "TerminationCurrency", path, "");
			})
			.collect(toList());
	}

}
