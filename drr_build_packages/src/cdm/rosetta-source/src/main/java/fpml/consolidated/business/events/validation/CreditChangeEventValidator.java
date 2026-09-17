package fpml.consolidated.business.events.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.CashOrPhysicalSettlementEnum;
import fpml.consolidated.business.events.CreditChangeEvent;
import fpml.consolidated.business.events.CreditEventType;
import fpml.consolidated.cd.CreditEventIndexReferenceInformation;
import fpml.consolidated.cd.ReferenceInformation;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CreditChangeEventValidator implements Validator<CreditChangeEvent> {

	private List<ComparisonResult> getComparisonResults(CreditChangeEvent o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("creditEventType", (CreditEventType) o.getCreditEventType() != null ? 1 : 0, 0, 1), 
				checkCardinality("eventDeterminationDate", (ZonedDateTime) o.getEventDeterminationDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("auctionDate", (ZonedDateTime) o.getAuctionDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementMethod", (CashOrPhysicalSettlementEnum) o.getSettlementMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementDate", (ZonedDateTime) o.getSettlementDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("finalPrice", (BigDecimal) o.getFinalPrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("recoveryPercent", (BigDecimal) o.getRecoveryPercent() != null ? 1 : 0, 0, 1), 
				checkCardinality("indexReferenceInformation", (CreditEventIndexReferenceInformation) o.getIndexReferenceInformation() != null ? 1 : 0, 0, 1), 
				checkCardinality("excludedReferenceEntity", (ReferenceInformation) o.getExcludedReferenceEntity() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditChangeEvent o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CreditChangeEvent", ValidationResult.ValidationType.CARDINALITY, "CreditChangeEvent", path, "", res.getError());
				}
				return success("CreditChangeEvent", ValidationResult.ValidationType.CARDINALITY, "CreditChangeEvent", path, "");
			})
			.collect(toList());
	}

}
