package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.PartyRoleType;
import java.util.List;
import java.util.regex.Pattern;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class PartyRoleTypeTypeFormatValidator implements Validator<PartyRoleType> {

	private List<ComparisonResult> getComparisonResults(PartyRoleType o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("partyRoleTypeScheme", o.getPartyRoleTypeScheme(), 1, empty(), of(Pattern.compile("\\w+:(\\/?\\/?)[^\\s]+")))
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PartyRoleType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PartyRoleType", ValidationResult.ValidationType.TYPE_FORMAT, "PartyRoleType", path, "", res.getError());
				}
				return success("PartyRoleType", ValidationResult.ValidationType.TYPE_FORMAT, "PartyRoleType", path, "");
			})
			.collect(toList());
	}

}
