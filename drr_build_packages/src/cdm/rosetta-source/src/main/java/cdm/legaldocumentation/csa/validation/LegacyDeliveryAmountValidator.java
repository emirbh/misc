package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.LegacyDeliveryAmount;
import cdm.legaldocumentation.csa.LegacyDeliveryReturnAmountEnum;
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

public class LegacyDeliveryAmountValidator implements Validator<LegacyDeliveryAmount> {

	private List<ComparisonResult> getComparisonResults(LegacyDeliveryAmount o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("legacyDeliveryAmount", (LegacyDeliveryReturnAmountEnum) o.getLegacyDeliveryAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("additionalLanguage", (String) o.getAdditionalLanguage() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LegacyDeliveryAmount o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LegacyDeliveryAmount", ValidationResult.ValidationType.CARDINALITY, "LegacyDeliveryAmount", path, "", res.getError());
				}
				return success("LegacyDeliveryAmount", ValidationResult.ValidationType.CARDINALITY, "LegacyDeliveryAmount", path, "");
			})
			.collect(toList());
	}

}
