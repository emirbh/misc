package iso20022.auth030.jfsa.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.jfsa.CommonTradeDataReport71__7;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CommonTradeDataReport71__7TypeFormatValidator implements Validator<CommonTradeDataReport71__7> {

	private List<ComparisonResult> getComparisonResults(CommonTradeDataReport71__7 o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommonTradeDataReport71__7 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommonTradeDataReport71__7", ValidationResult.ValidationType.TYPE_FORMAT, "CommonTradeDataReport71__7", path, "", res.getError());
				}
				return success("CommonTradeDataReport71__7", ValidationResult.ValidationType.TYPE_FORMAT, "CommonTradeDataReport71__7", path, "");
			})
			.collect(toList());
	}

}
