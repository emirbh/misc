package cdm.legaldocumentation.transaction.additionalterms.validation;

import cdm.base.math.Quantity;
import cdm.base.staticdata.party.BuyerSeller;
import cdm.legaldocumentation.transaction.additionalterms.EventCurrency;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.metafields.FieldWithMetaString;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class EventCurrencyValidator implements Validator<EventCurrency> {

	private List<ComparisonResult> getComparisonResults(EventCurrency o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("eventCurrency", (FieldWithMetaString) o.getEventCurrency() != null ? 1 : 0, 1, 1), 
				checkCardinality("eventCurrentAmount", (Quantity) o.getEventCurrentAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("eventCurrencyBuyerSeller", (List<? extends BuyerSeller>) o.getEventCurrencyBuyerSeller() == null ? 0 : o.getEventCurrencyBuyerSeller().size(), 0, 2)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EventCurrency o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EventCurrency", ValidationResult.ValidationType.CARDINALITY, "EventCurrency", path, "", res.getError());
				}
				return success("EventCurrency", ValidationResult.ValidationType.CARDINALITY, "EventCurrency", path, "");
			})
			.collect(toList());
	}

}
