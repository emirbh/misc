package iso20022.auth030.esma.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.esma.AssetClassCommodityPolypropylene4Choice;
import iso20022.auth030.esma.PolypropyleneCommodityOther2;
import iso20022.auth030.esma.PolypropyleneCommodityPlastic2;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AssetClassCommodityPolypropylene4ChoiceValidator implements Validator<AssetClassCommodityPolypropylene4Choice> {

	private List<ComparisonResult> getComparisonResults(AssetClassCommodityPolypropylene4Choice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("plstc", (PolypropyleneCommodityPlastic2) o.getPlstc() != null ? 1 : 0, 0, 1), 
				checkCardinality("othr", (PolypropyleneCommodityOther2) o.getOthr() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetClassCommodityPolypropylene4Choice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AssetClassCommodityPolypropylene4Choice", ValidationResult.ValidationType.CARDINALITY, "AssetClassCommodityPolypropylene4Choice", path, "", res.getError());
				}
				return success("AssetClassCommodityPolypropylene4Choice", ValidationResult.ValidationType.CARDINALITY, "AssetClassCommodityPolypropylene4Choice", path, "");
			})
			.collect(toList());
	}

}
