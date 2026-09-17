package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.OrganizationIdentifier;
import java.util.List;
import java.util.regex.Pattern;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class OrganizationIdentifierTypeFormatValidator implements Validator<OrganizationIdentifier> {

	private List<ComparisonResult> getComparisonResults(OrganizationIdentifier o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("idScheme", o.getIdScheme(), 1, empty(), of(Pattern.compile("\\w+:(\\/?\\/?)[^\\s]+")))
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OrganizationIdentifier o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OrganizationIdentifier", ValidationResult.ValidationType.TYPE_FORMAT, "OrganizationIdentifier", path, "", res.getError());
				}
				return success("OrganizationIdentifier", ValidationResult.ValidationType.TYPE_FORMAT, "OrganizationIdentifier", path, "");
			})
			.collect(toList());
	}

}
