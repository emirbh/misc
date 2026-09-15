package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityValuationDates;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class CommodityValuationDatesTypeFormatValidator implements Validator<CommodityValuationDates> {

	private List<ComparisonResult> getComparisonResults(CommodityValuationDates o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("dayCount", o.getDayCount(), empty(), of(0), of(new BigDecimal("1")), empty()), 
				checkNumber("dayNumber", o.getDayNumber(), empty(), of(0), empty(), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityValuationDates o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityValuationDates", ValidationResult.ValidationType.TYPE_FORMAT, "CommodityValuationDates", path, "", res.getError());
				}
				return success("CommodityValuationDates", ValidationResult.ValidationType.TYPE_FORMAT, "CommodityValuationDates", path, "");
			})
			.collect(toList());
	}

}
