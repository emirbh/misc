package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.Money;
import fpml.consolidated.shared.Stub;
import fpml.consolidated.shared.StubFloatingRate;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class StubValidator implements Validator<Stub> {

	private List<ComparisonResult> getComparisonResults(Stub o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("floatingRate", (List<? extends StubFloatingRate>) o.getFloatingRate() == null ? 0 : o.getFloatingRate().size(), 0, 2), 
				checkCardinality("stubRate", (BigDecimal) o.getStubRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("stubAmount", (Money) o.getStubAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("stubStartDate", (AdjustableOrRelativeDate) o.getStubStartDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("stubEndDate", (AdjustableOrRelativeDate) o.getStubEndDate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Stub o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Stub", ValidationResult.ValidationType.CARDINALITY, "Stub", path, "", res.getError());
				}
				return success("Stub", ValidationResult.ValidationType.CARDINALITY, "Stub", path, "");
			})
			.collect(toList());
	}

}
