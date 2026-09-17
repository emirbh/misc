package cdm.observable.asset.fro.validation;

import cdm.base.staticdata.identifier.Identifier;
import cdm.observable.asset.fro.ContractualDefinitionIdentifier;
import cdm.observable.asset.fro.FloatingRateIndexMap;
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

public class FloatingRateIndexMapValidator implements Validator<FloatingRateIndexMap> {

	private List<ComparisonResult> getComparisonResults(FloatingRateIndexMap o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("contractualDefinitionIdentifier", (ContractualDefinitionIdentifier) o.getContractualDefinitionIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("identifier", (Identifier) o.getIdentifier() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FloatingRateIndexMap o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FloatingRateIndexMap", ValidationResult.ValidationType.CARDINALITY, "FloatingRateIndexMap", path, "", res.getError());
				}
				return success("FloatingRateIndexMap", ValidationResult.ValidationType.CARDINALITY, "FloatingRateIndexMap", path, "");
			})
			.collect(toList());
	}

}
