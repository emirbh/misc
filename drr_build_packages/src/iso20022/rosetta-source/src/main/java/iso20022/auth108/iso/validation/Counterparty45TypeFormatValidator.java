package iso20022.auth108.iso.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth108.iso.Counterparty45;
import java.util.List;
import java.util.regex.Pattern;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class Counterparty45TypeFormatValidator implements Validator<Counterparty45> {

	private List<ComparisonResult> getComparisonResults(Counterparty45 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("tradrLctn", o.getTradrLctn(), 0, empty(), of(Pattern.compile("[A-Z]{2,2}"))), 
				checkString("bookgLctn", o.getBookgLctn(), 0, empty(), of(Pattern.compile("[A-Z]{2,2}")))
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Counterparty45 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Counterparty45", ValidationResult.ValidationType.TYPE_FORMAT, "Counterparty45", path, "", res.getError());
				}
				return success("Counterparty45", ValidationResult.ValidationType.TYPE_FORMAT, "Counterparty45", path, "");
			})
			.collect(toList());
	}

}
