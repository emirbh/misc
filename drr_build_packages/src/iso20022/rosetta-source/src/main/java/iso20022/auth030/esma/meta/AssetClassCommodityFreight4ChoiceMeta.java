package iso20022.auth030.esma.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.esma.AssetClassCommodityFreight4Choice;
import iso20022.auth030.esma.validation.AssetClassCommodityFreight4ChoiceTypeFormatValidator;
import iso20022.auth030.esma.validation.AssetClassCommodityFreight4ChoiceValidator;
import iso20022.auth030.esma.validation.datarule.AssetClassCommodityFreight4ChoiceChoice;
import iso20022.auth030.esma.validation.exists.AssetClassCommodityFreight4ChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AssetClassCommodityFreight4Choice.class)
public class AssetClassCommodityFreight4ChoiceMeta implements RosettaMetaData<AssetClassCommodityFreight4Choice> {

	@Override
	public List<Validator<? super AssetClassCommodityFreight4Choice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<AssetClassCommodityFreight4Choice>create(AssetClassCommodityFreight4ChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super AssetClassCommodityFreight4Choice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AssetClassCommodityFreight4Choice> validator(ValidatorFactory factory) {
		return factory.<AssetClassCommodityFreight4Choice>create(AssetClassCommodityFreight4ChoiceValidator.class);
	}

	@Override
	public Validator<? super AssetClassCommodityFreight4Choice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AssetClassCommodityFreight4Choice>create(AssetClassCommodityFreight4ChoiceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AssetClassCommodityFreight4Choice> validator() {
		return new AssetClassCommodityFreight4ChoiceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AssetClassCommodityFreight4Choice> typeFormatValidator() {
		return new AssetClassCommodityFreight4ChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AssetClassCommodityFreight4Choice, Set<String>> onlyExistsValidator() {
		return new AssetClassCommodityFreight4ChoiceOnlyExistsValidator();
	}
}
