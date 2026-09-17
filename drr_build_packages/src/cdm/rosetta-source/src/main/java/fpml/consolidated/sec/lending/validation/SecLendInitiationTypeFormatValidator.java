package fpml.consolidated.sec.lending.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.sec.lending.SecLendInitiation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class SecLendInitiationTypeFormatValidator implements Validator<SecLendInitiation> {

	private List<ComparisonResult> getComparisonResults(SecLendInitiation o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SecLendInitiation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SecLendInitiation", ValidationResult.ValidationType.TYPE_FORMAT, "SecLendInitiation", path, "", res.getError());
				}
				return success("SecLendInitiation", ValidationResult.ValidationType.TYPE_FORMAT, "SecLendInitiation", path, "");
			})
			.collect(toList());
	}

}
