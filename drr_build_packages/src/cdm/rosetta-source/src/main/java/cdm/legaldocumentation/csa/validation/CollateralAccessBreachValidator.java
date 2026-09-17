package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.CollateralAccessBreach;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CollateralAccessBreachValidator implements Validator<CollateralAccessBreach> {

	private List<ComparisonResult> getComparisonResults(CollateralAccessBreach o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("isApplicable", (Boolean) o.getIsApplicable() != null ? 1 : 0, 1, 1), 
				checkCardinality("cabEndDateElection", (Boolean) o.getCabEndDateElection() != null ? 1 : 0, 0, 1), 
				checkCardinality("cabEndDate", (BigDecimal) o.getCabEndDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("cabEndDateTerms", (String) o.getCabEndDateTerms() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralAccessBreach o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CollateralAccessBreach", ValidationResult.ValidationType.CARDINALITY, "CollateralAccessBreach", path, "", res.getError());
				}
				return success("CollateralAccessBreach", ValidationResult.ValidationType.CARDINALITY, "CollateralAccessBreach", path, "");
			})
			.collect(toList());
	}

}
