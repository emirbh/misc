package iso20022.auth030.hkma.tr.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.tr.AssetClassProductType5Code;
import iso20022.auth030.hkma.tr.AssetClassSubProductType42Code;
import iso20022.auth030.hkma.tr.FertilizerCommoditySulphur2;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FertilizerCommoditySulphur2Validator implements Validator<FertilizerCommoditySulphur2> {

	private List<ComparisonResult> getComparisonResults(FertilizerCommoditySulphur2 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("basePdct", (AssetClassProductType5Code) o.getBasePdct() != null ? 1 : 0, 1, 1), 
				checkCardinality("subPdct", (AssetClassSubProductType42Code) o.getSubPdct() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FertilizerCommoditySulphur2 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FertilizerCommoditySulphur2", ValidationResult.ValidationType.CARDINALITY, "FertilizerCommoditySulphur2", path, "", res.getError());
				}
				return success("FertilizerCommoditySulphur2", ValidationResult.ValidationType.CARDINALITY, "FertilizerCommoditySulphur2", path, "");
			})
			.collect(toList());
	}

}
