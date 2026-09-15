package iso20022.auth030.mas.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.mas.FixedRate10__1;
import iso20022.auth030.mas.InterestComputationMethodFormat7__1;
import iso20022.auth030.mas.InterestRateFrequency3Choice__1;
import iso20022.auth030.mas.SecuritiesTransactionPrice14Choice__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FixedRate10__1Validator implements Validator<FixedRate10__1> {

	private List<ComparisonResult> getComparisonResults(FixedRate10__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("rate", (SecuritiesTransactionPrice14Choice__1) o.getRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("dayCnt", (InterestComputationMethodFormat7__1) o.getDayCnt() != null ? 1 : 0, 0, 1), 
				checkCardinality("pmtFrqcy", (InterestRateFrequency3Choice__1) o.getPmtFrqcy() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FixedRate10__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FixedRate10__1", ValidationResult.ValidationType.CARDINALITY, "FixedRate10__1", path, "", res.getError());
				}
				return success("FixedRate10__1", ValidationResult.ValidationType.CARDINALITY, "FixedRate10__1", path, "");
			})
			.collect(toList());
	}

}
