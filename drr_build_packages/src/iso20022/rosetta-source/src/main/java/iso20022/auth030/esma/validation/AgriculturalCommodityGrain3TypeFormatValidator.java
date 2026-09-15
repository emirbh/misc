package iso20022.auth030.esma.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.esma.AgriculturalCommodityGrain3;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AgriculturalCommodityGrain3TypeFormatValidator implements Validator<AgriculturalCommodityGrain3> {

	private List<ComparisonResult> getComparisonResults(AgriculturalCommodityGrain3 o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AgriculturalCommodityGrain3 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AgriculturalCommodityGrain3", ValidationResult.ValidationType.TYPE_FORMAT, "AgriculturalCommodityGrain3", path, "", res.getError());
				}
				return success("AgriculturalCommodityGrain3", ValidationResult.ValidationType.TYPE_FORMAT, "AgriculturalCommodityGrain3", path, "");
			})
			.collect(toList());
	}

}
