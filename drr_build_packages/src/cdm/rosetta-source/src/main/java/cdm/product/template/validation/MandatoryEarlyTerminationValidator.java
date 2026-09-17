package cdm.product.template.validation;

import cdm.base.datetime.AdjustableDate;
import cdm.observable.asset.CalculationAgent;
import cdm.product.common.settlement.SettlementTerms;
import cdm.product.template.MandatoryEarlyTermination;
import cdm.product.template.MandatoryEarlyTerminationAdjustedDates;
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

public class MandatoryEarlyTerminationValidator implements Validator<MandatoryEarlyTermination> {

	private List<ComparisonResult> getComparisonResults(MandatoryEarlyTermination o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("mandatoryEarlyTerminationDate", (AdjustableDate) o.getMandatoryEarlyTerminationDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("calculationAgent", (CalculationAgent) o.getCalculationAgent() != null ? 1 : 0, 1, 1), 
				checkCardinality("cashSettlement", (SettlementTerms) o.getCashSettlement() != null ? 1 : 0, 1, 1), 
				checkCardinality("mandatoryEarlyTerminationAdjustedDates", (MandatoryEarlyTerminationAdjustedDates) o.getMandatoryEarlyTerminationAdjustedDates() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MandatoryEarlyTermination o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MandatoryEarlyTermination", ValidationResult.ValidationType.CARDINALITY, "MandatoryEarlyTermination", path, "", res.getError());
				}
				return success("MandatoryEarlyTermination", ValidationResult.ValidationType.CARDINALITY, "MandatoryEarlyTermination", path, "");
			})
			.collect(toList());
	}

}
