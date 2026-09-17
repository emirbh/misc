package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.CSAMTAVariableSet;
import cdm.legaldocumentation.csa.validation.CSAMTAVariableSetTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.CSAMTAVariableSetValidator;
import cdm.legaldocumentation.csa.validation.datarule.CSAMTAVariableSetNameMustExist;
import cdm.legaldocumentation.csa.validation.datarule.CSAMTAVariableSetValueMustExist;
import cdm.legaldocumentation.csa.validation.exists.CSAMTAVariableSetOnlyExistsValidator;
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
@RosettaMeta(model=CSAMTAVariableSet.class)
public class CSAMTAVariableSetMeta implements RosettaMetaData<CSAMTAVariableSet> {

	@Override
	public List<Validator<? super CSAMTAVariableSet>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CSAMTAVariableSet>create(CSAMTAVariableSetNameMustExist.class),
			factory.<CSAMTAVariableSet>create(CSAMTAVariableSetValueMustExist.class)
		);
	}
	
	@Override
	public List<Function<? super CSAMTAVariableSet, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CSAMTAVariableSet> validator(ValidatorFactory factory) {
		return factory.<CSAMTAVariableSet>create(CSAMTAVariableSetValidator.class);
	}

	@Override
	public Validator<? super CSAMTAVariableSet> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CSAMTAVariableSet>create(CSAMTAVariableSetTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CSAMTAVariableSet> validator() {
		return new CSAMTAVariableSetValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CSAMTAVariableSet> typeFormatValidator() {
		return new CSAMTAVariableSetTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CSAMTAVariableSet, Set<String>> onlyExistsValidator() {
		return new CSAMTAVariableSetOnlyExistsValidator();
	}
}
