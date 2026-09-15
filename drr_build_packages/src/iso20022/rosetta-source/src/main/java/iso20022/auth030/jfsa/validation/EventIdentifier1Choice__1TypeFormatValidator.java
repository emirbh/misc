package iso20022.auth030.jfsa.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.jfsa.EventIdentifier1Choice__1;
import java.util.List;
import java.util.regex.Pattern;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class EventIdentifier1Choice__1TypeFormatValidator implements Validator<EventIdentifier1Choice__1> {

	private List<ComparisonResult> getComparisonResults(EventIdentifier1Choice__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("evtIdr", o.getEvtIdr(), 0, empty(), of(Pattern.compile("[A-Z0-9]{18}[0-9]{2}[A-Z0-9]{0,32}")))
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EventIdentifier1Choice__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EventIdentifier1Choice__1", ValidationResult.ValidationType.TYPE_FORMAT, "EventIdentifier1Choice__1", path, "", res.getError());
				}
				return success("EventIdentifier1Choice__1", ValidationResult.ValidationType.TYPE_FORMAT, "EventIdentifier1Choice__1", path, "");
			})
			.collect(toList());
	}

}
