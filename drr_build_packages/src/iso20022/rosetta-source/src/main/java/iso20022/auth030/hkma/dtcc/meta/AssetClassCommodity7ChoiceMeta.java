package iso20022.auth030.hkma.dtcc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.dtcc.AssetClassCommodity7Choice;
import iso20022.auth030.hkma.dtcc.validation.AssetClassCommodity7ChoiceTypeFormatValidator;
import iso20022.auth030.hkma.dtcc.validation.AssetClassCommodity7ChoiceValidator;
import iso20022.auth030.hkma.dtcc.validation.datarule.AssetClassCommodity7ChoiceChoice;
import iso20022.auth030.hkma.dtcc.validation.exists.AssetClassCommodity7ChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AssetClassCommodity7Choice.class)
public class AssetClassCommodity7ChoiceMeta implements RosettaMetaData<AssetClassCommodity7Choice> {

	@Override
	public List<Validator<? super AssetClassCommodity7Choice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<AssetClassCommodity7Choice>create(AssetClassCommodity7ChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super AssetClassCommodity7Choice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AssetClassCommodity7Choice> validator(ValidatorFactory factory) {
		return factory.<AssetClassCommodity7Choice>create(AssetClassCommodity7ChoiceValidator.class);
	}

	@Override
	public Validator<? super AssetClassCommodity7Choice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AssetClassCommodity7Choice>create(AssetClassCommodity7ChoiceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AssetClassCommodity7Choice> validator() {
		return new AssetClassCommodity7ChoiceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AssetClassCommodity7Choice> typeFormatValidator() {
		return new AssetClassCommodity7ChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AssetClassCommodity7Choice, Set<String>> onlyExistsValidator() {
		return new AssetClassCommodity7ChoiceOnlyExistsValidator();
	}
}
