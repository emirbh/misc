package drr.regulation.common.validation;

import cdm.event.common.TradeIdentifier;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.CommonAssetClass;
import drr.regulation.common.LastFloatingReference;
import drr.regulation.common.ValuationTradeInformation;
import drr.standards.iso.ActionTypeEnum;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ValuationTradeInformationValidator implements Validator<ValuationTradeInformation> {

	private List<ComparisonResult> getComparisonResults(ValuationTradeInformation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("uniqueTradeIdentifier", (TradeIdentifier) o.getUniqueTradeIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("action", (ActionTypeEnum) o.getAction() != null ? 1 : 0, 0, 1), 
				checkCardinality("nextFloatingReferenceResetDateLeg1", (Date) o.getNextFloatingReferenceResetDateLeg1() != null ? 1 : 0, 0, 1), 
				checkCardinality("nextFloatingReferenceResetDateLeg2", (Date) o.getNextFloatingReferenceResetDateLeg2() != null ? 1 : 0, 0, 1), 
				checkCardinality("lastFloatingReference", (LastFloatingReference) o.getLastFloatingReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("assetClass", (CommonAssetClass) o.getAssetClass() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ValuationTradeInformation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ValuationTradeInformation", ValidationResult.ValidationType.CARDINALITY, "ValuationTradeInformation", path, "", res.getError());
				}
				return success("ValuationTradeInformation", ValidationResult.ValidationType.CARDINALITY, "ValuationTradeInformation", path, "");
			})
			.collect(toList());
	}

}
