package iso20022.auth030.esma.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.esma.CounterpartySpecificData36__2;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CounterpartySpecificData36__2TypeFormatValidator implements Validator<CounterpartySpecificData36__2> {

	private List<ComparisonResult> getComparisonResults(CounterpartySpecificData36__2 o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CounterpartySpecificData36__2 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CounterpartySpecificData36__2", ValidationResult.ValidationType.TYPE_FORMAT, "CounterpartySpecificData36__2", path, "", res.getError());
				}
				return success("CounterpartySpecificData36__2", ValidationResult.ValidationType.TYPE_FORMAT, "CounterpartySpecificData36__2", path, "");
			})
			.collect(toList());
	}

}
