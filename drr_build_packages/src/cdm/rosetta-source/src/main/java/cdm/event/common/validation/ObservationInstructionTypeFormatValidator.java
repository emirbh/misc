package cdm.event.common.validation;

import cdm.event.common.ObservationInstruction;
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

public class ObservationInstructionTypeFormatValidator implements Validator<ObservationInstruction> {

	private List<ComparisonResult> getComparisonResults(ObservationInstruction o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ObservationInstruction o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ObservationInstruction", ValidationResult.ValidationType.TYPE_FORMAT, "ObservationInstruction", path, "", res.getError());
				}
				return success("ObservationInstruction", ValidationResult.ValidationType.TYPE_FORMAT, "ObservationInstruction", path, "");
			})
			.collect(toList());
	}

}
