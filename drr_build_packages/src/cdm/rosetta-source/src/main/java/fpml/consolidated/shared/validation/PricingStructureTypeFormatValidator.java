package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.PricingStructure;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PricingStructureTypeFormatValidator implements Validator<PricingStructure> {

	private List<ComparisonResult> getComparisonResults(PricingStructure o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PricingStructure o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PricingStructure", ValidationResult.ValidationType.TYPE_FORMAT, "PricingStructure", path, "", res.getError());
				}
				return success("PricingStructure", ValidationResult.ValidationType.TYPE_FORMAT, "PricingStructure", path, "");
			})
			.collect(toList());
	}

}
