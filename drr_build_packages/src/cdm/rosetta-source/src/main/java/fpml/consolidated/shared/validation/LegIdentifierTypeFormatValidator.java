package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.LegIdentifier;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class LegIdentifierTypeFormatValidator implements Validator<LegIdentifier> {

	private List<ComparisonResult> getComparisonResults(LegIdentifier o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("version", o.getVersion(), empty(), of(0), of(new BigDecimal("0")), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LegIdentifier o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LegIdentifier", ValidationResult.ValidationType.TYPE_FORMAT, "LegIdentifier", path, "", res.getError());
				}
				return success("LegIdentifier", ValidationResult.ValidationType.TYPE_FORMAT, "LegIdentifier", path, "");
			})
			.collect(toList());
	}

}
