package iso20022.auth030.esma.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.esma.AssetClassCommodityPaper4Choice;
import iso20022.auth030.esma.validation.AssetClassCommodityPaper4ChoiceTypeFormatValidator;
import iso20022.auth030.esma.validation.AssetClassCommodityPaper4ChoiceValidator;
import iso20022.auth030.esma.validation.datarule.AssetClassCommodityPaper4ChoiceChoice;
import iso20022.auth030.esma.validation.exists.AssetClassCommodityPaper4ChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AssetClassCommodityPaper4Choice.class)
public class AssetClassCommodityPaper4ChoiceMeta implements RosettaMetaData<AssetClassCommodityPaper4Choice> {

	@Override
	public List<Validator<? super AssetClassCommodityPaper4Choice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<AssetClassCommodityPaper4Choice>create(AssetClassCommodityPaper4ChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super AssetClassCommodityPaper4Choice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AssetClassCommodityPaper4Choice> validator(ValidatorFactory factory) {
		return factory.<AssetClassCommodityPaper4Choice>create(AssetClassCommodityPaper4ChoiceValidator.class);
	}

	@Override
	public Validator<? super AssetClassCommodityPaper4Choice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AssetClassCommodityPaper4Choice>create(AssetClassCommodityPaper4ChoiceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AssetClassCommodityPaper4Choice> validator() {
		return new AssetClassCommodityPaper4ChoiceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AssetClassCommodityPaper4Choice> typeFormatValidator() {
		return new AssetClassCommodityPaper4ChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AssetClassCommodityPaper4Choice, Set<String>> onlyExistsValidator() {
		return new AssetClassCommodityPaper4ChoiceOnlyExistsValidator();
	}
}
