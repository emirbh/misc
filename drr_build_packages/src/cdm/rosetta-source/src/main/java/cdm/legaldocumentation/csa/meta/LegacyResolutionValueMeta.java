package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.LegacyResolutionValue;
import cdm.legaldocumentation.csa.validation.LegacyResolutionValueTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.LegacyResolutionValueValidator;
import cdm.legaldocumentation.csa.validation.datarule.LegacyResolutionValueOtherValues;
import cdm.legaldocumentation.csa.validation.exists.LegacyResolutionValueOnlyExistsValidator;
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
@RosettaMeta(model=LegacyResolutionValue.class)
public class LegacyResolutionValueMeta implements RosettaMetaData<LegacyResolutionValue> {

	@Override
	public List<Validator<? super LegacyResolutionValue>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<LegacyResolutionValue>create(LegacyResolutionValueOtherValues.class)
		);
	}
	
	@Override
	public List<Function<? super LegacyResolutionValue, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LegacyResolutionValue> validator(ValidatorFactory factory) {
		return factory.<LegacyResolutionValue>create(LegacyResolutionValueValidator.class);
	}

	@Override
	public Validator<? super LegacyResolutionValue> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LegacyResolutionValue>create(LegacyResolutionValueTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LegacyResolutionValue> validator() {
		return new LegacyResolutionValueValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LegacyResolutionValue> typeFormatValidator() {
		return new LegacyResolutionValueTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LegacyResolutionValue, Set<String>> onlyExistsValidator() {
		return new LegacyResolutionValueOnlyExistsValidator();
	}
}
