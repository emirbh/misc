package drr.regulation.common.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.ReportableDelivery;
import drr.standards.iso.DurationType1Code;
import drr.standards.iso.EnergyQuantityUnit2Code;
import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ReportableDeliveryValidator implements Validator<ReportableDelivery> {

	private List<ComparisonResult> getComparisonResults(ReportableDelivery o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("deliveryStartTime", (LocalTime) o.getDeliveryStartTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("deliveryEndTime", (LocalTime) o.getDeliveryEndTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("deliveryStartDate", (Date) o.getDeliveryStartDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("deliveryEndDate", (Date) o.getDeliveryEndDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("duration", (DurationType1Code) o.getDuration() != null ? 1 : 0, 0, 1), 
				checkCardinality("deliveryCapacity", (BigDecimal) o.getDeliveryCapacity() != null ? 1 : 0, 0, 1), 
				checkCardinality("quantityUnit", (EnergyQuantityUnit2Code) o.getQuantityUnit() != null ? 1 : 0, 0, 1), 
				checkCardinality("priceTimeIntervalQuantity", (BigDecimal) o.getPriceTimeIntervalQuantity() != null ? 1 : 0, 0, 1), 
				checkCardinality("currencyOfThePriceTimeIntervalQuantity", (String) o.getCurrencyOfThePriceTimeIntervalQuantity() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReportableDelivery o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReportableDelivery", ValidationResult.ValidationType.CARDINALITY, "ReportableDelivery", path, "", res.getError());
				}
				return success("ReportableDelivery", ValidationResult.ValidationType.CARDINALITY, "ReportableDelivery", path, "");
			})
			.collect(toList());
	}

}
