package iso20022.auth108.fca.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth108.fca.MarginCollateralReport4__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class MarginCollateralReport4__1TypeFormatValidator implements Validator<MarginCollateralReport4__1> {

	private List<ComparisonResult> getComparisonResults(MarginCollateralReport4__1 o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MarginCollateralReport4__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MarginCollateralReport4__1", ValidationResult.ValidationType.TYPE_FORMAT, "MarginCollateralReport4__1", path, "", res.getError());
				}
				return success("MarginCollateralReport4__1", ValidationResult.ValidationType.TYPE_FORMAT, "MarginCollateralReport4__1", path, "");
			})
			.collect(toList());
	}

}
