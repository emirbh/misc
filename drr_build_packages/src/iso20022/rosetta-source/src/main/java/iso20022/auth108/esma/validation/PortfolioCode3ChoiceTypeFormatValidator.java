package iso20022.auth108.esma.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth108.esma.PortfolioCode3Choice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class PortfolioCode3ChoiceTypeFormatValidator implements Validator<PortfolioCode3Choice> {

	private List<ComparisonResult> getComparisonResults(PortfolioCode3Choice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("cd", o.getCd(), 1, of(52), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PortfolioCode3Choice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PortfolioCode3Choice", ValidationResult.ValidationType.TYPE_FORMAT, "PortfolioCode3Choice", path, "", res.getError());
				}
				return success("PortfolioCode3Choice", ValidationResult.ValidationType.TYPE_FORMAT, "PortfolioCode3Choice", path, "");
			})
			.collect(toList());
	}

}
