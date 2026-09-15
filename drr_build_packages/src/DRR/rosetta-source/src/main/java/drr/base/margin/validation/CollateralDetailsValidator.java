package drr.base.margin.validation;

import cdm.event.common.TradeIdentifier;
import cdm.product.collateral.Collateral;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.margin.CollateralDetails;
import drr.standards.iso.CollateralisationType3Code;
import drr.standards.iso.MarginActionEnum;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CollateralDetailsValidator implements Validator<CollateralDetails> {

	private List<ComparisonResult> getComparisonResults(CollateralDetails o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("collateralTimestamp", (ZonedDateTime) o.getCollateralTimestamp() != null ? 1 : 0, 1, 1), 
				checkCardinality("collateral", (Collateral) o.getCollateral() != null ? 1 : 0, 0, 1), 
				checkCardinality("uniqueTradeIdentifier", (TradeIdentifier) o.getUniqueTradeIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("action", (MarginActionEnum) o.getAction() != null ? 1 : 0, 0, 1), 
				checkCardinality("collateralisationCategory", (CollateralisationType3Code) o.getCollateralisationCategory() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralDetails o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CollateralDetails", ValidationResult.ValidationType.CARDINALITY, "CollateralDetails", path, "", res.getError());
				}
				return success("CollateralDetails", ValidationResult.ValidationType.CARDINALITY, "CollateralDetails", path, "");
			})
			.collect(toList());
	}

}
