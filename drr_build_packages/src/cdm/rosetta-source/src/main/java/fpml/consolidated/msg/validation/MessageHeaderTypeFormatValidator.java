package fpml.consolidated.msg.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.msg.MessageHeader;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class MessageHeaderTypeFormatValidator implements Validator<MessageHeader> {

	private List<ComparisonResult> getComparisonResults(MessageHeader o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MessageHeader o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MessageHeader", ValidationResult.ValidationType.TYPE_FORMAT, "MessageHeader", path, "", res.getError());
				}
				return success("MessageHeader", ValidationResult.ValidationType.TYPE_FORMAT, "MessageHeader", path, "");
			})
			.collect(toList());
	}

}
