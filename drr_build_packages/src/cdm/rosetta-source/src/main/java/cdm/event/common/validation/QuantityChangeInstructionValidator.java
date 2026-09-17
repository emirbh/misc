package cdm.event.common.validation;

import cdm.base.math.QuantityChangeDirectionEnum;
import cdm.event.common.QuantityChangeInstruction;
import cdm.observable.asset.PriceQuantity;
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

public class QuantityChangeInstructionValidator implements Validator<QuantityChangeInstruction> {

	private List<ComparisonResult> getComparisonResults(QuantityChangeInstruction o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("change", (List<? extends PriceQuantity>) o.getChange() == null ? 0 : o.getChange().size(), 1, 0), 
				checkCardinality("direction", (QuantityChangeDirectionEnum) o.getDirection() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, QuantityChangeInstruction o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("QuantityChangeInstruction", ValidationResult.ValidationType.CARDINALITY, "QuantityChangeInstruction", path, "", res.getError());
				}
				return success("QuantityChangeInstruction", ValidationResult.ValidationType.CARDINALITY, "QuantityChangeInstruction", path, "");
			})
			.collect(toList());
	}

}
