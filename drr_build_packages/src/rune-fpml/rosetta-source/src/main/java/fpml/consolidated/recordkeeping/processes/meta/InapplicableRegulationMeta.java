package fpml.consolidated.recordkeeping.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.recordkeeping.processes.InapplicableRegulation;
import fpml.consolidated.recordkeeping.processes.validation.InapplicableRegulationTypeFormatValidator;
import fpml.consolidated.recordkeeping.processes.validation.InapplicableRegulationValidator;
import fpml.consolidated.recordkeeping.processes.validation.datarule.InapplicableRegulationChoice;
import fpml.consolidated.recordkeeping.processes.validation.exists.InapplicableRegulationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=InapplicableRegulation.class)
public class InapplicableRegulationMeta implements RosettaMetaData<InapplicableRegulation> {

	@Override
	public List<Validator<? super InapplicableRegulation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<InapplicableRegulation>create(InapplicableRegulationChoice.class)
		);
	}
	
	@Override
	public List<Function<? super InapplicableRegulation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super InapplicableRegulation> validator(ValidatorFactory factory) {
		return factory.<InapplicableRegulation>create(InapplicableRegulationValidator.class);
	}

	@Override
	public Validator<? super InapplicableRegulation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<InapplicableRegulation>create(InapplicableRegulationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super InapplicableRegulation> validator() {
		return new InapplicableRegulationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super InapplicableRegulation> typeFormatValidator() {
		return new InapplicableRegulationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InapplicableRegulation, Set<String>> onlyExistsValidator() {
		return new InapplicableRegulationOnlyExistsValidator();
	}
}
