package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.AdditionalType;
import cdm.legaldocumentation.csa.validation.AdditionalTypeTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.AdditionalTypeValidator;
import cdm.legaldocumentation.csa.validation.datarule.AdditionalTypeCustomValue;
import cdm.legaldocumentation.csa.validation.datarule.AdditionalTypeStandardValue;
import cdm.legaldocumentation.csa.validation.exists.AdditionalTypeOnlyExistsValidator;
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
@RosettaMeta(model=AdditionalType.class)
public class AdditionalTypeMeta implements RosettaMetaData<AdditionalType> {

	@Override
	public List<Validator<? super AdditionalType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<AdditionalType>create(AdditionalTypeCustomValue.class),
			factory.<AdditionalType>create(AdditionalTypeStandardValue.class)
		);
	}
	
	@Override
	public List<Function<? super AdditionalType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AdditionalType> validator(ValidatorFactory factory) {
		return factory.<AdditionalType>create(AdditionalTypeValidator.class);
	}

	@Override
	public Validator<? super AdditionalType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AdditionalType>create(AdditionalTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AdditionalType> validator() {
		return new AdditionalTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AdditionalType> typeFormatValidator() {
		return new AdditionalTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AdditionalType, Set<String>> onlyExistsValidator() {
		return new AdditionalTypeOnlyExistsValidator();
	}
}
