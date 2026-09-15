package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CalculationPeriodsDatesReference;
import fpml.consolidated.com.CalculationPeriodsReference;
import fpml.consolidated.com.CalculationPeriodsScheduleReference;
import fpml.consolidated.com.CommodityCalculationPeriodsSchedule;
import fpml.consolidated.com.CommodityFixedPrice;
import fpml.consolidated.com.CommodityFixedPriceSchedule;
import fpml.consolidated.com.CommodityNotionalQuantity;
import fpml.consolidated.com.CommodityNotionalQuantitySchedule;
import fpml.consolidated.com.CommodityRelativePaymentDates;
import fpml.consolidated.com.FixedPriceLeg;
import fpml.consolidated.com.QuantityReference;
import fpml.consolidated.fpmlenum.FlatRateEnum;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AdjustableDates;
import fpml.consolidated.shared.AdjustableDatesOrRelativeDateOffset;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.PartyReference;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FixedPriceLegValidator implements Validator<FixedPriceLeg> {

	private List<ComparisonResult> getComparisonResults(FixedPriceLeg o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("payerPartyReference", (PartyReference) o.getPayerPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("payerAccountReference", (AccountReference) o.getPayerAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("receiverPartyReference", (PartyReference) o.getReceiverPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("receiverAccountReference", (AccountReference) o.getReceiverAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculationDates", (AdjustableDates) o.getCalculationDates() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculationPeriods", (AdjustableDates) o.getCalculationPeriods() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculationPeriodsSchedule", (CommodityCalculationPeriodsSchedule) o.getCalculationPeriodsSchedule() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculationPeriodsReference", (CalculationPeriodsReference) o.getCalculationPeriodsReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculationPeriodsScheduleReference", (CalculationPeriodsScheduleReference) o.getCalculationPeriodsScheduleReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculationPeriodsDatesReference", (CalculationPeriodsDatesReference) o.getCalculationPeriodsDatesReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("fixedPriceSchedule", (CommodityFixedPriceSchedule) o.getFixedPriceSchedule() != null ? 1 : 0, 0, 1), 
				checkCardinality("fixedPrice", (CommodityFixedPrice) o.getFixedPrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("worldscaleRate", (BigDecimal) o.getWorldscaleRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("contractRate", (NonNegativeMoney) o.getContractRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("totalPrice", (NonNegativeMoney) o.getTotalPrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("notionalQuantitySchedule", (CommodityNotionalQuantitySchedule) o.getNotionalQuantitySchedule() != null ? 1 : 0, 0, 1), 
				checkCardinality("notionalQuantity", (CommodityNotionalQuantity) o.getNotionalQuantity() != null ? 1 : 0, 0, 1), 
				checkCardinality("totalNotionalQuantity", (BigDecimal) o.getTotalNotionalQuantity() != null ? 1 : 0, 0, 1), 
				checkCardinality("quantityReference", (QuantityReference) o.getQuantityReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("relativePaymentDates", (CommodityRelativePaymentDates) o.getRelativePaymentDates() != null ? 1 : 0, 0, 1), 
				checkCardinality("paymentDates", (AdjustableDatesOrRelativeDateOffset) o.getPaymentDates() != null ? 1 : 0, 0, 1), 
				checkCardinality("masterAgreementPaymentDates", (Boolean) o.getMasterAgreementPaymentDates() != null ? 1 : 0, 0, 1), 
				checkCardinality("flatRate", (FlatRateEnum) o.getFlatRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("flatRateAmount", (NonNegativeMoney) o.getFlatRateAmount() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FixedPriceLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FixedPriceLeg", ValidationResult.ValidationType.CARDINALITY, "FixedPriceLeg", path, "", res.getError());
				}
				return success("FixedPriceLeg", ValidationResult.ValidationType.CARDINALITY, "FixedPriceLeg", path, "");
			})
			.collect(toList());
	}

}
