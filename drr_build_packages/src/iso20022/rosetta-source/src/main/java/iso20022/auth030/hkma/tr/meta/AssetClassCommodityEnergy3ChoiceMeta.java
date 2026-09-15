package iso20022.auth030.hkma.tr.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.tr.AssetClassCommodityEnergy3Choice;
import iso20022.auth030.hkma.tr.validation.AssetClassCommodityEnergy3ChoiceTypeFormatValidator;
import iso20022.auth030.hkma.tr.validation.AssetClassCommodityEnergy3ChoiceValidator;
import iso20022.auth030.hkma.tr.validation.datarule.AssetClassCommodityEnergy3ChoiceChoice;
import iso20022.auth030.hkma.tr.validation.exists.AssetClassCommodityEnergy3ChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AssetClassCommodityEnergy3Choice.class)
public class AssetClassCommodityEnergy3ChoiceMeta implements RosettaMetaData<AssetClassCommodityEnergy3Choice> {

	@Override
	public List<Validator<? super AssetClassCommodityEnergy3Choice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<AssetClassCommodityEnergy3Choice>create(AssetClassCommodityEnergy3ChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super AssetClassCommodityEnergy3Choice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AssetClassCommodityEnergy3Choice> validator(ValidatorFactory factory) {
		return factory.<AssetClassCommodityEnergy3Choice>create(AssetClassCommodityEnergy3ChoiceValidator.class);
	}

	@Override
	public Validator<? super AssetClassCommodityEnergy3Choice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AssetClassCommodityEnergy3Choice>create(AssetClassCommodityEnergy3ChoiceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AssetClassCommodityEnergy3Choice> validator() {
		return new AssetClassCommodityEnergy3ChoiceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AssetClassCommodityEnergy3Choice> typeFormatValidator() {
		return new AssetClassCommodityEnergy3ChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AssetClassCommodityEnergy3Choice, Set<String>> onlyExistsValidator() {
		return new AssetClassCommodityEnergy3ChoiceOnlyExistsValidator();
	}
}
