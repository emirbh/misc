package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.LegacyResolutionValue;
import cdm.legaldocumentation.csa.ValueCashEnum;
import cdm.legaldocumentation.csa.ValueSecuritiesEnum;
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

public class LegacyResolutionValueValidator implements Validator<LegacyResolutionValue> {

	private List<ComparisonResult> getComparisonResults(LegacyResolutionValue o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("cash", (ValueCashEnum) o.getCash() != null ? 1 : 0, 0, 1), 
				checkCardinality("securities", (ValueSecuritiesEnum) o.getSecurities() != null ? 1 : 0, 0, 1), 
				checkCardinality("fallback", (Boolean) o.getFallback() != null ? 1 : 0, 0, 1), 
				checkCardinality("additionalLanguage", (String) o.getAdditionalLanguage() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LegacyResolutionValue o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LegacyResolutionValue", ValidationResult.ValidationType.CARDINALITY, "LegacyResolutionValue", path, "", res.getError());
				}
				return success("LegacyResolutionValue", ValidationResult.ValidationType.CARDINALITY, "LegacyResolutionValue", path, "");
			})
			.collect(toList());
	}

}
