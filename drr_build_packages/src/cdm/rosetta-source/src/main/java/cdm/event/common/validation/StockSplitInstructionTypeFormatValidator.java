package cdm.event.common.validation;

import cdm.event.common.StockSplitInstruction;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class StockSplitInstructionTypeFormatValidator implements Validator<StockSplitInstruction> {

	private List<ComparisonResult> getComparisonResults(StockSplitInstruction o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, StockSplitInstruction o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("StockSplitInstruction", ValidationResult.ValidationType.TYPE_FORMAT, "StockSplitInstruction", path, "", res.getError());
				}
				return success("StockSplitInstruction", ValidationResult.ValidationType.TYPE_FORMAT, "StockSplitInstruction", path, "");
			})
			.collect(toList());
	}

}
