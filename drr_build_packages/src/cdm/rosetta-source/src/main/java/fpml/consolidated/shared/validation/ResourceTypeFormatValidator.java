package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.Resource;
import java.util.List;
import java.util.regex.Pattern;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class ResourceTypeFormatValidator implements Validator<Resource> {

	private List<ComparisonResult> getComparisonResults(Resource o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("name", o.getName(), 1, empty(), empty()), 
				checkString("comments", o.getComments(), 1, empty(), empty()), 
				checkString("string", o.getString(), 1, empty(), empty()), 
				checkString("url", o.getUrl(), 1, empty(), of(Pattern.compile("\\w+:(\\/?\\/?)[^\\s]+")))
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Resource o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Resource", ValidationResult.ValidationType.TYPE_FORMAT, "Resource", path, "", res.getError());
				}
				return success("Resource", ValidationResult.ValidationType.TYPE_FORMAT, "Resource", path, "");
			})
			.collect(toList());
	}

}
