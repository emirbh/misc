package cdm.product.asset.meta;

import cdm.product.asset.GeneralTerms;
import cdm.product.asset.validation.GeneralTermsTypeFormatValidator;
import cdm.product.asset.validation.GeneralTermsValidator;
import cdm.product.asset.validation.datarule.GeneralTermsBasketReferenceInformationNameOrId;
import cdm.product.asset.validation.datarule.GeneralTermsFpML_cd_41;
import cdm.product.asset.validation.datarule.GeneralTermsFpML_cd_42;
import cdm.product.asset.validation.datarule.GeneralTermsGeneralTermsChoice;
import cdm.product.asset.validation.exists.GeneralTermsOnlyExistsValidator;
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
@RosettaMeta(model=GeneralTerms.class)
public class GeneralTermsMeta implements RosettaMetaData<GeneralTerms> {

	@Override
	public List<Validator<? super GeneralTerms>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<GeneralTerms>create(GeneralTermsGeneralTermsChoice.class),
			factory.<GeneralTerms>create(GeneralTermsFpML_cd_41.class),
			factory.<GeneralTerms>create(GeneralTermsFpML_cd_42.class),
			factory.<GeneralTerms>create(GeneralTermsBasketReferenceInformationNameOrId.class)
		);
	}
	
	@Override
	public List<Function<? super GeneralTerms, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super GeneralTerms> validator(ValidatorFactory factory) {
		return factory.<GeneralTerms>create(GeneralTermsValidator.class);
	}

	@Override
	public Validator<? super GeneralTerms> typeFormatValidator(ValidatorFactory factory) {
		return factory.<GeneralTerms>create(GeneralTermsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super GeneralTerms> validator() {
		return new GeneralTermsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super GeneralTerms> typeFormatValidator() {
		return new GeneralTermsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super GeneralTerms, Set<String>> onlyExistsValidator() {
		return new GeneralTermsOnlyExistsValidator();
	}
}
