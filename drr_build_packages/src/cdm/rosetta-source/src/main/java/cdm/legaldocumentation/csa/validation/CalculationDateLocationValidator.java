package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.CalculationDateLocation;
import cdm.legaldocumentation.csa.CalculationDateLocationElection;
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

public class CalculationDateLocationValidator implements Validator<CalculationDateLocation> {

	private List<ComparisonResult> getComparisonResults(CalculationDateLocation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("partyElection", (List<? extends CalculationDateLocationElection>) o.getPartyElection() == null ? 0 : o.getPartyElection().size(), 2, 2)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CalculationDateLocation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CalculationDateLocation", ValidationResult.ValidationType.CARDINALITY, "CalculationDateLocation", path, "", res.getError());
				}
				return success("CalculationDateLocation", ValidationResult.ValidationType.CARDINALITY, "CalculationDateLocation", path, "");
			})
			.collect(toList());
	}

}
