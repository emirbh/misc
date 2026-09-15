package iso20022.auth030.fca.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.fca.CommonTradeDataReport69__3;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CommonTradeDataReport69__3TypeFormatValidator implements Validator<CommonTradeDataReport69__3> {

	private List<ComparisonResult> getComparisonResults(CommonTradeDataReport69__3 o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommonTradeDataReport69__3 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommonTradeDataReport69__3", ValidationResult.ValidationType.TYPE_FORMAT, "CommonTradeDataReport69__3", path, "", res.getError());
				}
				return success("CommonTradeDataReport69__3", ValidationResult.ValidationType.TYPE_FORMAT, "CommonTradeDataReport69__3", path, "");
			})
			.collect(toList());
	}

}
