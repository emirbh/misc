package iso20022.auth030.hkma.dtcc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.dtcc.AssetClassCommodityAgricultural6Choice;
import iso20022.auth030.hkma.dtcc.validation.AssetClassCommodityAgricultural6ChoiceTypeFormatValidator;
import iso20022.auth030.hkma.dtcc.validation.AssetClassCommodityAgricultural6ChoiceValidator;
import iso20022.auth030.hkma.dtcc.validation.datarule.AssetClassCommodityAgricultural6ChoiceChoice;
import iso20022.auth030.hkma.dtcc.validation.exists.AssetClassCommodityAgricultural6ChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AssetClassCommodityAgricultural6Choice.class)
public class AssetClassCommodityAgricultural6ChoiceMeta implements RosettaMetaData<AssetClassCommodityAgricultural6Choice> {

	@Override
	public List<Validator<? super AssetClassCommodityAgricultural6Choice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<AssetClassCommodityAgricultural6Choice>create(AssetClassCommodityAgricultural6ChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super AssetClassCommodityAgricultural6Choice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AssetClassCommodityAgricultural6Choice> validator(ValidatorFactory factory) {
		return factory.<AssetClassCommodityAgricultural6Choice>create(AssetClassCommodityAgricultural6ChoiceValidator.class);
	}

	@Override
	public Validator<? super AssetClassCommodityAgricultural6Choice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AssetClassCommodityAgricultural6Choice>create(AssetClassCommodityAgricultural6ChoiceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AssetClassCommodityAgricultural6Choice> validator() {
		return new AssetClassCommodityAgricultural6ChoiceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AssetClassCommodityAgricultural6Choice> typeFormatValidator() {
		return new AssetClassCommodityAgricultural6ChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AssetClassCommodityAgricultural6Choice, Set<String>> onlyExistsValidator() {
		return new AssetClassCommodityAgricultural6ChoiceOnlyExistsValidator();
	}
}
