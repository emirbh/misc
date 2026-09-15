package iso20022.auth030.hkma.dtcc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.dtcc.AssetClassProductType5Code;
import iso20022.auth030.hkma.dtcc.AssetClassSubProductType39Code;
import iso20022.auth030.hkma.dtcc.FertilizerCommodityAmmonia2;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FertilizerCommodityAmmonia2Validator implements Validator<FertilizerCommodityAmmonia2> {

	private List<ComparisonResult> getComparisonResults(FertilizerCommodityAmmonia2 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("basePdct", (AssetClassProductType5Code) o.getBasePdct() != null ? 1 : 0, 1, 1), 
				checkCardinality("subPdct", (AssetClassSubProductType39Code) o.getSubPdct() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FertilizerCommodityAmmonia2 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FertilizerCommodityAmmonia2", ValidationResult.ValidationType.CARDINALITY, "FertilizerCommodityAmmonia2", path, "", res.getError());
				}
				return success("FertilizerCommodityAmmonia2", ValidationResult.ValidationType.CARDINALITY, "FertilizerCommodityAmmonia2", path, "");
			})
			.collect(toList());
	}

}
