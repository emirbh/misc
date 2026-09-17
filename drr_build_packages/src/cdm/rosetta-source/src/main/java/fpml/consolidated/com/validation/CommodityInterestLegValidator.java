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
import fpml.consolidated.com.CommodityFixedInterestCalculation;
import fpml.consolidated.com.CommodityInterestLeg;
import fpml.consolidated.com.CommodityNotionalAmount;
import fpml.consolidated.com.CommodityNotionalAmountReference;
import fpml.consolidated.com.CommodityRelativePaymentDates;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AdjustableDates;
import fpml.consolidated.shared.AdjustableDatesOrRelativeDateOffset;
import fpml.consolidated.shared.PartyReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CommodityInterestLegValidator implements Validator<CommodityInterestLeg> {

	private List<ComparisonResult> getComparisonResults(CommodityInterestLeg o) {
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
				checkCardinality("relativePaymentDates", (CommodityRelativePaymentDates) o.getRelativePaymentDates() != null ? 1 : 0, 0, 1), 
				checkCardinality("paymentDates", (AdjustableDatesOrRelativeDateOffset) o.getPaymentDates() != null ? 1 : 0, 0, 1), 
				checkCardinality("masterAgreementPaymentDates", (Boolean) o.getMasterAgreementPaymentDates() != null ? 1 : 0, 0, 1), 
				checkCardinality("notionalAmount", (CommodityNotionalAmount) o.getNotionalAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("notionalAmountReference", (CommodityNotionalAmountReference) o.getNotionalAmountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("commodityFixedInterestCalculation", (CommodityFixedInterestCalculation) o.getCommodityFixedInterestCalculation() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityInterestLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityInterestLeg", ValidationResult.ValidationType.CARDINALITY, "CommodityInterestLeg", path, "", res.getError());
				}
				return success("CommodityInterestLeg", ValidationResult.ValidationType.CARDINALITY, "CommodityInterestLeg", path, "");
			})
			.collect(toList());
	}

}
