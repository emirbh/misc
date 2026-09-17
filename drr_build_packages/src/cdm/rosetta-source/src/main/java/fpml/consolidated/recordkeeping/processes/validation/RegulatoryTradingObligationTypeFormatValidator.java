package fpml.consolidated.recordkeeping.processes.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.recordkeeping.processes.RegulatoryTradingObligation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RegulatoryTradingObligationTypeFormatValidator implements Validator<RegulatoryTradingObligation> {

	private List<ComparisonResult> getComparisonResults(RegulatoryTradingObligation o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RegulatoryTradingObligation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RegulatoryTradingObligation", ValidationResult.ValidationType.TYPE_FORMAT, "RegulatoryTradingObligation", path, "", res.getError());
				}
				return success("RegulatoryTradingObligation", ValidationResult.ValidationType.TYPE_FORMAT, "RegulatoryTradingObligation", path, "");
			})
			.collect(toList());
	}

}
