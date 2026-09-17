package cdm.observable.asset.validation;

import cdm.observable.asset.DividendApplicability;
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

public class DividendApplicabilityValidator implements Validator<DividendApplicability> {

	private List<ComparisonResult> getComparisonResults(DividendApplicability o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("optionsExchangeDividends", (Boolean) o.getOptionsExchangeDividends() != null ? 1 : 0, 0, 1), 
				checkCardinality("additionalDividends", (Boolean) o.getAdditionalDividends() != null ? 1 : 0, 0, 1), 
				checkCardinality("allDividends", (Boolean) o.getAllDividends() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DividendApplicability o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DividendApplicability", ValidationResult.ValidationType.CARDINALITY, "DividendApplicability", path, "", res.getError());
				}
				return success("DividendApplicability", ValidationResult.ValidationType.CARDINALITY, "DividendApplicability", path, "");
			})
			.collect(toList());
	}

}
