package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.MatchId;
import fpml.consolidated.shared.validation.MatchIdTypeFormatValidator;
import fpml.consolidated.shared.validation.MatchIdValidator;
import fpml.consolidated.shared.validation.exists.MatchIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=MatchId.class)
public class MatchIdMeta implements RosettaMetaData<MatchId> {

	@Override
	public List<Validator<? super MatchId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MatchId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MatchId> validator(ValidatorFactory factory) {
		return factory.<MatchId>create(MatchIdValidator.class);
	}

	@Override
	public Validator<? super MatchId> typeFormatValidator(ValidatorFactory factory) {
		return factory.<MatchId>create(MatchIdTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super MatchId> validator() {
		return new MatchIdValidator();
	}

	@Deprecated
	@Override
	public Validator<? super MatchId> typeFormatValidator() {
		return new MatchIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MatchId, Set<String>> onlyExistsValidator() {
		return new MatchIdOnlyExistsValidator();
	}
}
