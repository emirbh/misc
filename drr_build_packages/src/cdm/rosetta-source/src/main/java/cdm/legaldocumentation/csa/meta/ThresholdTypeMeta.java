package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.ThresholdType;
import cdm.legaldocumentation.csa.validation.ThresholdTypeTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.ThresholdTypeValidator;
import cdm.legaldocumentation.csa.validation.exists.ThresholdTypeOnlyExistsValidator;
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
@RosettaMeta(model=ThresholdType.class)
public class ThresholdTypeMeta implements RosettaMetaData<ThresholdType> {

	@Override
	public List<Validator<? super ThresholdType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ThresholdType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ThresholdType> validator(ValidatorFactory factory) {
		return factory.<ThresholdType>create(ThresholdTypeValidator.class);
	}

	@Override
	public Validator<? super ThresholdType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ThresholdType>create(ThresholdTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ThresholdType> validator() {
		return new ThresholdTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ThresholdType> typeFormatValidator() {
		return new ThresholdTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ThresholdType, Set<String>> onlyExistsValidator() {
		return new ThresholdTypeOnlyExistsValidator();
	}
}
