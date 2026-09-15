package iso20022.auth030.hkma.dtcc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.dtcc.AssetClassDetailedSubProductType8Code;
import iso20022.auth030.hkma.dtcc.AssetClassProductType3Code;
import iso20022.auth030.hkma.dtcc.AssetClassSubProductType10Code;
import iso20022.auth030.hkma.dtcc.EnvironmentalCommodityEmission3;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class EnvironmentalCommodityEmission3Validator implements Validator<EnvironmentalCommodityEmission3> {

	private List<ComparisonResult> getComparisonResults(EnvironmentalCommodityEmission3 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("basePdct", (AssetClassProductType3Code) o.getBasePdct() != null ? 1 : 0, 1, 1), 
				checkCardinality("subPdct", (AssetClassSubProductType10Code) o.getSubPdct() != null ? 1 : 0, 0, 1), 
				checkCardinality("addtlSubPdct", (AssetClassDetailedSubProductType8Code) o.getAddtlSubPdct() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EnvironmentalCommodityEmission3 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EnvironmentalCommodityEmission3", ValidationResult.ValidationType.CARDINALITY, "EnvironmentalCommodityEmission3", path, "", res.getError());
				}
				return success("EnvironmentalCommodityEmission3", ValidationResult.ValidationType.CARDINALITY, "EnvironmentalCommodityEmission3", path, "");
			})
			.collect(toList());
	}

}
