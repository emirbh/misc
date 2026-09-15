package iso20022.auth030.hkma.tr.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.tr.AssetClassProductType2Code;
import iso20022.auth030.hkma.tr.AssetClassSubProductType26Code;
import iso20022.auth030.hkma.tr.EnergyCommodityInterEnergy2;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class EnergyCommodityInterEnergy2Validator implements Validator<EnergyCommodityInterEnergy2> {

	private List<ComparisonResult> getComparisonResults(EnergyCommodityInterEnergy2 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("basePdct", (AssetClassProductType2Code) o.getBasePdct() != null ? 1 : 0, 1, 1), 
				checkCardinality("subPdct", (AssetClassSubProductType26Code) o.getSubPdct() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EnergyCommodityInterEnergy2 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EnergyCommodityInterEnergy2", ValidationResult.ValidationType.CARDINALITY, "EnergyCommodityInterEnergy2", path, "", res.getError());
				}
				return success("EnergyCommodityInterEnergy2", ValidationResult.ValidationType.CARDINALITY, "EnergyCommodityInterEnergy2", path, "");
			})
			.collect(toList());
	}

}
