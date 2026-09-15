package fpml.consolidated.doc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.TradeDifference;
import fpml.consolidated.doc.validation.TradeDifferenceTypeFormatValidator;
import fpml.consolidated.doc.validation.TradeDifferenceValidator;
import fpml.consolidated.doc.validation.exists.TradeDifferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=TradeDifference.class)
public class TradeDifferenceMeta implements RosettaMetaData<TradeDifference> {

	@Override
	public List<Validator<? super TradeDifference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradeDifference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TradeDifference> validator(ValidatorFactory factory) {
		return factory.<TradeDifference>create(TradeDifferenceValidator.class);
	}

	@Override
	public Validator<? super TradeDifference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TradeDifference>create(TradeDifferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TradeDifference> validator() {
		return new TradeDifferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super TradeDifference> typeFormatValidator() {
		return new TradeDifferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeDifference, Set<String>> onlyExistsValidator() {
		return new TradeDifferenceOnlyExistsValidator();
	}
}
