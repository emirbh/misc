package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.AccruingFeeChange;
import fpml.consolidated.loan.validation.AccruingFeeChangeTypeFormatValidator;
import fpml.consolidated.loan.validation.AccruingFeeChangeValidator;
import fpml.consolidated.loan.validation.exists.AccruingFeeChangeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AccruingFeeChange.class)
public class AccruingFeeChangeMeta implements RosettaMetaData<AccruingFeeChange> {

	@Override
	public List<Validator<? super AccruingFeeChange>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AccruingFeeChange, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AccruingFeeChange> validator(ValidatorFactory factory) {
		return factory.<AccruingFeeChange>create(AccruingFeeChangeValidator.class);
	}

	@Override
	public Validator<? super AccruingFeeChange> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AccruingFeeChange>create(AccruingFeeChangeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AccruingFeeChange> validator() {
		return new AccruingFeeChangeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AccruingFeeChange> typeFormatValidator() {
		return new AccruingFeeChangeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AccruingFeeChange, Set<String>> onlyExistsValidator() {
		return new AccruingFeeChangeOnlyExistsValidator();
	}
}
