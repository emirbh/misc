package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.CollateralTransferTiming;
import cdm.legaldocumentation.csa.LegacyDefinition;
import cdm.legaldocumentation.csa.LegacyTransferSettlementTiming;
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

public class CollateralTransferTimingValidator implements Validator<CollateralTransferTiming> {

	private List<ComparisonResult> getComparisonResults(CollateralTransferTiming o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("transferSettlementTiming", (LegacyTransferSettlementTiming) o.getTransferSettlementTiming() != null ? 1 : 0, 0, 1), 
				checkCardinality("legacyDefinition", (LegacyDefinition) o.getLegacyDefinition() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralTransferTiming o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CollateralTransferTiming", ValidationResult.ValidationType.CARDINALITY, "CollateralTransferTiming", path, "", res.getError());
				}
				return success("CollateralTransferTiming", ValidationResult.ValidationType.CARDINALITY, "CollateralTransferTiming", path, "");
			})
			.collect(toList());
	}

}
