package cdm.event.position.validation;

import cdm.event.common.metafields.ReferenceWithMetaContractDetails;
import cdm.event.common.metafields.ReferenceWithMetaExecutionDetails;
import cdm.event.position.ContractBase;
import cdm.product.collateral.metafields.ReferenceWithMetaCollateral;
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

public class ContractBaseValidator implements Validator<ContractBase> {

	private List<ComparisonResult> getComparisonResults(ContractBase o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("contractDetails", (ReferenceWithMetaContractDetails) o.getContractDetails() != null ? 1 : 0, 0, 1), 
				checkCardinality("executionDetails", (ReferenceWithMetaExecutionDetails) o.getExecutionDetails() != null ? 1 : 0, 0, 1), 
				checkCardinality("collateral", (ReferenceWithMetaCollateral) o.getCollateral() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ContractBase o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ContractBase", ValidationResult.ValidationType.CARDINALITY, "ContractBase", path, "", res.getError());
				}
				return success("ContractBase", ValidationResult.ValidationType.CARDINALITY, "ContractBase", path, "");
			})
			.collect(toList());
	}

}
