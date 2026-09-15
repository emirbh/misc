package iso20022.dtcc.rds.harmonized.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.dtcc.rds.harmonized.Header;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class HeaderTypeFormatValidator implements Validator<Header> {

	private List<ComparisonResult> getComparisonResults(Header o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("rdsSchemaVersion", o.getRdsSchemaVersion(), 0, of(255), empty()), 
				checkString("sender", o.getSender(), 0, of(255), empty()), 
				checkString("receiver", o.getReceiver(), 0, of(255), empty()), 
				checkString("documentTrackingId", o.getDocumentTrackingId(), 0, of(255), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Header o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Header", ValidationResult.ValidationType.TYPE_FORMAT, "Header", path, "", res.getError());
				}
				return success("Header", ValidationResult.ValidationType.TYPE_FORMAT, "Header", path, "");
			})
			.collect(toList());
	}

}
