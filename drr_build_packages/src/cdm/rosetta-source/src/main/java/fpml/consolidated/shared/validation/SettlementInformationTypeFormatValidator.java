package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.SettlementInformation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class SettlementInformationTypeFormatValidator implements Validator<SettlementInformation> {

	private List<ComparisonResult> getComparisonResults(SettlementInformation o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SettlementInformation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SettlementInformation", ValidationResult.ValidationType.TYPE_FORMAT, "SettlementInformation", path, "", res.getError());
				}
				return success("SettlementInformation", ValidationResult.ValidationType.TYPE_FORMAT, "SettlementInformation", path, "");
			})
			.collect(toList());
	}

}
