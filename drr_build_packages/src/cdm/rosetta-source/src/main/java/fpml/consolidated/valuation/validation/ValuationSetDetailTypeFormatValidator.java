package fpml.consolidated.valuation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.valuation.ValuationSetDetail;
import java.util.List;
import java.util.regex.Pattern;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class ValuationSetDetailTypeFormatValidator implements Validator<ValuationSetDetail> {

	private List<ComparisonResult> getComparisonResults(ValuationSetDetail o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("valuationSetDetailScheme", o.getValuationSetDetailScheme(), 1, empty(), of(Pattern.compile("\\w+:(\\/?\\/?)[^\\s]+")))
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ValuationSetDetail o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ValuationSetDetail", ValidationResult.ValidationType.TYPE_FORMAT, "ValuationSetDetail", path, "", res.getError());
				}
				return success("ValuationSetDetail", ValidationResult.ValidationType.TYPE_FORMAT, "ValuationSetDetail", path, "");
			})
			.collect(toList());
	}

}
