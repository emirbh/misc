package fpml.consolidated.msg.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.msg.PortfolioReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class PortfolioReferenceTypeFormatValidator implements Validator<PortfolioReference> {

	private List<ComparisonResult> getComparisonResults(PortfolioReference o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("sequenceNumber", o.getSequenceNumber(), empty(), of(0), empty(), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PortfolioReference o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PortfolioReference", ValidationResult.ValidationType.TYPE_FORMAT, "PortfolioReference", path, "", res.getError());
				}
				return success("PortfolioReference", ValidationResult.ValidationType.TYPE_FORMAT, "PortfolioReference", path, "");
			})
			.collect(toList());
	}

}
