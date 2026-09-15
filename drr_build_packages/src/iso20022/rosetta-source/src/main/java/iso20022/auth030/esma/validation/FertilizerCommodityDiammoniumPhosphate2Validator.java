package iso20022.auth030.esma.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.esma.AssetClassProductType5Code;
import iso20022.auth030.esma.AssetClassSubProductType40Code;
import iso20022.auth030.esma.FertilizerCommodityDiammoniumPhosphate2;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FertilizerCommodityDiammoniumPhosphate2Validator implements Validator<FertilizerCommodityDiammoniumPhosphate2> {

	private List<ComparisonResult> getComparisonResults(FertilizerCommodityDiammoniumPhosphate2 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("basePdct", (AssetClassProductType5Code) o.getBasePdct() != null ? 1 : 0, 1, 1), 
				checkCardinality("subPdct", (AssetClassSubProductType40Code) o.getSubPdct() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FertilizerCommodityDiammoniumPhosphate2 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FertilizerCommodityDiammoniumPhosphate2", ValidationResult.ValidationType.CARDINALITY, "FertilizerCommodityDiammoniumPhosphate2", path, "", res.getError());
				}
				return success("FertilizerCommodityDiammoniumPhosphate2", ValidationResult.ValidationType.CARDINALITY, "FertilizerCommodityDiammoniumPhosphate2", path, "");
			})
			.collect(toList());
	}

}
