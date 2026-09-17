package fpml.consolidated.ird.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.ird.CashSettlement;
import fpml.consolidated.ird.OptionalEarlyTermination;
import fpml.consolidated.ird.OptionalEarlyTerminationAdjustedDates;
import fpml.consolidated.ird.SinglePartyOption;
import fpml.consolidated.shared.CalculationAgent;
import fpml.consolidated.shared.Exercise;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class OptionalEarlyTerminationValidator implements Validator<OptionalEarlyTermination> {

	private List<ComparisonResult> getComparisonResults(OptionalEarlyTermination o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("singlePartyOption", (SinglePartyOption) o.getSinglePartyOption() != null ? 1 : 0, 0, 1), 
				checkCardinality("exercise", (Exercise) o.getExercise() != null ? 1 : 0, 0, 1), 
				checkCardinality("followUpConfirmation", (Boolean) o.getFollowUpConfirmation() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculationAgent", (CalculationAgent) o.getCalculationAgent() != null ? 1 : 0, 0, 1), 
				checkCardinality("cashSettlement", (CashSettlement) o.getCashSettlement() != null ? 1 : 0, 0, 1), 
				checkCardinality("optionalEarlyTerminationAdjustedDates", (OptionalEarlyTerminationAdjustedDates) o.getOptionalEarlyTerminationAdjustedDates() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OptionalEarlyTermination o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OptionalEarlyTermination", ValidationResult.ValidationType.CARDINALITY, "OptionalEarlyTermination", path, "", res.getError());
				}
				return success("OptionalEarlyTermination", ValidationResult.ValidationType.CARDINALITY, "OptionalEarlyTermination", path, "");
			})
			.collect(toList());
	}

}
