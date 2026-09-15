package fpml.consolidated.option.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.option.shared.CreditEventNotice;
import fpml.consolidated.option.shared.NotifyingParty;
import fpml.consolidated.option.shared.PubliclyAvailableInformation;
import fpml.consolidated.shared.BusinessCenter;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CreditEventNoticeValidator implements Validator<CreditEventNotice> {

	private List<ComparisonResult> getComparisonResults(CreditEventNotice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("notifyingParty", (NotifyingParty) o.getNotifyingParty() != null ? 1 : 0, 0, 1), 
				checkCardinality("businessCenter", (BusinessCenter) o.getBusinessCenter() != null ? 1 : 0, 0, 1), 
				checkCardinality("publiclyAvailableInformation", (PubliclyAvailableInformation) o.getPubliclyAvailableInformation() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditEventNotice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CreditEventNotice", ValidationResult.ValidationType.CARDINALITY, "CreditEventNotice", path, "", res.getError());
				}
				return success("CreditEventNotice", ValidationResult.ValidationType.CARDINALITY, "CreditEventNotice", path, "");
			})
			.collect(toList());
	}

}
