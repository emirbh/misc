package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.CSAThresholdVariableSet;
import cdm.legaldocumentation.csa.validation.CSAThresholdVariableSetTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.CSAThresholdVariableSetValidator;
import cdm.legaldocumentation.csa.validation.datarule.CSAThresholdVariableSetNameMustExist;
import cdm.legaldocumentation.csa.validation.datarule.CSAThresholdVariableSetValueMustExist;
import cdm.legaldocumentation.csa.validation.exists.CSAThresholdVariableSetOnlyExistsValidator;
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
@RosettaMeta(model=CSAThresholdVariableSet.class)
public class CSAThresholdVariableSetMeta implements RosettaMetaData<CSAThresholdVariableSet> {

	@Override
	public List<Validator<? super CSAThresholdVariableSet>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CSAThresholdVariableSet>create(CSAThresholdVariableSetNameMustExist.class),
			factory.<CSAThresholdVariableSet>create(CSAThresholdVariableSetValueMustExist.class)
		);
	}
	
	@Override
	public List<Function<? super CSAThresholdVariableSet, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CSAThresholdVariableSet> validator(ValidatorFactory factory) {
		return factory.<CSAThresholdVariableSet>create(CSAThresholdVariableSetValidator.class);
	}

	@Override
	public Validator<? super CSAThresholdVariableSet> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CSAThresholdVariableSet>create(CSAThresholdVariableSetTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CSAThresholdVariableSet> validator() {
		return new CSAThresholdVariableSetValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CSAThresholdVariableSet> typeFormatValidator() {
		return new CSAThresholdVariableSetTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CSAThresholdVariableSet, Set<String>> onlyExistsValidator() {
		return new CSAThresholdVariableSetOnlyExistsValidator();
	}
}
