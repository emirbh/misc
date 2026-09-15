package fpml.consolidated.business.events.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.ClearingStatusItem;
import fpml.consolidated.business.events.TradePackage;
import fpml.consolidated.business.events.TradeReferenceInformation;
import fpml.consolidated.doc.ClearingStatusValue;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.shared.PartyReference;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ClearingStatusItemValidator implements Validator<ClearingStatusItem> {

	private List<ComparisonResult> getComparisonResults(ClearingStatusItem o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("tradeReferenceInformation", (TradeReferenceInformation) o.getTradeReferenceInformation() != null ? 1 : 0, 0, 1), 
				checkCardinality("trade", (Trade) o.getTrade() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradePackage", (TradePackage) o.getTradePackage() != null ? 1 : 0, 0, 1), 
				checkCardinality("clearingStatusValue", (ClearingStatusValue) o.getClearingStatusValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("updatedDateTime", (ZonedDateTime) o.getUpdatedDateTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("statusAppliesTo", (List<? extends PartyReference>) o.getStatusAppliesTo() == null ? 0 : o.getStatusAppliesTo().size(), 0, 2)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ClearingStatusItem o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ClearingStatusItem", ValidationResult.ValidationType.CARDINALITY, "ClearingStatusItem", path, "", res.getError());
				}
				return success("ClearingStatusItem", ValidationResult.ValidationType.CARDINALITY, "ClearingStatusItem", path, "");
			})
			.collect(toList());
	}

}
