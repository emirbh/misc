package cdm.base.staticdata.asset.credit.validation;

import cdm.base.staticdata.asset.credit.Obligations;
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

public class ObligationsTypeFormatValidator implements Validator<Obligations> {

	private List<ComparisonResult> getComparisonResults(Obligations o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Obligations o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Obligations", ValidationResult.ValidationType.TYPE_FORMAT, "Obligations", path, "", res.getError());
				}
				return success("Obligations", ValidationResult.ValidationType.TYPE_FORMAT, "Obligations", path, "");
			})
			.collect(toList());
	}

}
