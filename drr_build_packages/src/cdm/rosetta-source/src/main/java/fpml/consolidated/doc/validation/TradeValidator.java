package fpml.consolidated.doc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.Allocations;
import fpml.consolidated.doc.Approvals;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.doc.TradeHeader;
import fpml.consolidated.shared.BusinessCenter;
import fpml.consolidated.shared.CalculationAgent;
import fpml.consolidated.shared.Collateral;
import fpml.consolidated.shared.Documentation;
import fpml.consolidated.shared.GoverningLaw;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.Product;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TradeValidator implements Validator<Trade> {

	private List<ComparisonResult> getComparisonResults(Trade o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradeHeader", (TradeHeader) o.getTradeHeader() != null ? 1 : 0, 0, 1), 
				checkCardinality("product", (Product) o.getProduct() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculationAgent", (CalculationAgent) o.getCalculationAgent() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculationAgentBusinessCenter", (BusinessCenter) o.getCalculationAgentBusinessCenter() != null ? 1 : 0, 0, 1), 
				checkCardinality("determiningParty", (List<? extends PartyReference>) o.getDeterminingParty() == null ? 0 : o.getDeterminingParty().size(), 0, 2), 
				checkCardinality("barrierDeterminationAgent", (PartyReference) o.getBarrierDeterminationAgent() != null ? 1 : 0, 0, 1), 
				checkCardinality("hedgingParty", (List<? extends PartyReference>) o.getHedgingParty() == null ? 0 : o.getHedgingParty().size(), 0, 2), 
				checkCardinality("collateral", (Collateral) o.getCollateral() != null ? 1 : 0, 0, 1), 
				checkCardinality("documentation", (Documentation) o.getDocumentation() != null ? 1 : 0, 0, 1), 
				checkCardinality("governingLaw", (GoverningLaw) o.getGoverningLaw() != null ? 1 : 0, 0, 1), 
				checkCardinality("allocations", (List<? extends Allocations>) o.getAllocations() == null ? 0 : o.getAllocations().size(), 0, 2), 
				checkCardinality("approvals", (Approvals) o.getApprovals() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Trade o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Trade", ValidationResult.ValidationType.CARDINALITY, "Trade", path, "", res.getError());
				}
				return success("Trade", ValidationResult.ValidationType.CARDINALITY, "Trade", path, "");
			})
			.collect(toList());
	}

}
