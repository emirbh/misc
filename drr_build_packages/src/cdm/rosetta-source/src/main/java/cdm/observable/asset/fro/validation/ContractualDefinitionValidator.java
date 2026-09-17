package cdm.observable.asset.fro.validation;

import cdm.base.staticdata.identifier.Identifier;
import cdm.observable.asset.fro.ContractualDefinition;
import cdm.observable.asset.fro.ContractualDefinitionIdentifier;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ContractualDefinitionValidator implements Validator<ContractualDefinition> {

	private List<ComparisonResult> getComparisonResults(ContractualDefinition o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("identifier", (Identifier) o.getIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("contractualDefinitionIdentifier", (ContractualDefinitionIdentifier) o.getContractualDefinitionIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("publicationDate", (Date) o.getPublicationDate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ContractualDefinition o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ContractualDefinition", ValidationResult.ValidationType.CARDINALITY, "ContractualDefinition", path, "", res.getError());
				}
				return success("ContractualDefinition", ValidationResult.ValidationType.CARDINALITY, "ContractualDefinition", path, "");
			})
			.collect(toList());
	}

}
