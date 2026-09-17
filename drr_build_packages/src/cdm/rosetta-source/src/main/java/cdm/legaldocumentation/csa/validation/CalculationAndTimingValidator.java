package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.BespokeCalculationDate;
import cdm.legaldocumentation.csa.BespokeCalculationTime;
import cdm.legaldocumentation.csa.CalculationAgentTerms;
import cdm.legaldocumentation.csa.CalculationAndTiming;
import cdm.legaldocumentation.csa.CalculationDateLocation;
import cdm.legaldocumentation.csa.CollateralValuationAgent;
import cdm.legaldocumentation.csa.LegacyValuationAgent;
import cdm.legaldocumentation.csa.LegacyValuationDate;
import cdm.legaldocumentation.csa.LegacyValuationTime;
import cdm.legaldocumentation.csa.NotificationTime;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CalculationAndTimingValidator implements Validator<CalculationAndTiming> {

	private List<ComparisonResult> getComparisonResults(CalculationAndTiming o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("calculationAgentTerms", (CalculationAgentTerms) o.getCalculationAgentTerms() != null ? 1 : 0, 0, 1), 
				checkCardinality("bespokeCalculationDate", (BespokeCalculationDate) o.getBespokeCalculationDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("bespokeCalculationTime", (BespokeCalculationTime) o.getBespokeCalculationTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculationDateLocation", (CalculationDateLocation) o.getCalculationDateLocation() != null ? 1 : 0, 0, 1), 
				checkCardinality("notificationTime", (NotificationTime) o.getNotificationTime() != null ? 1 : 0, 1, 1), 
				checkCardinality("collateralValuationAgent", (CollateralValuationAgent) o.getCollateralValuationAgent() != null ? 1 : 0, 0, 1), 
				checkCardinality("cashSettlementDay", (String) o.getCashSettlementDay() != null ? 1 : 0, 0, 1), 
				checkCardinality("securitiesSettlementDay", (String) o.getSecuritiesSettlementDay() != null ? 1 : 0, 0, 1), 
				checkCardinality("legacyValuationDate", (LegacyValuationDate) o.getLegacyValuationDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("legacyValuationTime", (LegacyValuationTime) o.getLegacyValuationTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("legacyValuationAgent", (LegacyValuationAgent) o.getLegacyValuationAgent() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CalculationAndTiming o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CalculationAndTiming", ValidationResult.ValidationType.CARDINALITY, "CalculationAndTiming", path, "", res.getError());
				}
				return success("CalculationAndTiming", ValidationResult.ValidationType.CARDINALITY, "CalculationAndTiming", path, "");
			})
			.collect(toList());
	}

}
