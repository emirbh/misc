package iso20022.auth030.hkma.dtcc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.dtcc.AgriculturalCommodityOilSeed2;
import iso20022.auth030.hkma.dtcc.AssetClassDetailedSubProductType1Code;
import iso20022.auth030.hkma.dtcc.AssetClassProductType1Code;
import iso20022.auth030.hkma.dtcc.AssetClassSubProductType1Code;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AgriculturalCommodityOilSeed2Validator implements Validator<AgriculturalCommodityOilSeed2> {

	private List<ComparisonResult> getComparisonResults(AgriculturalCommodityOilSeed2 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("basePdct", (AssetClassProductType1Code) o.getBasePdct() != null ? 1 : 0, 1, 1), 
				checkCardinality("subPdct", (AssetClassSubProductType1Code) o.getSubPdct() != null ? 1 : 0, 0, 1), 
				checkCardinality("addtlSubPdct", (AssetClassDetailedSubProductType1Code) o.getAddtlSubPdct() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AgriculturalCommodityOilSeed2 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AgriculturalCommodityOilSeed2", ValidationResult.ValidationType.CARDINALITY, "AgriculturalCommodityOilSeed2", path, "", res.getError());
				}
				return success("AgriculturalCommodityOilSeed2", ValidationResult.ValidationType.CARDINALITY, "AgriculturalCommodityOilSeed2", path, "");
			})
			.collect(toList());
	}

}
