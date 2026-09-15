package iso20022.auth030.hkma.dtcc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.dtcc.AssetClassDetailedSubProductType10Code;
import iso20022.auth030.hkma.dtcc.AssetClassProductType7Code;
import iso20022.auth030.hkma.dtcc.AssetClassSubProductType15Code;
import iso20022.auth030.hkma.dtcc.MetalCommodityNonPrecious2;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class MetalCommodityNonPrecious2Validator implements Validator<MetalCommodityNonPrecious2> {

	private List<ComparisonResult> getComparisonResults(MetalCommodityNonPrecious2 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("basePdct", (AssetClassProductType7Code) o.getBasePdct() != null ? 1 : 0, 1, 1), 
				checkCardinality("subPdct", (AssetClassSubProductType15Code) o.getSubPdct() != null ? 1 : 0, 0, 1), 
				checkCardinality("addtlSubPdct", (AssetClassDetailedSubProductType10Code) o.getAddtlSubPdct() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MetalCommodityNonPrecious2 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MetalCommodityNonPrecious2", ValidationResult.ValidationType.CARDINALITY, "MetalCommodityNonPrecious2", path, "", res.getError());
				}
				return success("MetalCommodityNonPrecious2", ValidationResult.ValidationType.CARDINALITY, "MetalCommodityNonPrecious2", path, "");
			})
			.collect(toList());
	}

}
