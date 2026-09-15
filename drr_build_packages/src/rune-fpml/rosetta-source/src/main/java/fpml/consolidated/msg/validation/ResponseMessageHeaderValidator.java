package fpml.consolidated.msg.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.msg.ImplementationSpecification;
import fpml.consolidated.msg.MessageAddress;
import fpml.consolidated.msg.MessageId;
import fpml.consolidated.msg.ResponseMessageHeader;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ResponseMessageHeaderValidator implements Validator<ResponseMessageHeader> {

	private List<ComparisonResult> getComparisonResults(ResponseMessageHeader o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("messageId", (MessageId) o.getMessageId() != null ? 1 : 0, 0, 1), 
				checkCardinality("inReplyTo", (MessageId) o.getInReplyTo() != null ? 1 : 0, 0, 1), 
				checkCardinality("sentBy", (MessageAddress) o.getSentBy() != null ? 1 : 0, 0, 1), 
				checkCardinality("creationTimestamp", (ZonedDateTime) o.getCreationTimestamp() != null ? 1 : 0, 0, 1), 
				checkCardinality("expiryTimestamp", (ZonedDateTime) o.getExpiryTimestamp() != null ? 1 : 0, 0, 1), 
				checkCardinality("implementationSpecification", (ImplementationSpecification) o.getImplementationSpecification() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ResponseMessageHeader o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ResponseMessageHeader", ValidationResult.ValidationType.CARDINALITY, "ResponseMessageHeader", path, "", res.getError());
				}
				return success("ResponseMessageHeader", ValidationResult.ValidationType.CARDINALITY, "ResponseMessageHeader", path, "");
			})
			.collect(toList());
	}

}
