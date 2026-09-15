package iso20022.auth108.iso.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth108.iso.MarginPortfolio3;
import iso20022.auth108.iso.PortfolioCode5Choice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class MarginPortfolio3Validator implements Validator<MarginPortfolio3> {

	private List<ComparisonResult> getComparisonResults(MarginPortfolio3 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("initlMrgnPrtflCd", (PortfolioCode5Choice) o.getInitlMrgnPrtflCd() != null ? 1 : 0, 1, 1), 
				checkCardinality("vartnMrgnPrtflCd", (PortfolioCode5Choice) o.getVartnMrgnPrtflCd() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MarginPortfolio3 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MarginPortfolio3", ValidationResult.ValidationType.CARDINALITY, "MarginPortfolio3", path, "", res.getError());
				}
				return success("MarginPortfolio3", ValidationResult.ValidationType.CARDINALITY, "MarginPortfolio3", path, "");
			})
			.collect(toList());
	}

}
