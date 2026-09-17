package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.AdditionalType;
import cdm.legaldocumentation.csa.AdditionalTypeEnum;
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

public class AdditionalTypeValidator implements Validator<AdditionalType> {

	private List<ComparisonResult> getComparisonResults(AdditionalType o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("standardValue", (AdditionalTypeEnum) o.getStandardValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("customValue", (String) o.getCustomValue() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AdditionalType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AdditionalType", ValidationResult.ValidationType.CARDINALITY, "AdditionalType", path, "", res.getError());
				}
				return success("AdditionalType", ValidationResult.ValidationType.CARDINALITY, "AdditionalType", path, "");
			})
			.collect(toList());
	}

}
