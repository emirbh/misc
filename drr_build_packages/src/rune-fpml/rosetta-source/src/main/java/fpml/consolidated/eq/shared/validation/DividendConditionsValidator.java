package fpml.consolidated.eq.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.eq.shared.DividendConditions;
import fpml.consolidated.eq.shared.DividendPaymentDate;
import fpml.consolidated.fpmlenum.DividendAmountTypeEnum;
import fpml.consolidated.fpmlenum.DividendCompositionEnum;
import fpml.consolidated.fpmlenum.DividendEntitlementEnum;
import fpml.consolidated.fpmlenum.DividendPeriodEnum;
import fpml.consolidated.fpmlenum.NonCashDividendTreatmentEnum;
import fpml.consolidated.shared.DateReference;
import fpml.consolidated.shared.DeterminationMethod;
import fpml.consolidated.shared.IdentifiedCurrency;
import fpml.consolidated.shared.IdentifiedCurrencyReference;
import fpml.consolidated.shared.InterestAccrualsCompoundingMethod;
import fpml.consolidated.shared.PartyReference;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class DividendConditionsValidator implements Validator<DividendConditions> {

	private List<ComparisonResult> getComparisonResults(DividendConditions o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("dividendReinvestment", (Boolean) o.getDividendReinvestment() != null ? 1 : 0, 0, 1), 
				checkCardinality("dividendEntitlement", (DividendEntitlementEnum) o.getDividendEntitlement() != null ? 1 : 0, 0, 1), 
				checkCardinality("dividendAmount", (DividendAmountTypeEnum) o.getDividendAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("dividendPaymentDate", (DividendPaymentDate) o.getDividendPaymentDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("dividendPeriodEffectiveDate", (DateReference) o.getDividendPeriodEffectiveDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("dividendPeriodEndDate", (DateReference) o.getDividendPeriodEndDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("dividendPeriod", (DividendPeriodEnum) o.getDividendPeriod() != null ? 1 : 0, 0, 1), 
				checkCardinality("extraOrdinaryDividends", (PartyReference) o.getExtraOrdinaryDividends() != null ? 1 : 0, 0, 1), 
				checkCardinality("excessDividendAmount", (DividendAmountTypeEnum) o.getExcessDividendAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("currency", (IdentifiedCurrency) o.getCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("determinationMethod", (DeterminationMethod) o.getDeterminationMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("currencyReference", (IdentifiedCurrencyReference) o.getCurrencyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("dividendFxTriggerDate", (DividendPaymentDate) o.getDividendFxTriggerDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("interestAccrualsMethod", (InterestAccrualsCompoundingMethod) o.getInterestAccrualsMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("numberOfIndexUnits", (BigDecimal) o.getNumberOfIndexUnits() != null ? 1 : 0, 0, 1), 
				checkCardinality("declaredCashDividendPercentage", (BigDecimal) o.getDeclaredCashDividendPercentage() != null ? 1 : 0, 0, 1), 
				checkCardinality("declaredCashEquivalentDividendPercentage", (BigDecimal) o.getDeclaredCashEquivalentDividendPercentage() != null ? 1 : 0, 0, 1), 
				checkCardinality("nonCashDividendTreatment", (NonCashDividendTreatmentEnum) o.getNonCashDividendTreatment() != null ? 1 : 0, 0, 1), 
				checkCardinality("dividendComposition", (DividendCompositionEnum) o.getDividendComposition() != null ? 1 : 0, 0, 1), 
				checkCardinality("specialDividends", (Boolean) o.getSpecialDividends() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DividendConditions o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DividendConditions", ValidationResult.ValidationType.CARDINALITY, "DividendConditions", path, "", res.getError());
				}
				return success("DividendConditions", ValidationResult.ValidationType.CARDINALITY, "DividendConditions", path, "");
			})
			.collect(toList());
	}

}
