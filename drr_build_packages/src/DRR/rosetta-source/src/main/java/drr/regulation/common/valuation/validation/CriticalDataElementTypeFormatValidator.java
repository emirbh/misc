package drr.regulation.common.valuation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.valuation.CriticalDataElement;
import java.util.List;
import java.util.regex.Pattern;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class CriticalDataElementTypeFormatValidator implements Validator<CriticalDataElement> {

	private List<ComparisonResult> getComparisonResults(CriticalDataElement o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("counterparty1", o.getCounterparty1(), 0, empty(), of(Pattern.compile("[A-Z0-9]{18,18}[0-9]{2,2}"))), 
				checkString("counterparty2", o.getCounterparty2(), 20, of(72), of(Pattern.compile("[a-zA-Z0-9]{1,72}"))), 
				checkNumber("valuationAmount", o.getValuationAmount(), of(25), of(5), empty(), empty()), 
				checkNumber("delta", o.getDelta(), of(25), of(5), empty(), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CriticalDataElement o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CriticalDataElement", ValidationResult.ValidationType.TYPE_FORMAT, "CriticalDataElement", path, "", res.getError());
				}
				return success("CriticalDataElement", ValidationResult.ValidationType.TYPE_FORMAT, "CriticalDataElement", path, "");
			})
			.collect(toList());
	}

}
