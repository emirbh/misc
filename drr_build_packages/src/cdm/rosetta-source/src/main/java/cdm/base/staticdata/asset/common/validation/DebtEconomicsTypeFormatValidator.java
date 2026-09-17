package cdm.base.staticdata.asset.common.validation;

import cdm.base.staticdata.asset.common.DebtEconomics;
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

public class DebtEconomicsTypeFormatValidator implements Validator<DebtEconomics> {

	private List<ComparisonResult> getComparisonResults(DebtEconomics o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DebtEconomics o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DebtEconomics", ValidationResult.ValidationType.TYPE_FORMAT, "DebtEconomics", path, "", res.getError());
				}
				return success("DebtEconomics", ValidationResult.ValidationType.TYPE_FORMAT, "DebtEconomics", path, "");
			})
			.collect(toList());
	}

}
