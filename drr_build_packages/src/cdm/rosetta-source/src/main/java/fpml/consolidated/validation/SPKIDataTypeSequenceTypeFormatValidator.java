package fpml.consolidated.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.SPKIDataTypeSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class SPKIDataTypeSequenceTypeFormatValidator implements Validator<SPKIDataTypeSequence> {

	private List<ComparisonResult> getComparisonResults(SPKIDataTypeSequence o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SPKIDataTypeSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SPKIDataTypeSequence", ValidationResult.ValidationType.TYPE_FORMAT, "SPKIDataTypeSequence", path, "", res.getError());
				}
				return success("SPKIDataTypeSequence", ValidationResult.ValidationType.TYPE_FORMAT, "SPKIDataTypeSequence", path, "");
			})
			.collect(toList());
	}

}
