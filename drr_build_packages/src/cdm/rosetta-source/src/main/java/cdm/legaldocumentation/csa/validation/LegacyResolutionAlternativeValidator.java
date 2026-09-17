package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.LegacyResolutionAlternative;
import cdm.legaldocumentation.csa.LegacyResolutionAlternativeEnum;
import cdm.observable.asset.Money;
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

public class LegacyResolutionAlternativeValidator implements Validator<LegacyResolutionAlternative> {

	private List<ComparisonResult> getComparisonResults(LegacyResolutionAlternative o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("resolutionAlternative", (LegacyResolutionAlternativeEnum) o.getResolutionAlternative() != null ? 1 : 0, 0, 1), 
				checkCardinality("amount", (Money) o.getAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("additionalLanguage", (String) o.getAdditionalLanguage() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LegacyResolutionAlternative o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LegacyResolutionAlternative", ValidationResult.ValidationType.CARDINALITY, "LegacyResolutionAlternative", path, "", res.getError());
				}
				return success("LegacyResolutionAlternative", ValidationResult.ValidationType.CARDINALITY, "LegacyResolutionAlternative", path, "");
			})
			.collect(toList());
	}

}
