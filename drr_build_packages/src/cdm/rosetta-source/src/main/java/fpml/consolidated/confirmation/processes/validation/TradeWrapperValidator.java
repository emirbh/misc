package fpml.consolidated.confirmation.processes.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.TradePackage;
import fpml.consolidated.business.events.TradeReferenceInformation;
import fpml.consolidated.confirmation.processes.TradeWrapper;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.shared.OriginatingEvent;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TradeWrapperValidator implements Validator<TradeWrapper> {

	private List<ComparisonResult> getComparisonResults(TradeWrapper o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("originatingEvent", (OriginatingEvent) o.getOriginatingEvent() != null ? 1 : 0, 0, 1), 
				checkCardinality("trade", (Trade) o.getTrade() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradeReferenceInformation", (TradeReferenceInformation) o.getTradeReferenceInformation() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradePackage", (TradePackage) o.getTradePackage() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeWrapper o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeWrapper", ValidationResult.ValidationType.CARDINALITY, "TradeWrapper", path, "", res.getError());
				}
				return success("TradeWrapper", ValidationResult.ValidationType.CARDINALITY, "TradeWrapper", path, "");
			})
			.collect(toList());
	}

}
