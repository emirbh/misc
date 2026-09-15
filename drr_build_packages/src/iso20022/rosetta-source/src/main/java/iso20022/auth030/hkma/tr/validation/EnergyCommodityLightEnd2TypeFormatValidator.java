package iso20022.auth030.hkma.tr.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.tr.EnergyCommodityLightEnd2;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class EnergyCommodityLightEnd2TypeFormatValidator implements Validator<EnergyCommodityLightEnd2> {

	private List<ComparisonResult> getComparisonResults(EnergyCommodityLightEnd2 o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EnergyCommodityLightEnd2 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EnergyCommodityLightEnd2", ValidationResult.ValidationType.TYPE_FORMAT, "EnergyCommodityLightEnd2", path, "", res.getError());
				}
				return success("EnergyCommodityLightEnd2", ValidationResult.ValidationType.TYPE_FORMAT, "EnergyCommodityLightEnd2", path, "");
			})
			.collect(toList());
	}

}
