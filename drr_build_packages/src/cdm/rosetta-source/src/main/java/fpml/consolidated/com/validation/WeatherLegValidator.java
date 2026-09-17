package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CalculationPeriodsReference;
import fpml.consolidated.com.CommodityRelativePaymentDates;
import fpml.consolidated.com.WeatherCalculationPeriods;
import fpml.consolidated.com.WeatherIndex;
import fpml.consolidated.com.WeatherIndexData;
import fpml.consolidated.com.WeatherLeg;
import fpml.consolidated.com.WeatherLegCalculation;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.PartyReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class WeatherLegValidator implements Validator<WeatherLeg> {

	private List<ComparisonResult> getComparisonResults(WeatherLeg o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("payerPartyReference", (PartyReference) o.getPayerPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("payerAccountReference", (AccountReference) o.getPayerAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("receiverPartyReference", (PartyReference) o.getReceiverPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("receiverAccountReference", (AccountReference) o.getReceiverAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("weatherIndexLevel", (WeatherIndex) o.getWeatherIndexLevel() != null ? 1 : 0, 1, 1), 
				checkCardinality("weatherCalculationPeriods", (WeatherCalculationPeriods) o.getWeatherCalculationPeriods() != null ? 1 : 0, 0, 1), 
				checkCardinality("weatherCalculationPeriodsReference", (CalculationPeriodsReference) o.getWeatherCalculationPeriodsReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("weatherNotionalAmount", (NonNegativeMoney) o.getWeatherNotionalAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("calculation", (WeatherLegCalculation) o.getCalculation() != null ? 1 : 0, 1, 1), 
				checkCardinality("paymentDates", (CommodityRelativePaymentDates) o.getPaymentDates() != null ? 1 : 0, 0, 1), 
				checkCardinality("weatherIndexData", (WeatherIndexData) o.getWeatherIndexData() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, WeatherLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("WeatherLeg", ValidationResult.ValidationType.CARDINALITY, "WeatherLeg", path, "", res.getError());
				}
				return success("WeatherLeg", ValidationResult.ValidationType.CARDINALITY, "WeatherLeg", path, "");
			})
			.collect(toList());
	}

}
