package fpml.consolidated.doc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.PackageSummary;
import fpml.consolidated.doc.ProductSummary;
import fpml.consolidated.doc.TradeHeader;
import fpml.consolidated.doc.TradeSummary;
import fpml.consolidated.shared.IdentifiedDate;
import fpml.consolidated.shared.IssuerTradeId;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TradeHeaderValidator implements Validator<TradeHeader> {

	private List<ComparisonResult> getComparisonResults(TradeHeader o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("uniqueSwapIdentifier", (IssuerTradeId) o.getUniqueSwapIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("uniqueTransactionIdentifier", (IssuerTradeId) o.getUniqueTransactionIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradeSummary", (TradeSummary) o.getTradeSummary() != null ? 1 : 0, 0, 1), 
				checkCardinality("productSummary", (ProductSummary) o.getProductSummary() != null ? 1 : 0, 0, 1), 
				checkCardinality("originatingPackage", (PackageSummary) o.getOriginatingPackage() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradeDate", (IdentifiedDate) o.getTradeDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("clearedDate", (IdentifiedDate) o.getClearedDate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeHeader o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeHeader", ValidationResult.ValidationType.CARDINALITY, "TradeHeader", path, "", res.getError());
				}
				return success("TradeHeader", ValidationResult.ValidationType.CARDINALITY, "TradeHeader", path, "");
			})
			.collect(toList());
	}

}
