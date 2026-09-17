package cdm.event.common.validation;

import cdm.event.common.ClosedState;
import cdm.event.common.State;
import cdm.event.position.PositionStatusEnum;
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

public class StateValidator implements Validator<State> {

	private List<ComparisonResult> getComparisonResults(State o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("closedState", (ClosedState) o.getClosedState() != null ? 1 : 0, 0, 1), 
				checkCardinality("positionState", (PositionStatusEnum) o.getPositionState() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, State o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("State", ValidationResult.ValidationType.CARDINALITY, "State", path, "", res.getError());
				}
				return success("State", ValidationResult.ValidationType.CARDINALITY, "State", path, "");
			})
			.collect(toList());
	}

}
