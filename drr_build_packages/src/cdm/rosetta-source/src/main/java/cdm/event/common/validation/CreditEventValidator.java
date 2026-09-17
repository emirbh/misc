package cdm.event.common.validation;

import cdm.event.common.CreditEvent;
import cdm.event.common.CreditEventTypeEnum;
import cdm.observable.asset.Price;
import cdm.product.asset.ReferenceInformation;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CreditEventValidator implements Validator<CreditEvent> {

	private List<ComparisonResult> getComparisonResults(CreditEvent o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("creditEventType", (CreditEventTypeEnum) o.getCreditEventType() != null ? 1 : 0, 1, 1), 
				checkCardinality("eventDeterminationDate", (Date) o.getEventDeterminationDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("auctionDate", (Date) o.getAuctionDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("finalPrice", (Price) o.getFinalPrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("recoveryPercent", (BigDecimal) o.getRecoveryPercent() != null ? 1 : 0, 0, 1), 
				checkCardinality("referenceInformation", (ReferenceInformation) o.getReferenceInformation() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditEvent o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CreditEvent", ValidationResult.ValidationType.CARDINALITY, "CreditEvent", path, "", res.getError());
				}
				return success("CreditEvent", ValidationResult.ValidationType.CARDINALITY, "CreditEvent", path, "");
			})
			.collect(toList());
	}

}
