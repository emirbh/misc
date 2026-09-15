package iso20022.auth030.hkma.tr.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.tr.InstrumentIdentification6Choice__1;
import java.util.List;
import java.util.regex.Pattern;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class InstrumentIdentification6Choice__1TypeFormatValidator implements Validator<InstrumentIdentification6Choice__1> {

	private List<ComparisonResult> getComparisonResults(InstrumentIdentification6Choice__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("isin", o.getIsin(), 0, empty(), of(Pattern.compile("[A-Z]{2,2}[A-Z0-9]{9,9}[0-9]{1,1}")))
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, InstrumentIdentification6Choice__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("InstrumentIdentification6Choice__1", ValidationResult.ValidationType.TYPE_FORMAT, "InstrumentIdentification6Choice__1", path, "", res.getError());
				}
				return success("InstrumentIdentification6Choice__1", ValidationResult.ValidationType.TYPE_FORMAT, "InstrumentIdentification6Choice__1", path, "");
			})
			.collect(toList());
	}

}
