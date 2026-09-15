package iso20022.auth030.hkma.dtcc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.dtcc.AssetClassCommodityPaper5Choice;
import iso20022.auth030.hkma.dtcc.validation.AssetClassCommodityPaper5ChoiceTypeFormatValidator;
import iso20022.auth030.hkma.dtcc.validation.AssetClassCommodityPaper5ChoiceValidator;
import iso20022.auth030.hkma.dtcc.validation.datarule.AssetClassCommodityPaper5ChoiceChoice;
import iso20022.auth030.hkma.dtcc.validation.exists.AssetClassCommodityPaper5ChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AssetClassCommodityPaper5Choice.class)
public class AssetClassCommodityPaper5ChoiceMeta implements RosettaMetaData<AssetClassCommodityPaper5Choice> {

	@Override
	public List<Validator<? super AssetClassCommodityPaper5Choice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<AssetClassCommodityPaper5Choice>create(AssetClassCommodityPaper5ChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super AssetClassCommodityPaper5Choice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AssetClassCommodityPaper5Choice> validator(ValidatorFactory factory) {
		return factory.<AssetClassCommodityPaper5Choice>create(AssetClassCommodityPaper5ChoiceValidator.class);
	}

	@Override
	public Validator<? super AssetClassCommodityPaper5Choice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AssetClassCommodityPaper5Choice>create(AssetClassCommodityPaper5ChoiceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AssetClassCommodityPaper5Choice> validator() {
		return new AssetClassCommodityPaper5ChoiceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AssetClassCommodityPaper5Choice> typeFormatValidator() {
		return new AssetClassCommodityPaper5ChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AssetClassCommodityPaper5Choice, Set<String>> onlyExistsValidator() {
		return new AssetClassCommodityPaper5ChoiceOnlyExistsValidator();
	}
}
