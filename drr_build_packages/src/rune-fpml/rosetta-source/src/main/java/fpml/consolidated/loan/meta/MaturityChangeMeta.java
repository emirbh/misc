package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.MaturityChange;
import fpml.consolidated.loan.validation.MaturityChangeTypeFormatValidator;
import fpml.consolidated.loan.validation.MaturityChangeValidator;
import fpml.consolidated.loan.validation.exists.MaturityChangeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=MaturityChange.class)
public class MaturityChangeMeta implements RosettaMetaData<MaturityChange> {

	@Override
	public List<Validator<? super MaturityChange>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MaturityChange, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MaturityChange> validator(ValidatorFactory factory) {
		return factory.<MaturityChange>create(MaturityChangeValidator.class);
	}

	@Override
	public Validator<? super MaturityChange> typeFormatValidator(ValidatorFactory factory) {
		return factory.<MaturityChange>create(MaturityChangeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super MaturityChange> validator() {
		return new MaturityChangeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super MaturityChange> typeFormatValidator() {
		return new MaturityChangeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MaturityChange, Set<String>> onlyExistsValidator() {
		return new MaturityChangeOnlyExistsValidator();
	}
}
