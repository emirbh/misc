package iso20022.auth030.esma.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.esma.AssetClassDetailedSubProductType32Code;
import iso20022.auth030.esma.AssetClassProductType2Code;
import iso20022.auth030.esma.AssetClassSubProductType8Code;
import iso20022.auth030.esma.EnergyCommodityOil3;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class EnergyCommodityOil3Validator implements Validator<EnergyCommodityOil3> {

	private List<ComparisonResult> getComparisonResults(EnergyCommodityOil3 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("basePdct", (AssetClassProductType2Code) o.getBasePdct() != null ? 1 : 0, 1, 1), 
				checkCardinality("subPdct", (AssetClassSubProductType8Code) o.getSubPdct() != null ? 1 : 0, 0, 1), 
				checkCardinality("addtlSubPdct", (AssetClassDetailedSubProductType32Code) o.getAddtlSubPdct() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EnergyCommodityOil3 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EnergyCommodityOil3", ValidationResult.ValidationType.CARDINALITY, "EnergyCommodityOil3", path, "", res.getError());
				}
				return success("EnergyCommodityOil3", ValidationResult.ValidationType.CARDINALITY, "EnergyCommodityOil3", path, "");
			})
			.collect(toList());
	}

}
