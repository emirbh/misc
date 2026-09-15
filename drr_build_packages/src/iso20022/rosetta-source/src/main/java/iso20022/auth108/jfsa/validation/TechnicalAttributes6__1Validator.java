package iso20022.auth108.jfsa.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth108.jfsa.TechnicalAttributes6__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TechnicalAttributes6__1Validator implements Validator<TechnicalAttributes6__1> {

	private List<ComparisonResult> getComparisonResults(TechnicalAttributes6__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("techRcrdId", (String) o.getTechRcrdId() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TechnicalAttributes6__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TechnicalAttributes6__1", ValidationResult.ValidationType.CARDINALITY, "TechnicalAttributes6__1", path, "", res.getError());
				}
				return success("TechnicalAttributes6__1", ValidationResult.ValidationType.CARDINALITY, "TechnicalAttributes6__1", path, "");
			})
			.collect(toList());
	}

}
