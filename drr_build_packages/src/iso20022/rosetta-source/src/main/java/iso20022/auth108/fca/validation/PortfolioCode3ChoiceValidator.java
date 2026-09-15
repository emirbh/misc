package iso20022.auth108.fca.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth108.fca.NotApplicable1Code;
import iso20022.auth108.fca.PortfolioCode3Choice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PortfolioCode3ChoiceValidator implements Validator<PortfolioCode3Choice> {

	private List<ComparisonResult> getComparisonResults(PortfolioCode3Choice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("cd", (String) o.getCd() != null ? 1 : 0, 0, 1), 
				checkCardinality("noPrtfl", (NotApplicable1Code) o.getNoPrtfl() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PortfolioCode3Choice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PortfolioCode3Choice", ValidationResult.ValidationType.CARDINALITY, "PortfolioCode3Choice", path, "", res.getError());
				}
				return success("PortfolioCode3Choice", ValidationResult.ValidationType.CARDINALITY, "PortfolioCode3Choice", path, "");
			})
			.collect(toList());
	}

}
