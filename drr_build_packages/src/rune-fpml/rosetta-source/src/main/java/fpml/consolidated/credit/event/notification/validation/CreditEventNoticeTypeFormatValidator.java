package fpml.consolidated.credit.event.notification.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.credit.event.notification.CreditEventNotice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CreditEventNoticeTypeFormatValidator implements Validator<CreditEventNotice> {

	private List<ComparisonResult> getComparisonResults(CreditEventNotice o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditEventNotice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CreditEventNotice", ValidationResult.ValidationType.TYPE_FORMAT, "CreditEventNotice", path, "", res.getError());
				}
				return success("CreditEventNotice", ValidationResult.ValidationType.TYPE_FORMAT, "CreditEventNotice", path, "");
			})
			.collect(toList());
	}

}
