package cdm.observable.asset.validation;

import cdm.observable.asset.InflationIndex;
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

public class InflationIndexTypeFormatValidator implements Validator<InflationIndex> {

	private List<ComparisonResult> getComparisonResults(InflationIndex o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, InflationIndex o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("InflationIndex", ValidationResult.ValidationType.TYPE_FORMAT, "InflationIndex", path, "", res.getError());
				}
				return success("InflationIndex", ValidationResult.ValidationType.TYPE_FORMAT, "InflationIndex", path, "");
			})
			.collect(toList());
	}

}
