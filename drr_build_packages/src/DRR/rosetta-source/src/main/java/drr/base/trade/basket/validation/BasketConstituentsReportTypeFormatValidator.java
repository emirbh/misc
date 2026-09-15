package drr.base.trade.basket.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.trade.basket.BasketConstituentsReport;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class BasketConstituentsReportTypeFormatValidator implements Validator<BasketConstituentsReport> {

	private List<ComparisonResult> getComparisonResults(BasketConstituentsReport o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("identifier", o.getIdentifier(), 1, of(210), empty()), 
				checkNumber("numberOfUnits", o.getNumberOfUnits(), of(18), of(13), empty(), empty()), 
				checkString("unitOfMeasure", o.getUnitOfMeasure(), 1, of(4), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, BasketConstituentsReport o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("BasketConstituentsReport", ValidationResult.ValidationType.TYPE_FORMAT, "BasketConstituentsReport", path, "", res.getError());
				}
				return success("BasketConstituentsReport", ValidationResult.ValidationType.TYPE_FORMAT, "BasketConstituentsReport", path, "");
			})
			.collect(toList());
	}

}
