package iso20022.auth030.esma.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.esma.AssetClassDetailedSubProductType33Code;
import iso20022.auth030.esma.AssetClassProductType4Code;
import iso20022.auth030.esma.AssetClassSubProductType31Code;
import iso20022.auth030.esma.FreightCommodityDry3;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FreightCommodityDry3Validator implements Validator<FreightCommodityDry3> {

	private List<ComparisonResult> getComparisonResults(FreightCommodityDry3 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("basePdct", (AssetClassProductType4Code) o.getBasePdct() != null ? 1 : 0, 1, 1), 
				checkCardinality("subPdct", (AssetClassSubProductType31Code) o.getSubPdct() != null ? 1 : 0, 0, 1), 
				checkCardinality("addtlSubPdct", (AssetClassDetailedSubProductType33Code) o.getAddtlSubPdct() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FreightCommodityDry3 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FreightCommodityDry3", ValidationResult.ValidationType.CARDINALITY, "FreightCommodityDry3", path, "", res.getError());
				}
				return success("FreightCommodityDry3", ValidationResult.ValidationType.CARDINALITY, "FreightCommodityDry3", path, "");
			})
			.collect(toList());
	}

}
