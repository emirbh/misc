package iso20022.auth108.hkma.dtcc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth108.hkma.dtcc.MarginPortfolio4;
import iso20022.auth108.hkma.dtcc.PortfolioCode5Choice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class MarginPortfolio4Validator implements Validator<MarginPortfolio4> {

	private List<ComparisonResult> getComparisonResults(MarginPortfolio4 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("initlMrgnPrtflCd", (PortfolioCode5Choice) o.getInitlMrgnPrtflCd() != null ? 1 : 0, 0, 1), 
				checkCardinality("vartnMrgnPrtflCd", (PortfolioCode5Choice) o.getVartnMrgnPrtflCd() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MarginPortfolio4 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MarginPortfolio4", ValidationResult.ValidationType.CARDINALITY, "MarginPortfolio4", path, "", res.getError());
				}
				return success("MarginPortfolio4", ValidationResult.ValidationType.CARDINALITY, "MarginPortfolio4", path, "");
			})
			.collect(toList());
	}

}
