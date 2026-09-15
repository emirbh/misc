package iso20022.auth030.hkma.tr.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.tr.AssetClassCommodityPaper5Choice;
import iso20022.auth030.hkma.tr.PaperCommodityContainerBoard2;
import iso20022.auth030.hkma.tr.PaperCommodityNewsprint2;
import iso20022.auth030.hkma.tr.PaperCommodityOther1;
import iso20022.auth030.hkma.tr.PaperCommodityPulp2;
import iso20022.auth030.hkma.tr.PaperCommodityRecoveredPaper3;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AssetClassCommodityPaper5ChoiceValidator implements Validator<AssetClassCommodityPaper5Choice> {

	private List<ComparisonResult> getComparisonResults(AssetClassCommodityPaper5Choice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("cntnrBrd", (PaperCommodityContainerBoard2) o.getCntnrBrd() != null ? 1 : 0, 0, 1), 
				checkCardinality("nwsprnt", (PaperCommodityNewsprint2) o.getNwsprnt() != null ? 1 : 0, 0, 1), 
				checkCardinality("pulp", (PaperCommodityPulp2) o.getPulp() != null ? 1 : 0, 0, 1), 
				checkCardinality("rcvrdPpr", (PaperCommodityRecoveredPaper3) o.getRcvrdPpr() != null ? 1 : 0, 0, 1), 
				checkCardinality("othr", (PaperCommodityOther1) o.getOthr() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetClassCommodityPaper5Choice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AssetClassCommodityPaper5Choice", ValidationResult.ValidationType.CARDINALITY, "AssetClassCommodityPaper5Choice", path, "", res.getError());
				}
				return success("AssetClassCommodityPaper5Choice", ValidationResult.ValidationType.CARDINALITY, "AssetClassCommodityPaper5Choice", path, "");
			})
			.collect(toList());
	}

}
