package fpml.consolidated.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.RetrievalMethodType;
import java.util.List;
import java.util.regex.Pattern;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class RetrievalMethodTypeTypeFormatValidator implements Validator<RetrievalMethodType> {

	private List<ComparisonResult> getComparisonResults(RetrievalMethodType o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("uri", o.getUri(), 0, empty(), of(Pattern.compile("\\w+:(\\/?\\/?)[^\\s]+"))), 
				checkString("type", o._getType(), 0, empty(), of(Pattern.compile("\\w+:(\\/?\\/?)[^\\s]+")))
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RetrievalMethodType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RetrievalMethodType", ValidationResult.ValidationType.TYPE_FORMAT, "RetrievalMethodType", path, "", res.getError());
				}
				return success("RetrievalMethodType", ValidationResult.ValidationType.TYPE_FORMAT, "RetrievalMethodType", path, "");
			})
			.collect(toList());
	}

}
