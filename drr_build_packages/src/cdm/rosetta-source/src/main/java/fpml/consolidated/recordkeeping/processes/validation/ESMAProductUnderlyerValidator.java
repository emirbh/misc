package fpml.consolidated.recordkeeping.processes.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.recordkeeping.processes.ESMAIndexIdentification;
import fpml.consolidated.recordkeeping.processes.ESMAProductUnderlyer;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ESMAProductUnderlyerValidator implements Validator<ESMAProductUnderlyer> {

	private List<ComparisonResult> getComparisonResults(ESMAProductUnderlyer o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("index", (ESMAIndexIdentification) o.getIndex() != null ? 1 : 0, 0, 1), 
				checkCardinality("maturityDate", (ZonedDateTime) o.getMaturityDate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ESMAProductUnderlyer o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ESMAProductUnderlyer", ValidationResult.ValidationType.CARDINALITY, "ESMAProductUnderlyer", path, "", res.getError());
				}
				return success("ESMAProductUnderlyer", ValidationResult.ValidationType.CARDINALITY, "ESMAProductUnderlyer", path, "");
			})
			.collect(toList());
	}

}
