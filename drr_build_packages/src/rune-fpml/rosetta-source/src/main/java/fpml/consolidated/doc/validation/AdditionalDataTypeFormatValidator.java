package fpml.consolidated.doc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.AdditionalData;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.stream.Collectors.toList;

public class AdditionalDataTypeFormatValidator implements Validator<AdditionalData> {

	private List<ComparisonResult> getComparisonResults(AdditionalData o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("string", o.getString(), 1, empty(), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AdditionalData o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AdditionalData", ValidationResult.ValidationType.TYPE_FORMAT, "AdditionalData", path, "", res.getError());
				}
				return success("AdditionalData", ValidationResult.ValidationType.TYPE_FORMAT, "AdditionalData", path, "");
			})
			.collect(toList());
	}

}
