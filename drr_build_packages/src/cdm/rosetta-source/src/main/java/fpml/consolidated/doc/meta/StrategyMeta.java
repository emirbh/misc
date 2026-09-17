package fpml.consolidated.doc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.Strategy;
import fpml.consolidated.doc.validation.StrategyTypeFormatValidator;
import fpml.consolidated.doc.validation.StrategyValidator;
import fpml.consolidated.doc.validation.exists.StrategyOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Strategy.class)
public class StrategyMeta implements RosettaMetaData<Strategy> {

	@Override
	public List<Validator<? super Strategy>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Strategy, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Strategy> validator(ValidatorFactory factory) {
		return factory.<Strategy>create(StrategyValidator.class);
	}

	@Override
	public Validator<? super Strategy> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Strategy>create(StrategyTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Strategy> validator() {
		return new StrategyValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Strategy> typeFormatValidator() {
		return new StrategyTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Strategy, Set<String>> onlyExistsValidator() {
		return new StrategyOnlyExistsValidator();
	}
}
