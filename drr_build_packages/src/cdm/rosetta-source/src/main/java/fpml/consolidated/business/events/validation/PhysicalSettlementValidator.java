package fpml.consolidated.business.events.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.PhysicalSettlement;
import fpml.consolidated.doc.PartyTradeIdentifier;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.shared.Product;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PhysicalSettlementValidator implements Validator<PhysicalSettlement> {

	private List<ComparisonResult> getComparisonResults(PhysicalSettlement o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("resultingTradeIdentifier", (PartyTradeIdentifier) o.getResultingTradeIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("resultingTrade", (Trade) o.getResultingTrade() != null ? 1 : 0, 0, 1), 
				checkCardinality("product", (Product) o.getProduct() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PhysicalSettlement o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PhysicalSettlement", ValidationResult.ValidationType.CARDINALITY, "PhysicalSettlement", path, "", res.getError());
				}
				return success("PhysicalSettlement", ValidationResult.ValidationType.CARDINALITY, "PhysicalSettlement", path, "");
			})
			.collect(toList());
	}

}
