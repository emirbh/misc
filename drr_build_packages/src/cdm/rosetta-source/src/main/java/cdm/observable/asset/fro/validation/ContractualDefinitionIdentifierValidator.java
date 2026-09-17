package cdm.observable.asset.fro.validation;

import cdm.legaldocumentation.common.ContractualDefinitionsEnum;
import cdm.observable.asset.fro.ContractualDefinitionIdentifier;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ContractualDefinitionIdentifierValidator implements Validator<ContractualDefinitionIdentifier> {

	private List<ComparisonResult> getComparisonResults(ContractualDefinitionIdentifier o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("contractualDefinitionType", (ContractualDefinitionsEnum) o.getContractualDefinitionType() != null ? 1 : 0, 1, 1), 
				checkCardinality("contractualDefinitionVersion", (String) o.getContractualDefinitionVersion() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ContractualDefinitionIdentifier o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ContractualDefinitionIdentifier", ValidationResult.ValidationType.CARDINALITY, "ContractualDefinitionIdentifier", path, "", res.getError());
				}
				return success("ContractualDefinitionIdentifier", ValidationResult.ValidationType.CARDINALITY, "ContractualDefinitionIdentifier", path, "");
			})
			.collect(toList());
	}

}
