package drr.enrichment.lei.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.enrichment.lei.LeiData;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LeiDataTypeFormatValidator implements Validator<LeiData> {

	private List<ComparisonResult> getComparisonResults(LeiData o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LeiData o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LeiData", ValidationResult.ValidationType.TYPE_FORMAT, "LeiData", path, "", res.getError());
				}
				return success("LeiData", ValidationResult.ValidationType.TYPE_FORMAT, "LeiData", path, "");
			})
			.collect(toList());
	}

}
