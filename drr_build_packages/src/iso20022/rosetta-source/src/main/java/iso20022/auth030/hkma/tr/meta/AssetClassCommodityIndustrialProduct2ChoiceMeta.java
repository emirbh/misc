package iso20022.auth030.hkma.tr.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.tr.AssetClassCommodityIndustrialProduct2Choice;
import iso20022.auth030.hkma.tr.validation.AssetClassCommodityIndustrialProduct2ChoiceTypeFormatValidator;
import iso20022.auth030.hkma.tr.validation.AssetClassCommodityIndustrialProduct2ChoiceValidator;
import iso20022.auth030.hkma.tr.validation.datarule.AssetClassCommodityIndustrialProduct2ChoiceChoice;
import iso20022.auth030.hkma.tr.validation.exists.AssetClassCommodityIndustrialProduct2ChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AssetClassCommodityIndustrialProduct2Choice.class)
public class AssetClassCommodityIndustrialProduct2ChoiceMeta implements RosettaMetaData<AssetClassCommodityIndustrialProduct2Choice> {

	@Override
	public List<Validator<? super AssetClassCommodityIndustrialProduct2Choice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<AssetClassCommodityIndustrialProduct2Choice>create(AssetClassCommodityIndustrialProduct2ChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super AssetClassCommodityIndustrialProduct2Choice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AssetClassCommodityIndustrialProduct2Choice> validator(ValidatorFactory factory) {
		return factory.<AssetClassCommodityIndustrialProduct2Choice>create(AssetClassCommodityIndustrialProduct2ChoiceValidator.class);
	}

	@Override
	public Validator<? super AssetClassCommodityIndustrialProduct2Choice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AssetClassCommodityIndustrialProduct2Choice>create(AssetClassCommodityIndustrialProduct2ChoiceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AssetClassCommodityIndustrialProduct2Choice> validator() {
		return new AssetClassCommodityIndustrialProduct2ChoiceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AssetClassCommodityIndustrialProduct2Choice> typeFormatValidator() {
		return new AssetClassCommodityIndustrialProduct2ChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AssetClassCommodityIndustrialProduct2Choice, Set<String>> onlyExistsValidator() {
		return new AssetClassCommodityIndustrialProduct2ChoiceOnlyExistsValidator();
	}
}
