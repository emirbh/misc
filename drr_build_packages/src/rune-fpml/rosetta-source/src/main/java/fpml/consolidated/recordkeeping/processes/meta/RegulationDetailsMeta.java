package fpml.consolidated.recordkeeping.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.recordkeeping.processes.RegulationDetails;
import fpml.consolidated.recordkeeping.processes.validation.RegulationDetailsTypeFormatValidator;
import fpml.consolidated.recordkeeping.processes.validation.RegulationDetailsValidator;
import fpml.consolidated.recordkeeping.processes.validation.exists.RegulationDetailsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RegulationDetails.class)
public class RegulationDetailsMeta implements RosettaMetaData<RegulationDetails> {

	@Override
	public List<Validator<? super RegulationDetails>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RegulationDetails, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RegulationDetails> validator(ValidatorFactory factory) {
		return factory.<RegulationDetails>create(RegulationDetailsValidator.class);
	}

	@Override
	public Validator<? super RegulationDetails> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RegulationDetails>create(RegulationDetailsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RegulationDetails> validator() {
		return new RegulationDetailsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RegulationDetails> typeFormatValidator() {
		return new RegulationDetailsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RegulationDetails, Set<String>> onlyExistsValidator() {
		return new RegulationDetailsOnlyExistsValidator();
	}
}
