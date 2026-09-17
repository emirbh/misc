package cdm.legaldocumentation.transaction.additionalterms.validation;

import cdm.legaldocumentation.transaction.additionalterms.Illiquidity;
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

public class IlliquidityTypeFormatValidator implements Validator<Illiquidity> {

	private List<ComparisonResult> getComparisonResults(Illiquidity o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Illiquidity o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Illiquidity", ValidationResult.ValidationType.TYPE_FORMAT, "Illiquidity", path, "", res.getError());
				}
				return success("Illiquidity", ValidationResult.ValidationType.TYPE_FORMAT, "Illiquidity", path, "");
			})
			.collect(toList());
	}

}
