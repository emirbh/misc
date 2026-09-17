package fpml.consolidated.fx.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.NoFaultTermination;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class NoFaultTerminationValidator implements Validator<NoFaultTermination> {

	private List<ComparisonResult> getComparisonResults(NoFaultTermination o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NoFaultTermination o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NoFaultTermination", ValidationResult.ValidationType.CARDINALITY, "NoFaultTermination", path, "", res.getError());
				}
				return success("NoFaultTermination", ValidationResult.ValidationType.CARDINALITY, "NoFaultTermination", path, "");
			})
			.collect(toList());
	}

}
