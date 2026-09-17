package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.AmendmentEffectiveDate;
import cdm.legaldocumentation.csa.validation.AmendmentEffectiveDateTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.AmendmentEffectiveDateValidator;
import cdm.legaldocumentation.csa.validation.datarule.AmendmentEffectiveDateOneOf0;
import cdm.legaldocumentation.csa.validation.exists.AmendmentEffectiveDateOnlyExistsValidator;
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
@RosettaMeta(model=AmendmentEffectiveDate.class)
public class AmendmentEffectiveDateMeta implements RosettaMetaData<AmendmentEffectiveDate> {

	@Override
	public List<Validator<? super AmendmentEffectiveDate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<AmendmentEffectiveDate>create(AmendmentEffectiveDateOneOf0.class)
		);
	}
	
	@Override
	public List<Function<? super AmendmentEffectiveDate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AmendmentEffectiveDate> validator(ValidatorFactory factory) {
		return factory.<AmendmentEffectiveDate>create(AmendmentEffectiveDateValidator.class);
	}

	@Override
	public Validator<? super AmendmentEffectiveDate> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AmendmentEffectiveDate>create(AmendmentEffectiveDateTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AmendmentEffectiveDate> validator() {
		return new AmendmentEffectiveDateValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AmendmentEffectiveDate> typeFormatValidator() {
		return new AmendmentEffectiveDateTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AmendmentEffectiveDate, Set<String>> onlyExistsValidator() {
		return new AmendmentEffectiveDateOnlyExistsValidator();
	}
}
