package cdm.base.staticdata.asset.common.validation;

import cdm.base.staticdata.asset.common.ListedDerivative;
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

public class ListedDerivativeTypeFormatValidator implements Validator<ListedDerivative> {

	private List<ComparisonResult> getComparisonResults(ListedDerivative o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ListedDerivative o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ListedDerivative", ValidationResult.ValidationType.TYPE_FORMAT, "ListedDerivative", path, "", res.getError());
				}
				return success("ListedDerivative", ValidationResult.ValidationType.TYPE_FORMAT, "ListedDerivative", path, "");
			})
			.collect(toList());
	}

}
