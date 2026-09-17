package cdm.regulation.validation;

import cdm.regulation.Tx;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TxTypeFormatValidator implements Validator<Tx> {

	private List<ComparisonResult> getComparisonResults(Tx o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Tx o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Tx", ValidationResult.ValidationType.TYPE_FORMAT, "Tx", path, "", res.getError());
				}
				return success("Tx", ValidationResult.ValidationType.TYPE_FORMAT, "Tx", path, "");
			})
			.collect(toList());
	}

}
