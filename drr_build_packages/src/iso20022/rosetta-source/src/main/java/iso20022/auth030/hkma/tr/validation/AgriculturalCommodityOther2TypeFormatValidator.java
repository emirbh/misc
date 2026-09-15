package iso20022.auth030.hkma.tr.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.tr.AgriculturalCommodityOther2;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AgriculturalCommodityOther2TypeFormatValidator implements Validator<AgriculturalCommodityOther2> {

	private List<ComparisonResult> getComparisonResults(AgriculturalCommodityOther2 o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AgriculturalCommodityOther2 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AgriculturalCommodityOther2", ValidationResult.ValidationType.TYPE_FORMAT, "AgriculturalCommodityOther2", path, "", res.getError());
				}
				return success("AgriculturalCommodityOther2", ValidationResult.ValidationType.TYPE_FORMAT, "AgriculturalCommodityOther2", path, "");
			})
			.collect(toList());
	}

}
