package iso20022.auth030.esma.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.esma.AssetClassCommodityPaper4Choice;
import iso20022.auth030.esma.PaperCommodityContainerBoard2;
import iso20022.auth030.esma.PaperCommodityNewsprint2;
import iso20022.auth030.esma.PaperCommodityOther1;
import iso20022.auth030.esma.PaperCommodityPulp2;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AssetClassCommodityPaper4ChoiceValidator implements Validator<AssetClassCommodityPaper4Choice> {

	private List<ComparisonResult> getComparisonResults(AssetClassCommodityPaper4Choice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("cntnrBrd", (PaperCommodityContainerBoard2) o.getCntnrBrd() != null ? 1 : 0, 0, 1), 
				checkCardinality("nwsprnt", (PaperCommodityNewsprint2) o.getNwsprnt() != null ? 1 : 0, 0, 1), 
				checkCardinality("pulp", (PaperCommodityPulp2) o.getPulp() != null ? 1 : 0, 0, 1), 
				checkCardinality("rcvrdPpr", (PaperCommodityOther1) o.getRcvrdPpr() != null ? 1 : 0, 0, 1), 
				checkCardinality("othr", (PaperCommodityOther1) o.getOthr() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetClassCommodityPaper4Choice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AssetClassCommodityPaper4Choice", ValidationResult.ValidationType.CARDINALITY, "AssetClassCommodityPaper4Choice", path, "", res.getError());
				}
				return success("AssetClassCommodityPaper4Choice", ValidationResult.ValidationType.CARDINALITY, "AssetClassCommodityPaper4Choice", path, "");
			})
			.collect(toList());
	}

}
