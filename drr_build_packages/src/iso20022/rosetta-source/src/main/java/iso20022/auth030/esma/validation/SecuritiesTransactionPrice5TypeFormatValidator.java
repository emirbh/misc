package iso20022.auth030.esma.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.esma.SecuritiesTransactionPrice5;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class SecuritiesTransactionPrice5TypeFormatValidator implements Validator<SecuritiesTransactionPrice5> {

	private List<ComparisonResult> getComparisonResults(SecuritiesTransactionPrice5 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("val", o.getVal(), of(25), of(19), empty(), empty()), 
				checkString("tp", o.getTp(), 1, of(35), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SecuritiesTransactionPrice5 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SecuritiesTransactionPrice5", ValidationResult.ValidationType.TYPE_FORMAT, "SecuritiesTransactionPrice5", path, "", res.getError());
				}
				return success("SecuritiesTransactionPrice5", ValidationResult.ValidationType.TYPE_FORMAT, "SecuritiesTransactionPrice5", path, "");
			})
			.collect(toList());
	}

}
