package fpml.consolidated.doc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.TradeDifference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.stream.Collectors.toList;

public class TradeDifferenceTypeFormatValidator implements Validator<TradeDifference> {

	private List<ComparisonResult> getComparisonResults(TradeDifference o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("element", o.getElement(), 1, empty(), empty()), 
				checkString("basePath", o.getBasePath(), 1, empty(), empty()), 
				checkString("baseValue", o.getBaseValue(), 1, empty(), empty()), 
				checkString("otherPath", o.getOtherPath(), 1, empty(), empty()), 
				checkString("otherValue", o.getOtherValue(), 1, empty(), empty()), 
				checkString("missingElement", o.getMissingElement(), 1, empty(), empty()), 
				checkString("extraElement", o.getExtraElement(), 1, empty(), empty()), 
				checkString("message", o.getMessage(), 1, empty(), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeDifference o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeDifference", ValidationResult.ValidationType.TYPE_FORMAT, "TradeDifference", path, "", res.getError());
				}
				return success("TradeDifference", ValidationResult.ValidationType.TYPE_FORMAT, "TradeDifference", path, "");
			})
			.collect(toList());
	}

}
