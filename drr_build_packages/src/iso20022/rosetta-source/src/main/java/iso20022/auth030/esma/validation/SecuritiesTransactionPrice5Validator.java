package iso20022.auth030.esma.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.esma.SecuritiesTransactionPrice5;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class SecuritiesTransactionPrice5Validator implements Validator<SecuritiesTransactionPrice5> {

	private List<ComparisonResult> getComparisonResults(SecuritiesTransactionPrice5 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("val", (BigDecimal) o.getVal() != null ? 1 : 0, 0, 1), 
				checkCardinality("tp", (String) o.getTp() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SecuritiesTransactionPrice5 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SecuritiesTransactionPrice5", ValidationResult.ValidationType.CARDINALITY, "SecuritiesTransactionPrice5", path, "", res.getError());
				}
				return success("SecuritiesTransactionPrice5", ValidationResult.ValidationType.CARDINALITY, "SecuritiesTransactionPrice5", path, "");
			})
			.collect(toList());
	}

}
