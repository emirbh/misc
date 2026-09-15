package drr.regulation.common.validation;

import cdm.event.common.TradeIdentifier;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.CommodityTimeUnitEnum;
import drr.regulation.common.ReportableExecutionVenue;
import drr.regulation.common.TradableOnTradingVenueEnum;
import drr.regulation.common.TransactionInformation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TransactionInformationValidator implements Validator<TransactionInformation> {

	private List<ComparisonResult> getComparisonResults(TransactionInformation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("transactionIdentifier", (TradeIdentifier) o.getTransactionIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("priorTransactionIdentifier", (TradeIdentifier) o.getPriorTransactionIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("reportableExecutionVenue", (ReportableExecutionVenue) o.getReportableExecutionVenue() != null ? 1 : 0, 1, 1), 
				checkCardinality("largeSizeTrade", (Boolean) o.getLargeSizeTrade() != null ? 1 : 0, 0, 1), 
				checkCardinality("duration", (CommodityTimeUnitEnum) o.getDuration() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradableOnTradingVenue", (TradableOnTradingVenueEnum) o.getTradableOnTradingVenue() != null ? 1 : 0, 0, 1), 
				checkCardinality("underlierTradedOnTradingVenue", (Boolean) o.getUnderlierTradedOnTradingVenue() != null ? 1 : 0, 0, 1), 
				checkCardinality("underlierAssetTradingPlatformIdentifier", (String) o.getUnderlierAssetTradingPlatformIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("internalTradeIdentifier", (String) o.getInternalTradeIdentifier() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TransactionInformation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TransactionInformation", ValidationResult.ValidationType.CARDINALITY, "TransactionInformation", path, "", res.getError());
				}
				return success("TransactionInformation", ValidationResult.ValidationType.CARDINALITY, "TransactionInformation", path, "");
			})
			.collect(toList());
	}

}
