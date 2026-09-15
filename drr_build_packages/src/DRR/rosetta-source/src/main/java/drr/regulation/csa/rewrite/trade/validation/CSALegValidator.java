package drr.regulation.csa.rewrite.trade.validation;

import cdm.base.staticdata.asset.common.ISOCountryCodeEnum;
import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.trade.price.PriceFormat;
import drr.base.trade.price.PriceNotationEnum;
import drr.regulation.common.trade.payment.CommonPeriodicPayment;
import drr.regulation.csa.rewrite.trade.CSALeg;
import drr.standards.iso.Direction2Enum;
import drr.standards.iso.FrequencyPeriodEnum;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CSALegValidator implements Validator<CSALeg> {

	private List<ComparisonResult> getComparisonResults(CSALeg o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("periodicPayment", (CommonPeriodicPayment) o.getPeriodicPayment() != null ? 1 : 0, 0, 1), 
				checkCardinality("notionalAmount", (BigDecimal) o.getNotionalAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("notionalCurrency", (ISOCurrencyCodeEnum) o.getNotionalCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("totalNotionalQuantity", (BigDecimal) o.getTotalNotionalQuantity() != null ? 1 : 0, 0, 1), 
				checkCardinality("fixedRate", (BigDecimal) o.getFixedRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementCurrency", (ISOCurrencyCodeEnum) o.getSettlementCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("spread", (PriceFormat) o.getSpread() != null ? 1 : 0, 0, 1), 
				checkCardinality("spreadNotation", (PriceNotationEnum) o.getSpreadNotation() != null ? 1 : 0, 0, 1), 
				checkCardinality("spreadCurrency", (ISOCurrencyCodeEnum) o.getSpreadCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("quantityUnitOfMeasure", (String) o.getQuantityUnitOfMeasure() != null ? 1 : 0, 0, 1), 
				checkCardinality("direction2", (Direction2Enum) o.getDirection2() != null ? 1 : 0, 0, 1), 
				checkCardinality("notionalQuantity", (BigDecimal) o.getNotionalQuantity() != null ? 1 : 0, 0, 1), 
				checkCardinality("fixingDate", (ZonedDateTime) o.getFixingDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("quantityFrequency", (FrequencyPeriodEnum) o.getQuantityFrequency() != null ? 1 : 0, 0, 1), 
				checkCardinality("quantityFrequencyMultiplier", (Integer) o.getQuantityFrequencyMultiplier() != null ? 1 : 0, 0, 1), 
				checkCardinality("payerIdentifier", (String) o.getPayerIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("receiverIdentifier", (String) o.getReceiverIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementLocation", (ISOCountryCodeEnum) o.getSettlementLocation() != null ? 1 : 0, 0, 1), 
				checkCardinality("nextFloatingReferenceResetDate", (Date) o.getNextFloatingReferenceResetDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("underlierIDOther", (String) o.getUnderlierIDOther() != null ? 1 : 0, 0, 1), 
				checkCardinality("underlierIDOtherSource", (String) o.getUnderlierIDOtherSource() != null ? 1 : 0, 0, 1), 
				checkCardinality("underlyingAssetTradingPlatformIdentifier", (String) o.getUnderlyingAssetTradingPlatformIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("underlyingAssetPriceSource", (String) o.getUnderlyingAssetPriceSource() != null ? 1 : 0, 0, 1), 
				checkCardinality("cryptoAssetUnderlyingIndicator", (Boolean) o.getCryptoAssetUnderlyingIndicator() != null ? 1 : 0, 0, 1), 
				checkCardinality("commodityUnderlyerID", (String) o.getCommodityUnderlyerID() != null ? 1 : 0, 0, 1), 
				checkCardinality("commodityInstrumentID", (String) o.getCommodityInstrumentID() != null ? 1 : 0, 0, 1), 
				checkCardinality("floatingRateIndex", (String) o.getFloatingRateIndex() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSALeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CSALeg", ValidationResult.ValidationType.CARDINALITY, "CSALeg", path, "", res.getError());
				}
				return success("CSALeg", ValidationResult.ValidationType.CARDINALITY, "CSALeg", path, "");
			})
			.collect(toList());
	}

}
