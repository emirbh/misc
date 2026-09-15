package fpml.consolidated.sec.lending.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.sec.lending.SecLendCollateralProvisions;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class SecLendCollateralProvisionsTypeFormatValidator implements Validator<SecLendCollateralProvisions> {

	private List<ComparisonResult> getComparisonResults(SecLendCollateralProvisions o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SecLendCollateralProvisions o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SecLendCollateralProvisions", ValidationResult.ValidationType.TYPE_FORMAT, "SecLendCollateralProvisions", path, "", res.getError());
				}
				return success("SecLendCollateralProvisions", ValidationResult.ValidationType.TYPE_FORMAT, "SecLendCollateralProvisions", path, "");
			})
			.collect(toList());
	}

}
