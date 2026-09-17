package cdm.product.template.meta;

import cdm.product.template.ReturnTerms;
import cdm.product.template.validation.ReturnTermsTypeFormatValidator;
import cdm.product.template.validation.ReturnTermsValidator;
import cdm.product.template.validation.datarule.ReturnTermsReturnTermsExists;
import cdm.product.template.validation.exists.ReturnTermsOnlyExistsValidator;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 6.23.0
 */
@RosettaMeta(model=ReturnTerms.class)
public class ReturnTermsMeta implements RosettaMetaData<ReturnTerms> {

	@Override
	public List<Validator<? super ReturnTerms>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ReturnTerms>create(ReturnTermsReturnTermsExists.class)
		);
	}
	
	@Override
	public List<Function<? super ReturnTerms, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ReturnTerms> validator(ValidatorFactory factory) {
		return factory.<ReturnTerms>create(ReturnTermsValidator.class);
	}

	@Override
	public Validator<? super ReturnTerms> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ReturnTerms>create(ReturnTermsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ReturnTerms> validator() {
		return new ReturnTermsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ReturnTerms> typeFormatValidator() {
		return new ReturnTermsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReturnTerms, Set<String>> onlyExistsValidator() {
		return new ReturnTermsOnlyExistsValidator();
	}
}
