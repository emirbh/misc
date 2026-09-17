package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.RecalculationOfValue;
import cdm.legaldocumentation.csa.validation.RecalculationOfValueTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.RecalculationOfValueValidator;
import cdm.legaldocumentation.csa.validation.exists.RecalculationOfValueOnlyExistsValidator;
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
@RosettaMeta(model=RecalculationOfValue.class)
public class RecalculationOfValueMeta implements RosettaMetaData<RecalculationOfValue> {

	@Override
	public List<Validator<? super RecalculationOfValue>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RecalculationOfValue, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RecalculationOfValue> validator(ValidatorFactory factory) {
		return factory.<RecalculationOfValue>create(RecalculationOfValueValidator.class);
	}

	@Override
	public Validator<? super RecalculationOfValue> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RecalculationOfValue>create(RecalculationOfValueTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RecalculationOfValue> validator() {
		return new RecalculationOfValueValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RecalculationOfValue> typeFormatValidator() {
		return new RecalculationOfValueTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RecalculationOfValue, Set<String>> onlyExistsValidator() {
		return new RecalculationOfValueOnlyExistsValidator();
	}
}
