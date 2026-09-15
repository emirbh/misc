package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.EventProposedMatch;
import fpml.consolidated.business.events.validation.EventProposedMatchTypeFormatValidator;
import fpml.consolidated.business.events.validation.EventProposedMatchValidator;
import fpml.consolidated.business.events.validation.datarule.EventProposedMatchChoice;
import fpml.consolidated.business.events.validation.exists.EventProposedMatchOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=EventProposedMatch.class)
public class EventProposedMatchMeta implements RosettaMetaData<EventProposedMatch> {

	@Override
	public List<Validator<? super EventProposedMatch>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<EventProposedMatch>create(EventProposedMatchChoice.class)
		);
	}
	
	@Override
	public List<Function<? super EventProposedMatch, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EventProposedMatch> validator(ValidatorFactory factory) {
		return factory.<EventProposedMatch>create(EventProposedMatchValidator.class);
	}

	@Override
	public Validator<? super EventProposedMatch> typeFormatValidator(ValidatorFactory factory) {
		return factory.<EventProposedMatch>create(EventProposedMatchTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super EventProposedMatch> validator() {
		return new EventProposedMatchValidator();
	}

	@Deprecated
	@Override
	public Validator<? super EventProposedMatch> typeFormatValidator() {
		return new EventProposedMatchTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EventProposedMatch, Set<String>> onlyExistsValidator() {
		return new EventProposedMatchOnlyExistsValidator();
	}
}
