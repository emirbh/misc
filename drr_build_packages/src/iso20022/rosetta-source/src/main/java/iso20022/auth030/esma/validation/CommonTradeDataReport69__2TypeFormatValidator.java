package iso20022.auth030.esma.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.esma.CommonTradeDataReport69__2;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CommonTradeDataReport69__2TypeFormatValidator implements Validator<CommonTradeDataReport69__2> {

	private List<ComparisonResult> getComparisonResults(CommonTradeDataReport69__2 o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommonTradeDataReport69__2 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommonTradeDataReport69__2", ValidationResult.ValidationType.TYPE_FORMAT, "CommonTradeDataReport69__2", path, "", res.getError());
				}
				return success("CommonTradeDataReport69__2", ValidationResult.ValidationType.TYPE_FORMAT, "CommonTradeDataReport69__2", path, "");
			})
			.collect(toList());
	}

}
