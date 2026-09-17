package cdm.product.asset.meta;

import cdm.product.asset.ReferenceObligation;
import cdm.product.asset.validation.ReferenceObligationTypeFormatValidator;
import cdm.product.asset.validation.ReferenceObligationValidator;
import cdm.product.asset.validation.datarule.ReferenceObligationAssetChoice;
import cdm.product.asset.validation.datarule.ReferenceObligationLegalEntityChoice;
import cdm.product.asset.validation.datarule.ReferenceObligationMustBeDebtSecurity;
import cdm.product.asset.validation.exists.ReferenceObligationOnlyExistsValidator;
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
@RosettaMeta(model=ReferenceObligation.class)
public class ReferenceObligationMeta implements RosettaMetaData<ReferenceObligation> {

	@Override
	public List<Validator<? super ReferenceObligation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ReferenceObligation>create(ReferenceObligationAssetChoice.class),
			factory.<ReferenceObligation>create(ReferenceObligationMustBeDebtSecurity.class),
			factory.<ReferenceObligation>create(ReferenceObligationLegalEntityChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ReferenceObligation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ReferenceObligation> validator(ValidatorFactory factory) {
		return factory.<ReferenceObligation>create(ReferenceObligationValidator.class);
	}

	@Override
	public Validator<? super ReferenceObligation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ReferenceObligation>create(ReferenceObligationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ReferenceObligation> validator() {
		return new ReferenceObligationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ReferenceObligation> typeFormatValidator() {
		return new ReferenceObligationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReferenceObligation, Set<String>> onlyExistsValidator() {
		return new ReferenceObligationOnlyExistsValidator();
	}
}
