package fpml.consolidated.riskdef.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.AssetReference;
import fpml.consolidated.asset.PriceQuoteUnits;
import fpml.consolidated.riskdef.AssetOrTermPointOrPricingStructureReference;
import fpml.consolidated.riskdef.PricingParameterShift;
import fpml.consolidated.riskdef.TermPointReference;
import fpml.consolidated.shared.PricingStructureReference;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PricingParameterShiftValidator implements Validator<PricingParameterShift> {

	private List<ComparisonResult> getComparisonResults(PricingParameterShift o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("parameterReference", (AssetOrTermPointOrPricingStructureReference) o.getParameterReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("assetReference", (AssetReference) o.getAssetReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("termPointReference", (TermPointReference) o.getTermPointReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("pricingStructureReference", (PricingStructureReference) o.getPricingStructureReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("shift", (BigDecimal) o.getShift() != null ? 1 : 0, 0, 1), 
				checkCardinality("shiftUnits", (PriceQuoteUnits) o.getShiftUnits() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PricingParameterShift o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PricingParameterShift", ValidationResult.ValidationType.CARDINALITY, "PricingParameterShift", path, "", res.getError());
				}
				return success("PricingParameterShift", ValidationResult.ValidationType.CARDINALITY, "PricingParameterShift", path, "");
			})
			.collect(toList());
	}

}
