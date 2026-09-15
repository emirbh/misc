package iso20022.auth030.esma.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.esma.AgriculturalCommodityForestry2;
import iso20022.auth030.esma.AssetClassProductType1Code;
import iso20022.auth030.esma.AssetClassSubProductType21Code;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AgriculturalCommodityForestry2Validator implements Validator<AgriculturalCommodityForestry2> {

	private List<ComparisonResult> getComparisonResults(AgriculturalCommodityForestry2 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("basePdct", (AssetClassProductType1Code) o.getBasePdct() != null ? 1 : 0, 1, 1), 
				checkCardinality("subPdct", (AssetClassSubProductType21Code) o.getSubPdct() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AgriculturalCommodityForestry2 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AgriculturalCommodityForestry2", ValidationResult.ValidationType.CARDINALITY, "AgriculturalCommodityForestry2", path, "", res.getError());
				}
				return success("AgriculturalCommodityForestry2", ValidationResult.ValidationType.CARDINALITY, "AgriculturalCommodityForestry2", path, "");
			})
			.collect(toList());
	}

}
