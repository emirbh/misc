package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.LegacyValuationTime;
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

public class LegacyValuationTimeTypeFormatValidator implements Validator<LegacyValuationTime> {

	private List<ComparisonResult> getComparisonResults(LegacyValuationTime o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LegacyValuationTime o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LegacyValuationTime", ValidationResult.ValidationType.TYPE_FORMAT, "LegacyValuationTime", path, "", res.getError());
				}
				return success("LegacyValuationTime", ValidationResult.ValidationType.TYPE_FORMAT, "LegacyValuationTime", path, "");
			})
			.collect(toList());
	}

}
