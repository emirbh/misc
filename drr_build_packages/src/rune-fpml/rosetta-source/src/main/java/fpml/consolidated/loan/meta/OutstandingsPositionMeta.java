package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.OutstandingsPosition;
import fpml.consolidated.loan.validation.OutstandingsPositionTypeFormatValidator;
import fpml.consolidated.loan.validation.OutstandingsPositionValidator;
import fpml.consolidated.loan.validation.datarule.OutstandingsPositionChoice;
import fpml.consolidated.loan.validation.exists.OutstandingsPositionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=OutstandingsPosition.class)
public class OutstandingsPositionMeta implements RosettaMetaData<OutstandingsPosition> {

	@Override
	public List<Validator<? super OutstandingsPosition>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<OutstandingsPosition>create(OutstandingsPositionChoice.class)
		);
	}
	
	@Override
	public List<Function<? super OutstandingsPosition, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super OutstandingsPosition> validator(ValidatorFactory factory) {
		return factory.<OutstandingsPosition>create(OutstandingsPositionValidator.class);
	}

	@Override
	public Validator<? super OutstandingsPosition> typeFormatValidator(ValidatorFactory factory) {
		return factory.<OutstandingsPosition>create(OutstandingsPositionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super OutstandingsPosition> validator() {
		return new OutstandingsPositionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super OutstandingsPosition> typeFormatValidator() {
		return new OutstandingsPositionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OutstandingsPosition, Set<String>> onlyExistsValidator() {
		return new OutstandingsPositionOnlyExistsValidator();
	}
}
