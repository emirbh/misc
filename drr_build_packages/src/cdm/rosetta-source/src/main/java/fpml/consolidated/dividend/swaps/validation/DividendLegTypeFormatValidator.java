package fpml.consolidated.dividend.swaps.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.dividend.swaps.DividendLeg;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class DividendLegTypeFormatValidator implements Validator<DividendLeg> {

	private List<ComparisonResult> getComparisonResults(DividendLeg o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DividendLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DividendLeg", ValidationResult.ValidationType.TYPE_FORMAT, "DividendLeg", path, "", res.getError());
				}
				return success("DividendLeg", ValidationResult.ValidationType.TYPE_FORMAT, "DividendLeg", path, "");
			})
			.collect(toList());
	}

}
