package cdm.legaldocumentation.common.validation;

import cdm.legaldocumentation.common.ContractualMatrix;
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

public class ContractualMatrixTypeFormatValidator implements Validator<ContractualMatrix> {

	private List<ComparisonResult> getComparisonResults(ContractualMatrix o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ContractualMatrix o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ContractualMatrix", ValidationResult.ValidationType.TYPE_FORMAT, "ContractualMatrix", path, "", res.getError());
				}
				return success("ContractualMatrix", ValidationResult.ValidationType.TYPE_FORMAT, "ContractualMatrix", path, "");
			})
			.collect(toList());
	}

}
