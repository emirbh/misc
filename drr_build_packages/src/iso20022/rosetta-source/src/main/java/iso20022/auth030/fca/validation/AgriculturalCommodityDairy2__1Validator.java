package iso20022.auth030.fca.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.fca.AgriculturalCommodityDairy2__1;
import iso20022.auth030.fca.AssetClassProductType1Code;
import iso20022.auth030.fca.AssetClassSubProductType20Code;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AgriculturalCommodityDairy2__1Validator implements Validator<AgriculturalCommodityDairy2__1> {

	private List<ComparisonResult> getComparisonResults(AgriculturalCommodityDairy2__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("basePdct", (AssetClassProductType1Code) o.getBasePdct() != null ? 1 : 0, 1, 1), 
				checkCardinality("subPdct", (AssetClassSubProductType20Code) o.getSubPdct() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AgriculturalCommodityDairy2__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AgriculturalCommodityDairy2__1", ValidationResult.ValidationType.CARDINALITY, "AgriculturalCommodityDairy2__1", path, "", res.getError());
				}
				return success("AgriculturalCommodityDairy2__1", ValidationResult.ValidationType.CARDINALITY, "AgriculturalCommodityDairy2__1", path, "");
			})
			.collect(toList());
	}

}
