package iso20022.auth030.asic.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.asic.Counterparty45__3;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class Counterparty45__3TypeFormatValidator implements Validator<Counterparty45__3> {

	private List<ComparisonResult> getComparisonResults(Counterparty45__3 o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Counterparty45__3 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Counterparty45__3", ValidationResult.ValidationType.TYPE_FORMAT, "Counterparty45__3", path, "", res.getError());
				}
				return success("Counterparty45__3", ValidationResult.ValidationType.TYPE_FORMAT, "Counterparty45__3", path, "");
			})
			.collect(toList());
	}

}
