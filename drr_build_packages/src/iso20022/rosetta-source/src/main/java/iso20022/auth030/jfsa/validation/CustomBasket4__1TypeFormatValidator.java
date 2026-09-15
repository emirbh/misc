package iso20022.auth030.jfsa.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.jfsa.CustomBasket4__1;
import java.util.List;
import java.util.regex.Pattern;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class CustomBasket4__1TypeFormatValidator implements Validator<CustomBasket4__1> {

	private List<ComparisonResult> getComparisonResults(CustomBasket4__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("strr", o.getStrr(), 0, empty(), of(Pattern.compile("[A-Z0-9]{18,18}[0-9]{2,2}"))), 
				checkString("id", o.getId(), 1, of(52), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CustomBasket4__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CustomBasket4__1", ValidationResult.ValidationType.TYPE_FORMAT, "CustomBasket4__1", path, "", res.getError());
				}
				return success("CustomBasket4__1", ValidationResult.ValidationType.TYPE_FORMAT, "CustomBasket4__1", path, "");
			})
			.collect(toList());
	}

}
