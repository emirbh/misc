package cdm.product.common.settlement.validation;

import cdm.product.common.settlement.SettlementProvision;
import cdm.product.common.settlement.ShapingProvision;
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

public class SettlementProvisionValidator implements Validator<SettlementProvision> {

	private List<ComparisonResult> getComparisonResults(SettlementProvision o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("shapingProvisions", (ShapingProvision) o.getShapingProvisions() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SettlementProvision o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SettlementProvision", ValidationResult.ValidationType.CARDINALITY, "SettlementProvision", path, "", res.getError());
				}
				return success("SettlementProvision", ValidationResult.ValidationType.CARDINALITY, "SettlementProvision", path, "");
			})
			.collect(toList());
	}

}
