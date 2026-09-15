package fpml.consolidated.fx.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.FxTemplateTerms;
import fpml.consolidated.fx.validation.FxTemplateTermsTypeFormatValidator;
import fpml.consolidated.fx.validation.FxTemplateTermsValidator;
import fpml.consolidated.fx.validation.exists.FxTemplateTermsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxTemplateTerms.class)
public class FxTemplateTermsMeta implements RosettaMetaData<FxTemplateTerms> {

	@Override
	public List<Validator<? super FxTemplateTerms>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxTemplateTerms, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxTemplateTerms> validator(ValidatorFactory factory) {
		return factory.<FxTemplateTerms>create(FxTemplateTermsValidator.class);
	}

	@Override
	public Validator<? super FxTemplateTerms> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxTemplateTerms>create(FxTemplateTermsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxTemplateTerms> validator() {
		return new FxTemplateTermsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxTemplateTerms> typeFormatValidator() {
		return new FxTemplateTermsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxTemplateTerms, Set<String>> onlyExistsValidator() {
		return new FxTemplateTermsOnlyExistsValidator();
	}
}
