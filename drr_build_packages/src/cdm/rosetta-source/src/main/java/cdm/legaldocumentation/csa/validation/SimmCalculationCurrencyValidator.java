package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.CalculationCurrencyElection;
import cdm.legaldocumentation.csa.SimmCalculationCurrency;
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

public class SimmCalculationCurrencyValidator implements Validator<SimmCalculationCurrency> {

	private List<ComparisonResult> getComparisonResults(SimmCalculationCurrency o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("partyElection", (List<? extends CalculationCurrencyElection>) o.getPartyElection() == null ? 0 : o.getPartyElection().size(), 2, 2)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SimmCalculationCurrency o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SimmCalculationCurrency", ValidationResult.ValidationType.CARDINALITY, "SimmCalculationCurrency", path, "", res.getError());
				}
				return success("SimmCalculationCurrency", ValidationResult.ValidationType.CARDINALITY, "SimmCalculationCurrency", path, "");
			})
			.collect(toList());
	}

}
