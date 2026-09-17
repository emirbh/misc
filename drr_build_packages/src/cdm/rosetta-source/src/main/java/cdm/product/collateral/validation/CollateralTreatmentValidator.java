package cdm.product.collateral.validation;

import cdm.product.collateral.CollateralTreatment;
import cdm.product.collateral.CollateralValuationTreatment;
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

public class CollateralTreatmentValidator implements Validator<CollateralTreatment> {

	private List<ComparisonResult> getComparisonResults(CollateralTreatment o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("valuationTreatment", (CollateralValuationTreatment) o.getValuationTreatment() != null ? 1 : 0, 0, 1), 
				checkCardinality("isIncluded", (Boolean) o.getIsIncluded() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralTreatment o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CollateralTreatment", ValidationResult.ValidationType.CARDINALITY, "CollateralTreatment", path, "", res.getError());
				}
				return success("CollateralTreatment", ValidationResult.ValidationType.CARDINALITY, "CollateralTreatment", path, "");
			})
			.collect(toList());
	}

}
