package fpml.consolidated.recordkeeping.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.recordkeeping.processes.ESMACreditDetails;
import fpml.consolidated.recordkeeping.processes.validation.ESMACreditDetailsTypeFormatValidator;
import fpml.consolidated.recordkeeping.processes.validation.ESMACreditDetailsValidator;
import fpml.consolidated.recordkeeping.processes.validation.exists.ESMACreditDetailsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ESMACreditDetails.class)
public class ESMACreditDetailsMeta implements RosettaMetaData<ESMACreditDetails> {

	@Override
	public List<Validator<? super ESMACreditDetails>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ESMACreditDetails, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ESMACreditDetails> validator(ValidatorFactory factory) {
		return factory.<ESMACreditDetails>create(ESMACreditDetailsValidator.class);
	}

	@Override
	public Validator<? super ESMACreditDetails> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ESMACreditDetails>create(ESMACreditDetailsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ESMACreditDetails> validator() {
		return new ESMACreditDetailsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ESMACreditDetails> typeFormatValidator() {
		return new ESMACreditDetailsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ESMACreditDetails, Set<String>> onlyExistsValidator() {
		return new ESMACreditDetailsOnlyExistsValidator();
	}
}
