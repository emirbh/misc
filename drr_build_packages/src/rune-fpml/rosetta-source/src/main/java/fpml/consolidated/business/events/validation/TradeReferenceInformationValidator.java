package fpml.consolidated.business.events.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.TerminatingEvent;
import fpml.consolidated.business.events.TradeReferenceInformation;
import fpml.consolidated.doc.PartyTradeIdentifier;
import fpml.consolidated.shared.OriginatingEvent;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TradeReferenceInformationValidator implements Validator<TradeReferenceInformation> {

	private List<ComparisonResult> getComparisonResults(TradeReferenceInformation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("originatingEvent", (OriginatingEvent) o.getOriginatingEvent() != null ? 1 : 0, 0, 1), 
				checkCardinality("terminatingEvent", (TerminatingEvent) o.getTerminatingEvent() != null ? 1 : 0, 0, 1), 
				checkCardinality("partyTradeIdentifier", (List<? extends PartyTradeIdentifier>) o.getPartyTradeIdentifier() == null ? 0 : o.getPartyTradeIdentifier().size(), 1, 0), 
				checkCardinality("productType", (ProductType) o.getProductType() != null ? 1 : 0, 0, 1), 
				checkCardinality("productId", (ProductId) o.getProductId() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeReferenceInformation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeReferenceInformation", ValidationResult.ValidationType.CARDINALITY, "TradeReferenceInformation", path, "", res.getError());
				}
				return success("TradeReferenceInformation", ValidationResult.ValidationType.CARDINALITY, "TradeReferenceInformation", path, "");
			})
			.collect(toList());
	}

}
