package iso20022.auth108.iso.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth108.iso.UniqueTransactionIdentifier2Choice;
import java.util.List;
import java.util.regex.Pattern;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class UniqueTransactionIdentifier2ChoiceTypeFormatValidator implements Validator<UniqueTransactionIdentifier2Choice> {

	private List<ComparisonResult> getComparisonResults(UniqueTransactionIdentifier2Choice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("unqTxIdr", o.getUnqTxIdr(), 0, empty(), of(Pattern.compile("[A-Z0-9]{18}[0-9]{2}[A-Z0-9]{0,32}")))
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, UniqueTransactionIdentifier2Choice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("UniqueTransactionIdentifier2Choice", ValidationResult.ValidationType.TYPE_FORMAT, "UniqueTransactionIdentifier2Choice", path, "", res.getError());
				}
				return success("UniqueTransactionIdentifier2Choice", ValidationResult.ValidationType.TYPE_FORMAT, "UniqueTransactionIdentifier2Choice", path, "");
			})
			.collect(toList());
	}

}
