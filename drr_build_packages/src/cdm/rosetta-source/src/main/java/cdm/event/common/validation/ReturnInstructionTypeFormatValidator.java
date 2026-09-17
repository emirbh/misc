package cdm.event.common.validation;

import cdm.event.common.ReturnInstruction;
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

public class ReturnInstructionTypeFormatValidator implements Validator<ReturnInstruction> {

	private List<ComparisonResult> getComparisonResults(ReturnInstruction o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReturnInstruction o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReturnInstruction", ValidationResult.ValidationType.TYPE_FORMAT, "ReturnInstruction", path, "", res.getError());
				}
				return success("ReturnInstruction", ValidationResult.ValidationType.TYPE_FORMAT, "ReturnInstruction", path, "");
			})
			.collect(toList());
	}

}
