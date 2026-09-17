package fpml.consolidated.msg.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.msg.ExceptionMessageHeader;
import fpml.consolidated.msg.ImplementationSpecification;
import fpml.consolidated.msg.MessageAddress;
import fpml.consolidated.msg.MessageId;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ExceptionMessageHeaderValidator implements Validator<ExceptionMessageHeader> {

	private List<ComparisonResult> getComparisonResults(ExceptionMessageHeader o) {
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
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExceptionMessageHeader o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ExceptionMessageHeader", ValidationResult.ValidationType.CARDINALITY, "ExceptionMessageHeader", path, "", res.getError());
				}
				return success("ExceptionMessageHeader", ValidationResult.ValidationType.CARDINALITY, "ExceptionMessageHeader", path, "");
			})
			.collect(toList());
	}

}
