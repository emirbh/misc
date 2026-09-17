package cdm.legaldocumentation.transaction.additionalterms.validation;

import cdm.legaldocumentation.transaction.additionalterms.FxBenchmarkObligationDefault;
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

public class FxBenchmarkObligationDefaultTypeFormatValidator implements Validator<FxBenchmarkObligationDefault> {

	private List<ComparisonResult> getComparisonResults(FxBenchmarkObligationDefault o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxBenchmarkObligationDefault o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxBenchmarkObligationDefault", ValidationResult.ValidationType.TYPE_FORMAT, "FxBenchmarkObligationDefault", path, "", res.getError());
				}
				return success("FxBenchmarkObligationDefault", ValidationResult.ValidationType.TYPE_FORMAT, "FxBenchmarkObligationDefault", path, "");
			})
			.collect(toList());
	}

}
