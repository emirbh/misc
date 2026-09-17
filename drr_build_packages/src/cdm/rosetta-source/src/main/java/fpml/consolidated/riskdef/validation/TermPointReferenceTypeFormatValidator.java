package fpml.consolidated.riskdef.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.riskdef.TermPointReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TermPointReferenceTypeFormatValidator implements Validator<TermPointReference> {

	private List<ComparisonResult> getComparisonResults(TermPointReference o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TermPointReference o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TermPointReference", ValidationResult.ValidationType.TYPE_FORMAT, "TermPointReference", path, "", res.getError());
				}
				return success("TermPointReference", ValidationResult.ValidationType.TYPE_FORMAT, "TermPointReference", path, "");
			})
			.collect(toList());
	}

}
