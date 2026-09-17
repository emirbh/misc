package fpml.consolidated.confirmation.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.confirmation.processes.ClearingStatus;
import fpml.consolidated.confirmation.processes.validation.ClearingStatusTypeFormatValidator;
import fpml.consolidated.confirmation.processes.validation.ClearingStatusValidator;
import fpml.consolidated.confirmation.processes.validation.exists.ClearingStatusOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ClearingStatus.class)
public class ClearingStatusMeta implements RosettaMetaData<ClearingStatus> {

	@Override
	public List<Validator<? super ClearingStatus>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ClearingStatus, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ClearingStatus> validator(ValidatorFactory factory) {
		return factory.<ClearingStatus>create(ClearingStatusValidator.class);
	}

	@Override
	public Validator<? super ClearingStatus> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ClearingStatus>create(ClearingStatusTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ClearingStatus> validator() {
		return new ClearingStatusValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ClearingStatus> typeFormatValidator() {
		return new ClearingStatusTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ClearingStatus, Set<String>> onlyExistsValidator() {
		return new ClearingStatusOnlyExistsValidator();
	}
}
