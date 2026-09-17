package fpml.consolidated.eq.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.eq.shared.NettedSwapBase;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class NettedSwapBaseTypeFormatValidator implements Validator<NettedSwapBase> {

	private List<ComparisonResult> getComparisonResults(NettedSwapBase o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NettedSwapBase o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NettedSwapBase", ValidationResult.ValidationType.TYPE_FORMAT, "NettedSwapBase", path, "", res.getError());
				}
				return success("NettedSwapBase", ValidationResult.ValidationType.TYPE_FORMAT, "NettedSwapBase", path, "");
			})
			.collect(toList());
	}

}
