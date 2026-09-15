package fpml.consolidated.business.events.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.PhysicalSettlement;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PhysicalSettlementTypeFormatValidator implements Validator<PhysicalSettlement> {

	private List<ComparisonResult> getComparisonResults(PhysicalSettlement o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PhysicalSettlement o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PhysicalSettlement", ValidationResult.ValidationType.TYPE_FORMAT, "PhysicalSettlement", path, "", res.getError());
				}
				return success("PhysicalSettlement", ValidationResult.ValidationType.TYPE_FORMAT, "PhysicalSettlement", path, "");
			})
			.collect(toList());
	}

}
