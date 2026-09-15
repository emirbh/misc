package iso20022.auth030.jfsa.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.jfsa.NotionalQuantity9__2;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class NotionalQuantity9__2TypeFormatValidator implements Validator<NotionalQuantity9__2> {

	private List<ComparisonResult> getComparisonResults(NotionalQuantity9__2 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("ttlQty", o.getTtlQty(), of(25), of(5), empty(), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NotionalQuantity9__2 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NotionalQuantity9__2", ValidationResult.ValidationType.TYPE_FORMAT, "NotionalQuantity9__2", path, "", res.getError());
				}
				return success("NotionalQuantity9__2", ValidationResult.ValidationType.TYPE_FORMAT, "NotionalQuantity9__2", path, "");
			})
			.collect(toList());
	}

}
