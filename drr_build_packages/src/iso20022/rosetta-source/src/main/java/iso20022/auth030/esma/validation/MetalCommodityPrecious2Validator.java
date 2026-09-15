package iso20022.auth030.esma.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.esma.AssetClassDetailedSubProductType11Code;
import iso20022.auth030.esma.AssetClassProductType7Code;
import iso20022.auth030.esma.AssetClassSubProductType16Code;
import iso20022.auth030.esma.MetalCommodityPrecious2;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class MetalCommodityPrecious2Validator implements Validator<MetalCommodityPrecious2> {

	private List<ComparisonResult> getComparisonResults(MetalCommodityPrecious2 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("basePdct", (AssetClassProductType7Code) o.getBasePdct() != null ? 1 : 0, 1, 1), 
				checkCardinality("subPdct", (AssetClassSubProductType16Code) o.getSubPdct() != null ? 1 : 0, 0, 1), 
				checkCardinality("addtlSubPdct", (AssetClassDetailedSubProductType11Code) o.getAddtlSubPdct() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MetalCommodityPrecious2 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MetalCommodityPrecious2", ValidationResult.ValidationType.CARDINALITY, "MetalCommodityPrecious2", path, "", res.getError());
				}
				return success("MetalCommodityPrecious2", ValidationResult.ValidationType.CARDINALITY, "MetalCommodityPrecious2", path, "");
			})
			.collect(toList());
	}

}
