package iso20022.auth030.fca.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.fca.AssetClassDetailedSubProductType31Code;
import iso20022.auth030.fca.AssetClassProductType2Code;
import iso20022.auth030.fca.AssetClassSubProductType7Code;
import iso20022.auth030.fca.EnergyCommodityNaturalGas3__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class EnergyCommodityNaturalGas3__1Validator implements Validator<EnergyCommodityNaturalGas3__1> {

	private List<ComparisonResult> getComparisonResults(EnergyCommodityNaturalGas3__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("basePdct", (AssetClassProductType2Code) o.getBasePdct() != null ? 1 : 0, 1, 1), 
				checkCardinality("subPdct", (AssetClassSubProductType7Code) o.getSubPdct() != null ? 1 : 0, 1, 1), 
				checkCardinality("addtlSubPdct", (AssetClassDetailedSubProductType31Code) o.getAddtlSubPdct() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EnergyCommodityNaturalGas3__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EnergyCommodityNaturalGas3__1", ValidationResult.ValidationType.CARDINALITY, "EnergyCommodityNaturalGas3__1", path, "", res.getError());
				}
				return success("EnergyCommodityNaturalGas3__1", ValidationResult.ValidationType.CARDINALITY, "EnergyCommodityNaturalGas3__1", path, "");
			})
			.collect(toList());
	}

}
