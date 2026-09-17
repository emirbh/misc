package cdm.product.asset.meta;

import cdm.product.asset.ReturnTermsBase;
import cdm.product.asset.validation.ReturnTermsBaseTypeFormatValidator;
import cdm.product.asset.validation.ReturnTermsBaseValidator;
import cdm.product.asset.validation.datarule.ReturnTermsBaseInitialLevelOrInitialLevelSource;
import cdm.product.asset.validation.datarule.ReturnTermsBasePositiveExpectedN;
import cdm.product.asset.validation.exists.ReturnTermsBaseOnlyExistsValidator;
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
@RosettaMeta(model=ReturnTermsBase.class)
public class ReturnTermsBaseMeta implements RosettaMetaData<ReturnTermsBase> {

	@Override
	public List<Validator<? super ReturnTermsBase>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ReturnTermsBase>create(ReturnTermsBaseInitialLevelOrInitialLevelSource.class),
			factory.<ReturnTermsBase>create(ReturnTermsBasePositiveExpectedN.class)
		);
	}
	
	@Override
	public List<Function<? super ReturnTermsBase, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ReturnTermsBase> validator(ValidatorFactory factory) {
		return factory.<ReturnTermsBase>create(ReturnTermsBaseValidator.class);
	}

	@Override
	public Validator<? super ReturnTermsBase> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ReturnTermsBase>create(ReturnTermsBaseTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ReturnTermsBase> validator() {
		return new ReturnTermsBaseValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ReturnTermsBase> typeFormatValidator() {
		return new ReturnTermsBaseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReturnTermsBase, Set<String>> onlyExistsValidator() {
		return new ReturnTermsBaseOnlyExistsValidator();
	}
}
