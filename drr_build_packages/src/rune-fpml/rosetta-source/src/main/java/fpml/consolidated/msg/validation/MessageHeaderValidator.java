package fpml.consolidated.msg.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.msg.MessageHeader;
import fpml.consolidated.msg.MessageId;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class MessageHeaderValidator implements Validator<MessageHeader> {

	private List<ComparisonResult> getComparisonResults(MessageHeader o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("messageId", (MessageId) o.getMessageId() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MessageHeader o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MessageHeader", ValidationResult.ValidationType.CARDINALITY, "MessageHeader", path, "", res.getError());
				}
				return success("MessageHeader", ValidationResult.ValidationType.CARDINALITY, "MessageHeader", path, "");
			})
			.collect(toList());
	}

}
