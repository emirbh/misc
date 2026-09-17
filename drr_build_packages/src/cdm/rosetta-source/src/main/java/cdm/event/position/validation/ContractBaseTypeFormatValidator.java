package cdm.event.position.validation;

import cdm.event.position.ContractBase;
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

public class ContractBaseTypeFormatValidator implements Validator<ContractBase> {

	private List<ComparisonResult> getComparisonResults(ContractBase o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ContractBase o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ContractBase", ValidationResult.ValidationType.TYPE_FORMAT, "ContractBase", path, "", res.getError());
				}
				return success("ContractBase", ValidationResult.ValidationType.TYPE_FORMAT, "ContractBase", path, "");
			})
			.collect(toList());
	}

}
