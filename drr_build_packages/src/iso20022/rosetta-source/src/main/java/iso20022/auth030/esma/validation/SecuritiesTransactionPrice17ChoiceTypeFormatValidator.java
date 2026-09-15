package iso20022.auth030.esma.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.esma.SecuritiesTransactionPrice17Choice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class SecuritiesTransactionPrice17ChoiceTypeFormatValidator implements Validator<SecuritiesTransactionPrice17Choice> {

	private List<ComparisonResult> getComparisonResults(SecuritiesTransactionPrice17Choice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("unit", o.getUnit(), of(25), of(19), empty(), empty()), 
				checkNumber("pctg", o.getPctg(), of(11), of(10), empty(), empty()), 
				checkNumber("yld", o.getYld(), of(11), of(10), empty(), empty()), 
				checkNumber("dcml", o.getDcml(), of(11), of(10), empty(), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SecuritiesTransactionPrice17Choice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SecuritiesTransactionPrice17Choice", ValidationResult.ValidationType.TYPE_FORMAT, "SecuritiesTransactionPrice17Choice", path, "", res.getError());
				}
				return success("SecuritiesTransactionPrice17Choice", ValidationResult.ValidationType.TYPE_FORMAT, "SecuritiesTransactionPrice17Choice", path, "");
			})
			.collect(toList());
	}

}
