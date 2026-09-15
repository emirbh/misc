package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.IdentifiedPayerReceiver;
import fpml.consolidated.shared.Strike;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class StrikeValidator implements Validator<Strike> {

	private List<ComparisonResult> getComparisonResults(Strike o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("strikeRate", (BigDecimal) o.getStrikeRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("buyer", (IdentifiedPayerReceiver) o.getBuyer() != null ? 1 : 0, 0, 1), 
				checkCardinality("seller", (IdentifiedPayerReceiver) o.getSeller() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Strike o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Strike", ValidationResult.ValidationType.CARDINALITY, "Strike", path, "", res.getError());
				}
				return success("Strike", ValidationResult.ValidationType.CARDINALITY, "Strike", path, "");
			})
			.collect(toList());
	}

}
