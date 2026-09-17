package fpml.consolidated.sec.lending.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.sec.lending.PrepaidRate;
import fpml.consolidated.shared.FloatingRateIndex;
import fpml.consolidated.shared.Period;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PrepaidRateValidator implements Validator<PrepaidRate> {

	private List<ComparisonResult> getComparisonResults(PrepaidRate o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("fixedRate", (BigDecimal) o.getFixedRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("floatingRateIndex", (FloatingRateIndex) o.getFloatingRateIndex() != null ? 1 : 0, 0, 1), 
				checkCardinality("indexTenor", (Period) o.getIndexTenor() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PrepaidRate o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PrepaidRate", ValidationResult.ValidationType.CARDINALITY, "PrepaidRate", path, "", res.getError());
				}
				return success("PrepaidRate", ValidationResult.ValidationType.CARDINALITY, "PrepaidRate", path, "");
			})
			.collect(toList());
	}

}
