package iso20022.auth108.asic.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth108.asic.CollateralPortfolioCode6Choice__1;
import iso20022.auth108.asic.CollateralisationType3Code__1;
import iso20022.auth108.asic.MarginCollateralReport5__1;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class MarginCollateralReport5__1Validator implements Validator<MarginCollateralReport5__1> {

	private List<ComparisonResult> getComparisonResults(MarginCollateralReport5__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("collPrtflCd", (CollateralPortfolioCode6Choice__1) o.getCollPrtflCd() != null ? 1 : 0, 1, 1), 
				checkCardinality("collstnCtgy", (CollateralisationType3Code__1) o.getCollstnCtgy() != null ? 1 : 0, 1, 1), 
				checkCardinality("tmStmp", (ZonedDateTime) o.getTmStmp() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MarginCollateralReport5__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MarginCollateralReport5__1", ValidationResult.ValidationType.CARDINALITY, "MarginCollateralReport5__1", path, "", res.getError());
				}
				return success("MarginCollateralReport5__1", ValidationResult.ValidationType.CARDINALITY, "MarginCollateralReport5__1", path, "");
			})
			.collect(toList());
	}

}
