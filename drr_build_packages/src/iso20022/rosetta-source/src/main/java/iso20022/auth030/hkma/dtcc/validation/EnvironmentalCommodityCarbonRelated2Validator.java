package iso20022.auth030.hkma.dtcc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.dtcc.AssetClassProductType3Code;
import iso20022.auth030.hkma.dtcc.AssetClassSubProductType29Code;
import iso20022.auth030.hkma.dtcc.EnvironmentalCommodityCarbonRelated2;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class EnvironmentalCommodityCarbonRelated2Validator implements Validator<EnvironmentalCommodityCarbonRelated2> {

	private List<ComparisonResult> getComparisonResults(EnvironmentalCommodityCarbonRelated2 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("basePdct", (AssetClassProductType3Code) o.getBasePdct() != null ? 1 : 0, 1, 1), 
				checkCardinality("subPdct", (AssetClassSubProductType29Code) o.getSubPdct() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EnvironmentalCommodityCarbonRelated2 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EnvironmentalCommodityCarbonRelated2", ValidationResult.ValidationType.CARDINALITY, "EnvironmentalCommodityCarbonRelated2", path, "", res.getError());
				}
				return success("EnvironmentalCommodityCarbonRelated2", ValidationResult.ValidationType.CARDINALITY, "EnvironmentalCommodityCarbonRelated2", path, "");
			})
			.collect(toList());
	}

}
