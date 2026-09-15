package fpml.consolidated.msg.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.msg.PortfolioReferenceBase;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PortfolioReferenceBaseTypeFormatValidator implements Validator<PortfolioReferenceBase> {

	private List<ComparisonResult> getComparisonResults(PortfolioReferenceBase o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PortfolioReferenceBase o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PortfolioReferenceBase", ValidationResult.ValidationType.TYPE_FORMAT, "PortfolioReferenceBase", path, "", res.getError());
				}
				return success("PortfolioReferenceBase", ValidationResult.ValidationType.TYPE_FORMAT, "PortfolioReferenceBase", path, "");
			})
			.collect(toList());
	}

}
