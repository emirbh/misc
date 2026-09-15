package drr.regulation.common.validation;

import cdm.base.staticdata.party.Address;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.ExecutingEntity;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ExecutingEntityValidator implements Validator<ExecutingEntity> {

	private List<ComparisonResult> getComparisonResults(ExecutingEntity o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("isInvestmentFirm", (Boolean) o.getIsInvestmentFirm() != null ? 1 : 0, 1, 1), 
				checkCardinality("addressOfBranch", (Address) o.getAddressOfBranch() != null ? 1 : 0, 1, 1), 
				checkCardinality("addressOfIncorporation", (Address) o.getAddressOfIncorporation() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExecutingEntity o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ExecutingEntity", ValidationResult.ValidationType.CARDINALITY, "ExecutingEntity", path, "", res.getError());
				}
				return success("ExecutingEntity", ValidationResult.ValidationType.CARDINALITY, "ExecutingEntity", path, "");
			})
			.collect(toList());
	}

}
