package iso20022.auth030.hkma.tr.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.tr.EnergyCommodityCoal2;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class EnergyCommodityCoal2TypeFormatValidator implements Validator<EnergyCommodityCoal2> {

	private List<ComparisonResult> getComparisonResults(EnergyCommodityCoal2 o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EnergyCommodityCoal2 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EnergyCommodityCoal2", ValidationResult.ValidationType.TYPE_FORMAT, "EnergyCommodityCoal2", path, "", res.getError());
				}
				return success("EnergyCommodityCoal2", ValidationResult.ValidationType.TYPE_FORMAT, "EnergyCommodityCoal2", path, "");
			})
			.collect(toList());
	}

}
