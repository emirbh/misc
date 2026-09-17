package cdm.observable.asset.fro.validation;

import cdm.observable.asset.fro.ContractualDefinition;
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

public class ContractualDefinitionTypeFormatValidator implements Validator<ContractualDefinition> {

	private List<ComparisonResult> getComparisonResults(ContractualDefinition o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ContractualDefinition o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ContractualDefinition", ValidationResult.ValidationType.TYPE_FORMAT, "ContractualDefinition", path, "", res.getError());
				}
				return success("ContractualDefinition", ValidationResult.ValidationType.TYPE_FORMAT, "ContractualDefinition", path, "");
			})
			.collect(toList());
	}

}
