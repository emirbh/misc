package iso20022.auth030.hkma.dtcc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.dtcc.AssetClassDetailedSubProductType34Code;
import iso20022.auth030.hkma.dtcc.AssetClassProductType4Code;
import iso20022.auth030.hkma.dtcc.AssetClassSubProductType32Code;
import iso20022.auth030.hkma.dtcc.FreightCommodityWet3;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FreightCommodityWet3Validator implements Validator<FreightCommodityWet3> {

	private List<ComparisonResult> getComparisonResults(FreightCommodityWet3 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("basePdct", (AssetClassProductType4Code) o.getBasePdct() != null ? 1 : 0, 1, 1), 
				checkCardinality("subPdct", (AssetClassSubProductType32Code) o.getSubPdct() != null ? 1 : 0, 0, 1), 
				checkCardinality("addtlSubPdct", (AssetClassDetailedSubProductType34Code) o.getAddtlSubPdct() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FreightCommodityWet3 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FreightCommodityWet3", ValidationResult.ValidationType.CARDINALITY, "FreightCommodityWet3", path, "", res.getError());
				}
				return success("FreightCommodityWet3", ValidationResult.ValidationType.CARDINALITY, "FreightCommodityWet3", path, "");
			})
			.collect(toList());
	}

}
