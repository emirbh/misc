package fpml.consolidated.credit.event.notification.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.credit.event.notification.AffectedTransactions;
import fpml.consolidated.credit.event.notification.CreditEvent;
import fpml.consolidated.credit.event.notification.CreditEventNotice;
import fpml.consolidated.shared.LegalEntity;
import fpml.consolidated.shared.PartyReference;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CreditEventNoticeValidator implements Validator<CreditEventNotice> {

	private List<ComparisonResult> getComparisonResults(CreditEventNotice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("affectedTransactions", (AffectedTransactions) o.getAffectedTransactions() != null ? 1 : 0, 0, 1), 
				checkCardinality("referenceEntity", (LegalEntity) o.getReferenceEntity() != null ? 1 : 0, 0, 1), 
				checkCardinality("creditEvent", (CreditEvent) o.getCreditEvent() != null ? 1 : 0, 0, 1), 
				checkCardinality("notifyingPartyReference", (PartyReference) o.getNotifyingPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("notifiedPartyReference", (PartyReference) o.getNotifiedPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("creditEventNoticeDate", (ZonedDateTime) o.getCreditEventNoticeDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("creditEventDate", (ZonedDateTime) o.getCreditEventDate() != null ? 1 : 0, 0, 1)
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
