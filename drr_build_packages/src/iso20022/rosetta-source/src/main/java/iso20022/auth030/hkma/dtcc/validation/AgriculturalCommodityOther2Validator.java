package iso20022.auth030.hkma.dtcc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.dtcc.AgriculturalCommodityOther2;
import iso20022.auth030.hkma.dtcc.AssetClassProductType1Code;
import iso20022.auth030.hkma.dtcc.AssetClassSubProductType49Code;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AgriculturalCommodityOther2Validator implements Validator<AgriculturalCommodityOther2> {

	private List<ComparisonResult> getComparisonResults(AgriculturalCommodityOther2 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("basePdct", (AssetClassProductType1Code) o.getBasePdct() != null ? 1 : 0, 1, 1), 
				checkCardinality("subPdct", (AssetClassSubProductType49Code) o.getSubPdct() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AgriculturalCommodityOther2 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AgriculturalCommodityOther2", ValidationResult.ValidationType.CARDINALITY, "AgriculturalCommodityOther2", path, "", res.getError());
				}
				return success("AgriculturalCommodityOther2", ValidationResult.ValidationType.CARDINALITY, "AgriculturalCommodityOther2", path, "");
			})
			.collect(toList());
	}

}
