package iso20022.auth030.esma.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.esma.AssetClassCommodityMetal2Choice;
import iso20022.auth030.esma.validation.AssetClassCommodityMetal2ChoiceTypeFormatValidator;
import iso20022.auth030.esma.validation.AssetClassCommodityMetal2ChoiceValidator;
import iso20022.auth030.esma.validation.datarule.AssetClassCommodityMetal2ChoiceChoice;
import iso20022.auth030.esma.validation.exists.AssetClassCommodityMetal2ChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AssetClassCommodityMetal2Choice.class)
public class AssetClassCommodityMetal2ChoiceMeta implements RosettaMetaData<AssetClassCommodityMetal2Choice> {

	@Override
	public List<Validator<? super AssetClassCommodityMetal2Choice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<AssetClassCommodityMetal2Choice>create(AssetClassCommodityMetal2ChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super AssetClassCommodityMetal2Choice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AssetClassCommodityMetal2Choice> validator(ValidatorFactory factory) {
		return factory.<AssetClassCommodityMetal2Choice>create(AssetClassCommodityMetal2ChoiceValidator.class);
	}

	@Override
	public Validator<? super AssetClassCommodityMetal2Choice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AssetClassCommodityMetal2Choice>create(AssetClassCommodityMetal2ChoiceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AssetClassCommodityMetal2Choice> validator() {
		return new AssetClassCommodityMetal2ChoiceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AssetClassCommodityMetal2Choice> typeFormatValidator() {
		return new AssetClassCommodityMetal2ChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AssetClassCommodityMetal2Choice, Set<String>> onlyExistsValidator() {
		return new AssetClassCommodityMetal2ChoiceOnlyExistsValidator();
	}
}
