package iso20022.auth030.hkma.dtcc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.dtcc.AssetClassCommodityPolypropylene4Choice;
import iso20022.auth030.hkma.dtcc.validation.AssetClassCommodityPolypropylene4ChoiceTypeFormatValidator;
import iso20022.auth030.hkma.dtcc.validation.AssetClassCommodityPolypropylene4ChoiceValidator;
import iso20022.auth030.hkma.dtcc.validation.datarule.AssetClassCommodityPolypropylene4ChoiceChoice;
import iso20022.auth030.hkma.dtcc.validation.exists.AssetClassCommodityPolypropylene4ChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AssetClassCommodityPolypropylene4Choice.class)
public class AssetClassCommodityPolypropylene4ChoiceMeta implements RosettaMetaData<AssetClassCommodityPolypropylene4Choice> {

	@Override
	public List<Validator<? super AssetClassCommodityPolypropylene4Choice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<AssetClassCommodityPolypropylene4Choice>create(AssetClassCommodityPolypropylene4ChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super AssetClassCommodityPolypropylene4Choice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AssetClassCommodityPolypropylene4Choice> validator(ValidatorFactory factory) {
		return factory.<AssetClassCommodityPolypropylene4Choice>create(AssetClassCommodityPolypropylene4ChoiceValidator.class);
	}

	@Override
	public Validator<? super AssetClassCommodityPolypropylene4Choice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AssetClassCommodityPolypropylene4Choice>create(AssetClassCommodityPolypropylene4ChoiceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AssetClassCommodityPolypropylene4Choice> validator() {
		return new AssetClassCommodityPolypropylene4ChoiceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AssetClassCommodityPolypropylene4Choice> typeFormatValidator() {
		return new AssetClassCommodityPolypropylene4ChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AssetClassCommodityPolypropylene4Choice, Set<String>> onlyExistsValidator() {
		return new AssetClassCommodityPolypropylene4ChoiceOnlyExistsValidator();
	}
}
