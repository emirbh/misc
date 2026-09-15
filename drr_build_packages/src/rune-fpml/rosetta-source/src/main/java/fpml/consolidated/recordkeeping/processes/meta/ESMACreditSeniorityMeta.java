package fpml.consolidated.recordkeeping.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.recordkeeping.processes.ESMACreditSeniority;
import fpml.consolidated.recordkeeping.processes.validation.ESMACreditSeniorityTypeFormatValidator;
import fpml.consolidated.recordkeeping.processes.validation.ESMACreditSeniorityValidator;
import fpml.consolidated.recordkeeping.processes.validation.exists.ESMACreditSeniorityOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ESMACreditSeniority.class)
public class ESMACreditSeniorityMeta implements RosettaMetaData<ESMACreditSeniority> {

	@Override
	public List<Validator<? super ESMACreditSeniority>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ESMACreditSeniority, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ESMACreditSeniority> validator(ValidatorFactory factory) {
		return factory.<ESMACreditSeniority>create(ESMACreditSeniorityValidator.class);
	}

	@Override
	public Validator<? super ESMACreditSeniority> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ESMACreditSeniority>create(ESMACreditSeniorityTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ESMACreditSeniority> validator() {
		return new ESMACreditSeniorityValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ESMACreditSeniority> typeFormatValidator() {
		return new ESMACreditSeniorityTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ESMACreditSeniority, Set<String>> onlyExistsValidator() {
		return new ESMACreditSeniorityOnlyExistsValidator();
	}
}
