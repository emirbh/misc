package cdm.observable.asset.validation;

import cdm.observable.asset.EquityIndex;
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

public class EquityIndexTypeFormatValidator implements Validator<EquityIndex> {

	private List<ComparisonResult> getComparisonResults(EquityIndex o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EquityIndex o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EquityIndex", ValidationResult.ValidationType.TYPE_FORMAT, "EquityIndex", path, "", res.getError());
				}
				return success("EquityIndex", ValidationResult.ValidationType.TYPE_FORMAT, "EquityIndex", path, "");
			})
			.collect(toList());
	}

}
