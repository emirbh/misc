package fpml.consolidated.recordkeeping.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.recordkeeping.processes.RegReportingCDE;
import fpml.consolidated.recordkeeping.processes.validation.RegReportingCDETypeFormatValidator;
import fpml.consolidated.recordkeeping.processes.validation.RegReportingCDEValidator;
import fpml.consolidated.recordkeeping.processes.validation.exists.RegReportingCDEOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RegReportingCDE.class)
public class RegReportingCDEMeta implements RosettaMetaData<RegReportingCDE> {

	@Override
	public List<Validator<? super RegReportingCDE>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RegReportingCDE, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RegReportingCDE> validator(ValidatorFactory factory) {
		return factory.<RegReportingCDE>create(RegReportingCDEValidator.class);
	}

	@Override
	public Validator<? super RegReportingCDE> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RegReportingCDE>create(RegReportingCDETypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RegReportingCDE> validator() {
		return new RegReportingCDEValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RegReportingCDE> typeFormatValidator() {
		return new RegReportingCDETypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RegReportingCDE, Set<String>> onlyExistsValidator() {
		return new RegReportingCDEOnlyExistsValidator();
	}
}
