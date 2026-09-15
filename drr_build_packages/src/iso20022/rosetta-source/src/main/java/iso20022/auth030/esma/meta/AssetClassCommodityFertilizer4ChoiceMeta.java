package iso20022.auth030.esma.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.esma.AssetClassCommodityFertilizer4Choice;
import iso20022.auth030.esma.validation.AssetClassCommodityFertilizer4ChoiceTypeFormatValidator;
import iso20022.auth030.esma.validation.AssetClassCommodityFertilizer4ChoiceValidator;
import iso20022.auth030.esma.validation.datarule.AssetClassCommodityFertilizer4ChoiceChoice;
import iso20022.auth030.esma.validation.exists.AssetClassCommodityFertilizer4ChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AssetClassCommodityFertilizer4Choice.class)
public class AssetClassCommodityFertilizer4ChoiceMeta implements RosettaMetaData<AssetClassCommodityFertilizer4Choice> {

	@Override
	public List<Validator<? super AssetClassCommodityFertilizer4Choice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<AssetClassCommodityFertilizer4Choice>create(AssetClassCommodityFertilizer4ChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super AssetClassCommodityFertilizer4Choice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AssetClassCommodityFertilizer4Choice> validator(ValidatorFactory factory) {
		return factory.<AssetClassCommodityFertilizer4Choice>create(AssetClassCommodityFertilizer4ChoiceValidator.class);
	}

	@Override
	public Validator<? super AssetClassCommodityFertilizer4Choice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AssetClassCommodityFertilizer4Choice>create(AssetClassCommodityFertilizer4ChoiceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AssetClassCommodityFertilizer4Choice> validator() {
		return new AssetClassCommodityFertilizer4ChoiceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AssetClassCommodityFertilizer4Choice> typeFormatValidator() {
		return new AssetClassCommodityFertilizer4ChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AssetClassCommodityFertilizer4Choice, Set<String>> onlyExistsValidator() {
		return new AssetClassCommodityFertilizer4ChoiceOnlyExistsValidator();
	}
}
