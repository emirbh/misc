package drr.standards.iosco.cde.version2.validation;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.trade.payment.PeriodicPayment;
import drr.base.trade.price.PriceFormat;
import drr.base.trade.price.PriceNotationEnum;
import drr.standards.iosco.cde.version2.LegV2;
import drr.standards.iso.Direction2Enum;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LegV2Validator implements Validator<LegV2> {

	private List<ComparisonResult> getComparisonResults(LegV2 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("periodicPayment", (PeriodicPayment) o.getPeriodicPayment() != null ? 1 : 0, 0, 1), 
				checkCardinality("notionalAmount", (BigDecimal) o.getNotionalAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("notionalCurrency", (ISOCurrencyCodeEnum) o.getNotionalCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("totalNotionalQuantity", (BigDecimal) o.getTotalNotionalQuantity() != null ? 1 : 0, 0, 1), 
				checkCardinality("fixedRate", (BigDecimal) o.getFixedRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementCurrency", (ISOCurrencyCodeEnum) o.getSettlementCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("spread", (PriceFormat) o.getSpread() != null ? 1 : 0, 0, 1), 
				checkCardinality("spreadNotation", (PriceNotationEnum) o.getSpreadNotation() != null ? 1 : 0, 0, 1), 
				checkCardinality("spreadCurrency", (ISOCurrencyCodeEnum) o.getSpreadCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("quantityUnitOfMeasure", (String) o.getQuantityUnitOfMeasure() != null ? 1 : 0, 0, 1), 
				checkCardinality("direction2", (Direction2Enum) o.getDirection2() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LegV2 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LegV2", ValidationResult.ValidationType.CARDINALITY, "LegV2", path, "", res.getError());
				}
				return success("LegV2", ValidationResult.ValidationType.CARDINALITY, "LegV2", path, "");
			})
			.collect(toList());
	}

}
