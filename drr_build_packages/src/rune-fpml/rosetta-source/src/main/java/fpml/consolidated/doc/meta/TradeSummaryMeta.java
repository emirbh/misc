package fpml.consolidated.doc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.TradeSummary;
import fpml.consolidated.doc.validation.TradeSummaryTypeFormatValidator;
import fpml.consolidated.doc.validation.TradeSummaryValidator;
import fpml.consolidated.doc.validation.exists.TradeSummaryOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=TradeSummary.class)
public class TradeSummaryMeta implements RosettaMetaData<TradeSummary> {

	@Override
	public List<Validator<? super TradeSummary>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradeSummary, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TradeSummary> validator(ValidatorFactory factory) {
		return factory.<TradeSummary>create(TradeSummaryValidator.class);
	}

	@Override
	public Validator<? super TradeSummary> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TradeSummary>create(TradeSummaryTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TradeSummary> validator() {
		return new TradeSummaryValidator();
	}

	@Deprecated
	@Override
	public Validator<? super TradeSummary> typeFormatValidator() {
		return new TradeSummaryTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeSummary, Set<String>> onlyExistsValidator() {
		return new TradeSummaryOnlyExistsValidator();
	}
}
