package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CoalPhysicalLeg;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CoalPhysicalLegTypeFormatValidator implements Validator<CoalPhysicalLeg> {

	private List<ComparisonResult> getComparisonResults(CoalPhysicalLeg o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CoalPhysicalLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CoalPhysicalLeg", ValidationResult.ValidationType.TYPE_FORMAT, "CoalPhysicalLeg", path, "", res.getError());
				}
				return success("CoalPhysicalLeg", ValidationResult.ValidationType.TYPE_FORMAT, "CoalPhysicalLeg", path, "");
			})
			.collect(toList());
	}

}
