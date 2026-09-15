package iso20022.auth030.jfsa.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.jfsa.CommonTradeDataReport71__8;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CommonTradeDataReport71__8TypeFormatValidator implements Validator<CommonTradeDataReport71__8> {

	private List<ComparisonResult> getComparisonResults(CommonTradeDataReport71__8 o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommonTradeDataReport71__8 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommonTradeDataReport71__8", ValidationResult.ValidationType.TYPE_FORMAT, "CommonTradeDataReport71__8", path, "", res.getError());
				}
				return success("CommonTradeDataReport71__8", ValidationResult.ValidationType.TYPE_FORMAT, "CommonTradeDataReport71__8", path, "");
			})
			.collect(toList());
	}

}
