package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityDeliveryPoint;
import fpml.consolidated.com.ElectricityDeliveryUnitFirm;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ElectricityDeliveryUnitFirmValidator implements Validator<ElectricityDeliveryUnitFirm> {

	private List<ComparisonResult> getComparisonResults(ElectricityDeliveryUnitFirm o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("applicable", (Boolean) o.getApplicable() != null ? 1 : 0, 0, 1), 
				checkCardinality("generationAsset", (CommodityDeliveryPoint) o.getGenerationAsset() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ElectricityDeliveryUnitFirm o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ElectricityDeliveryUnitFirm", ValidationResult.ValidationType.CARDINALITY, "ElectricityDeliveryUnitFirm", path, "", res.getError());
				}
				return success("ElectricityDeliveryUnitFirm", ValidationResult.ValidationType.CARDINALITY, "ElectricityDeliveryUnitFirm", path, "");
			})
			.collect(toList());
	}

}
