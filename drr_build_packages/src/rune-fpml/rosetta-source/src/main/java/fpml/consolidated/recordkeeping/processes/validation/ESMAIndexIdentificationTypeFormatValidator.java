package fpml.consolidated.recordkeeping.processes.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.recordkeeping.processes.ESMAIndexIdentification;
import java.util.List;
import java.util.regex.Pattern;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class ESMAIndexIdentificationTypeFormatValidator implements Validator<ESMAIndexIdentification> {

	private List<ComparisonResult> getComparisonResults(ESMAIndexIdentification o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("name", o.getName(), 0, empty(), of(Pattern.compile("[A-Z][A-Z0-9]{0,24}")))
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ESMAIndexIdentification o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ESMAIndexIdentification", ValidationResult.ValidationType.TYPE_FORMAT, "ESMAIndexIdentification", path, "", res.getError());
				}
				return success("ESMAIndexIdentification", ValidationResult.ValidationType.TYPE_FORMAT, "ESMAIndexIdentification", path, "");
			})
			.collect(toList());
	}

}
