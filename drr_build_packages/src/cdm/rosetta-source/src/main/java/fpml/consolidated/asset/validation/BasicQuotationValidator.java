package fpml.consolidated.asset.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.AssetMeasureType;
import fpml.consolidated.asset.BasicQuotation;
import fpml.consolidated.asset.PriceQuoteUnits;
import fpml.consolidated.asset.PricingModel;
import fpml.consolidated.asset.QuoteTiming;
import fpml.consolidated.asset.ReportingCurrencyType;
import fpml.consolidated.fpmlenum.QuotationSideEnum;
import fpml.consolidated.shared.BusinessCenter;
import fpml.consolidated.shared.CashflowType;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.ExchangeId;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class BasicQuotationValidator implements Validator<BasicQuotation> {

	private List<ComparisonResult> getComparisonResults(BasicQuotation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("value", (BigDecimal) o.getValue() != null ? 1 : 0, 0, 1), 
				checkCardinality("measureType", (AssetMeasureType) o.getMeasureType() != null ? 1 : 0, 0, 1), 
				checkCardinality("quoteUnits", (PriceQuoteUnits) o.getQuoteUnits() != null ? 1 : 0, 0, 1), 
				checkCardinality("side", (QuotationSideEnum) o.getSide() != null ? 1 : 0, 0, 1), 
				checkCardinality("currency", (Currency) o.getCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("currencyType", (ReportingCurrencyType) o.getCurrencyType() != null ? 1 : 0, 0, 1), 
				checkCardinality("timing", (QuoteTiming) o.getTiming() != null ? 1 : 0, 0, 1), 
				checkCardinality("businessCenter", (BusinessCenter) o.getBusinessCenter() != null ? 1 : 0, 0, 1), 
				checkCardinality("exchangeId", (ExchangeId) o.getExchangeId() != null ? 1 : 0, 0, 1), 
				checkCardinality("pricingModel", (PricingModel) o.getPricingModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("time", (ZonedDateTime) o.getTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("valuationDate", (ZonedDateTime) o.getValuationDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("expiryTime", (ZonedDateTime) o.getExpiryTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("cashflowType", (CashflowType) o.getCashflowType() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, BasicQuotation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("BasicQuotation", ValidationResult.ValidationType.CARDINALITY, "BasicQuotation", path, "", res.getError());
				}
				return success("BasicQuotation", ValidationResult.ValidationType.CARDINALITY, "BasicQuotation", path, "");
			})
			.collect(toList());
	}

}
