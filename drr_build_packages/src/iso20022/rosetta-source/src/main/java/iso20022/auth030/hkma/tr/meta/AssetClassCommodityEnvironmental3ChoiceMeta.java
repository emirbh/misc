package iso20022.auth030.hkma.tr.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.tr.AssetClassCommodityEnvironmental3Choice;
import iso20022.auth030.hkma.tr.validation.AssetClassCommodityEnvironmental3ChoiceTypeFormatValidator;
import iso20022.auth030.hkma.tr.validation.AssetClassCommodityEnvironmental3ChoiceValidator;
import iso20022.auth030.hkma.tr.validation.datarule.AssetClassCommodityEnvironmental3ChoiceChoice;
import iso20022.auth030.hkma.tr.validation.exists.AssetClassCommodityEnvironmental3ChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AssetClassCommodityEnvironmental3Choice.class)
public class AssetClassCommodityEnvironmental3ChoiceMeta implements RosettaMetaData<AssetClassCommodityEnvironmental3Choice> {

	@Override
	public List<Validator<? super AssetClassCommodityEnvironmental3Choice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<AssetClassCommodityEnvironmental3Choice>create(AssetClassCommodityEnvironmental3ChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super AssetClassCommodityEnvironmental3Choice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AssetClassCommodityEnvironmental3Choice> validator(ValidatorFactory factory) {
		return factory.<AssetClassCommodityEnvironmental3Choice>create(AssetClassCommodityEnvironmental3ChoiceValidator.class);
	}

	@Override
	public Validator<? super AssetClassCommodityEnvironmental3Choice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AssetClassCommodityEnvironmental3Choice>create(AssetClassCommodityEnvironmental3ChoiceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AssetClassCommodityEnvironmental3Choice> validator() {
		return new AssetClassCommodityEnvironmental3ChoiceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AssetClassCommodityEnvironmental3Choice> typeFormatValidator() {
		return new AssetClassCommodityEnvironmental3ChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AssetClassCommodityEnvironmental3Choice, Set<String>> onlyExistsValidator() {
		return new AssetClassCommodityEnvironmental3ChoiceOnlyExistsValidator();
	}
}
