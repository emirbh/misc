package fpml.consolidated.riskdef.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.riskdef.QuotedAssetSet;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class QuotedAssetSetTypeFormatValidator implements Validator<QuotedAssetSet> {

	private List<ComparisonResult> getComparisonResults(QuotedAssetSet o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, QuotedAssetSet o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("QuotedAssetSet", ValidationResult.ValidationType.TYPE_FORMAT, "QuotedAssetSet", path, "", res.getError());
				}
				return success("QuotedAssetSet", ValidationResult.ValidationType.TYPE_FORMAT, "QuotedAssetSet", path, "");
			})
			.collect(toList());
	}

}
