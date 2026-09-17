package fpml.consolidated.cd.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.cd.LoanParticipation;
import fpml.consolidated.cd.validation.LoanParticipationTypeFormatValidator;
import fpml.consolidated.cd.validation.LoanParticipationValidator;
import fpml.consolidated.cd.validation.exists.LoanParticipationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanParticipation.class)
public class LoanParticipationMeta implements RosettaMetaData<LoanParticipation> {

	@Override
	public List<Validator<? super LoanParticipation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanParticipation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanParticipation> validator(ValidatorFactory factory) {
		return factory.<LoanParticipation>create(LoanParticipationValidator.class);
	}

	@Override
	public Validator<? super LoanParticipation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanParticipation>create(LoanParticipationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanParticipation> validator() {
		return new LoanParticipationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanParticipation> typeFormatValidator() {
		return new LoanParticipationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanParticipation, Set<String>> onlyExistsValidator() {
		return new LoanParticipationOnlyExistsValidator();
	}
}
