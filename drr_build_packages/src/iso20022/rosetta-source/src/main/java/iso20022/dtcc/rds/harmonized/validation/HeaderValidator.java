package iso20022.dtcc.rds.harmonized.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.dtcc.rds.harmonized.Header;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class HeaderValidator implements Validator<Header> {

	private List<ComparisonResult> getComparisonResults(Header o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("rdsSchemaVersion", (String) o.getRdsSchemaVersion() != null ? 1 : 0, 0, 1), 
				checkCardinality("sender", (String) o.getSender() != null ? 1 : 0, 0, 1), 
				checkCardinality("receiver", (String) o.getReceiver() != null ? 1 : 0, 0, 1), 
				checkCardinality("documentTrackingId", (String) o.getDocumentTrackingId() != null ? 1 : 0, 1, 1), 
				checkCardinality("documentCreationTimestamp", (ZonedDateTime) o.getDocumentCreationTimestamp() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Header o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Header", ValidationResult.ValidationType.CARDINALITY, "Header", path, "", res.getError());
				}
				return success("Header", ValidationResult.ValidationType.CARDINALITY, "Header", path, "");
			})
			.collect(toList());
	}

}
