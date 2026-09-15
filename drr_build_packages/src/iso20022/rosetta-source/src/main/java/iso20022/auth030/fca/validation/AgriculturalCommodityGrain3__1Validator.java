package iso20022.auth030.fca.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.fca.AgriculturalCommodityGrain3__1;
import iso20022.auth030.fca.AssetClassDetailedSubProductType30Code;
import iso20022.auth030.fca.AssetClassProductType1Code;
import iso20022.auth030.fca.AssetClassSubProductType5Code;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AgriculturalCommodityGrain3__1Validator implements Validator<AgriculturalCommodityGrain3__1> {

	private List<ComparisonResult> getComparisonResults(AgriculturalCommodityGrain3__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("basePdct", (AssetClassProductType1Code) o.getBasePdct() != null ? 1 : 0, 1, 1), 
				checkCardinality("subPdct", (AssetClassSubProductType5Code) o.getSubPdct() != null ? 1 : 0, 1, 1), 
				checkCardinality("addtlSubPdct", (AssetClassDetailedSubProductType30Code) o.getAddtlSubPdct() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AgriculturalCommodityGrain3__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AgriculturalCommodityGrain3__1", ValidationResult.ValidationType.CARDINALITY, "AgriculturalCommodityGrain3__1", path, "", res.getError());
				}
				return success("AgriculturalCommodityGrain3__1", ValidationResult.ValidationType.CARDINALITY, "AgriculturalCommodityGrain3__1", path, "");
			})
			.collect(toList());
	}

}
