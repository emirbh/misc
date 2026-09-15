package fpml.consolidated.ird.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.ActualPrice;
import fpml.consolidated.asset.QuotationCharacteristics;
import fpml.consolidated.asset.Underlyer;
import fpml.consolidated.fpmlenum.SettlementTypeEnum;
import fpml.consolidated.ird.InflationRate;
import fpml.consolidated.ird.ReturnCalculation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ReturnCalculationValidator implements Validator<ReturnCalculation> {

	private List<ComparisonResult> getComparisonResults(ReturnCalculation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("underlyer", (Underlyer) o.getUnderlyer() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementType", (SettlementTypeEnum) o.getSettlementType() != null ? 1 : 0, 0, 1), 
				checkCardinality("finalValuation", (QuotationCharacteristics) o.getFinalValuation() != null ? 1 : 0, 0, 1), 
				checkCardinality("inflationRate", (InflationRate) o.getInflationRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("initialPrice", (ActualPrice) o.getInitialPrice() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReturnCalculation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReturnCalculation", ValidationResult.ValidationType.CARDINALITY, "ReturnCalculation", path, "", res.getError());
				}
				return success("ReturnCalculation", ValidationResult.ValidationType.CARDINALITY, "ReturnCalculation", path, "");
			})
			.collect(toList());
	}

}
