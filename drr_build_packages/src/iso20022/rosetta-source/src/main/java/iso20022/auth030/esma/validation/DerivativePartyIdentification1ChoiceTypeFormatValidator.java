package iso20022.auth030.esma.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.esma.DerivativePartyIdentification1Choice;
import java.util.List;
import java.util.regex.Pattern;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class DerivativePartyIdentification1ChoiceTypeFormatValidator implements Validator<DerivativePartyIdentification1Choice> {

	private List<ComparisonResult> getComparisonResults(DerivativePartyIdentification1Choice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("ctry", o.getCtry(), 0, empty(), of(Pattern.compile("[A-Z]{2,2}"))), 
				checkString("ctrySubDvsn", o.getCtrySubDvsn(), 0, empty(), of(Pattern.compile("[A-Z]{2,2}\\-[0-9A-Z]{1,3}"))), 
				checkString("lei", o.getLei(), 0, empty(), of(Pattern.compile("[A-Z0-9]{18,18}[0-9]{2,2}")))
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DerivativePartyIdentification1Choice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DerivativePartyIdentification1Choice", ValidationResult.ValidationType.TYPE_FORMAT, "DerivativePartyIdentification1Choice", path, "", res.getError());
				}
				return success("DerivativePartyIdentification1Choice", ValidationResult.ValidationType.TYPE_FORMAT, "DerivativePartyIdentification1Choice", path, "");
			})
			.collect(toList());
	}

}
