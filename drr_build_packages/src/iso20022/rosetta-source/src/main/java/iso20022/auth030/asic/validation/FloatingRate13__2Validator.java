package iso20022.auth030.asic.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.asic.FloatingRate13__2;
import iso20022.auth030.asic.FloatingRateIdentification8Choice__1;
import iso20022.auth030.asic.InterestComputationMethodFormat7__1;
import iso20022.auth030.asic.InterestRateContractTerm4__2;
import iso20022.auth030.asic.InterestRateFrequency3Choice__1;
import iso20022.auth030.asic.SecuritiesTransactionPrice20Choice__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FloatingRate13__2Validator implements Validator<FloatingRate13__2> {

	private List<ComparisonResult> getComparisonResults(FloatingRate13__2 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("rate", (FloatingRateIdentification8Choice__1) o.getRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("refPrd", (InterestRateContractTerm4__2) o.getRefPrd() != null ? 1 : 0, 0, 1), 
				checkCardinality("sprd", (SecuritiesTransactionPrice20Choice__1) o.getSprd() != null ? 1 : 0, 0, 1), 
				checkCardinality("dayCnt", (InterestComputationMethodFormat7__1) o.getDayCnt() != null ? 1 : 0, 0, 1), 
				checkCardinality("pmtFrqcy", (InterestRateFrequency3Choice__1) o.getPmtFrqcy() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FloatingRate13__2 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FloatingRate13__2", ValidationResult.ValidationType.CARDINALITY, "FloatingRate13__2", path, "", res.getError());
				}
				return success("FloatingRate13__2", ValidationResult.ValidationType.CARDINALITY, "FloatingRate13__2", path, "");
			})
			.collect(toList());
	}

}
