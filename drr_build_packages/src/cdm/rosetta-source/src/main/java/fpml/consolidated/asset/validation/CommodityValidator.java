package fpml.consolidated.asset.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.Commodity;
import fpml.consolidated.asset.CommodityBase;
import fpml.consolidated.asset.CommodityDetails;
import fpml.consolidated.asset.CommodityInformationSource;
import fpml.consolidated.asset.DeliveryNearby;
import fpml.consolidated.asset.QuantityUnit;
import fpml.consolidated.fpmlenum.DeliveryDatesEnum;
import fpml.consolidated.fpmlenum.SpecifiedPriceEnum;
import fpml.consolidated.shared.AdjustableDate;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.ExchangeId;
import fpml.consolidated.shared.InstrumentId;
import fpml.consolidated.shared.Offset;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CommodityValidator implements Validator<Commodity> {

	private List<ComparisonResult> getComparisonResults(Commodity o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("instrumentId", (List<? extends InstrumentId>) o.getInstrumentId() == null ? 0 : o.getInstrumentId().size(), 1, 0), 
				checkCardinality("description", (String) o.getDescription() != null ? 1 : 0, 0, 1), 
				checkCardinality("commodityBase", (CommodityBase) o.getCommodityBase() != null ? 1 : 0, 0, 1), 
				checkCardinality("commodityDetails", (CommodityDetails) o.getCommodityDetails() != null ? 1 : 0, 0, 1), 
				checkCardinality("unit", (QuantityUnit) o.getUnit() != null ? 1 : 0, 0, 1), 
				checkCardinality("currency", (Currency) o.getCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("exchangeId", (ExchangeId) o.getExchangeId() != null ? 1 : 0, 0, 1), 
				checkCardinality("publication", (CommodityInformationSource) o.getPublication() != null ? 1 : 0, 0, 1), 
				checkCardinality("specifiedPrice", (SpecifiedPriceEnum) o.getSpecifiedPrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("deliveryDates", (DeliveryDatesEnum) o.getDeliveryDates() != null ? 1 : 0, 0, 1), 
				checkCardinality("deliveryNearby", (DeliveryNearby) o.getDeliveryNearby() != null ? 1 : 0, 0, 1), 
				checkCardinality("deliveryDate", (AdjustableDate) o.getDeliveryDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("deliveryDateYearMonth", (String) o.getDeliveryDateYearMonth() != null ? 1 : 0, 0, 1), 
				checkCardinality("deliveryDateRollConvention", (Offset) o.getDeliveryDateRollConvention() != null ? 1 : 0, 0, 1), 
				checkCardinality("deliveryDateExpirationConvention", (Offset) o.getDeliveryDateExpirationConvention() != null ? 1 : 0, 0, 1), 
				checkCardinality("multiplier", (BigDecimal) o.getMultiplier() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Commodity o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Commodity", ValidationResult.ValidationType.CARDINALITY, "Commodity", path, "", res.getError());
				}
				return success("Commodity", ValidationResult.ValidationType.CARDINALITY, "Commodity", path, "");
			})
			.collect(toList());
	}

}
