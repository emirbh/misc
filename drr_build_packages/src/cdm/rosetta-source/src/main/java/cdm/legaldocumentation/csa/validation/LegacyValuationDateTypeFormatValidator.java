package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.LegacyValuationDate;
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

public class LegacyValuationDateTypeFormatValidator implements Validator<LegacyValuationDate> {

	private List<ComparisonResult> getComparisonResults(LegacyValuationDate o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LegacyValuationDate o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LegacyValuationDate", ValidationResult.ValidationType.TYPE_FORMAT, "LegacyValuationDate", path, "", res.getError());
				}
				return success("LegacyValuationDate", ValidationResult.ValidationType.TYPE_FORMAT, "LegacyValuationDate", path, "");
			})
			.collect(toList());
	}

}
