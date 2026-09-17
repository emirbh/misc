package cdm.legaldocumentation.transaction.additionalterms.meta;

import cdm.legaldocumentation.transaction.additionalterms.FxBenchmarkObligationDefault;
import cdm.legaldocumentation.transaction.additionalterms.validation.FxBenchmarkObligationDefaultTypeFormatValidator;
import cdm.legaldocumentation.transaction.additionalterms.validation.FxBenchmarkObligationDefaultValidator;
import cdm.legaldocumentation.transaction.additionalterms.validation.exists.FxBenchmarkObligationDefaultOnlyExistsValidator;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 6.23.0
 */
@RosettaMeta(model=FxBenchmarkObligationDefault.class)
public class FxBenchmarkObligationDefaultMeta implements RosettaMetaData<FxBenchmarkObligationDefault> {

	@Override
	public List<Validator<? super FxBenchmarkObligationDefault>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxBenchmarkObligationDefault, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxBenchmarkObligationDefault> validator(ValidatorFactory factory) {
		return factory.<FxBenchmarkObligationDefault>create(FxBenchmarkObligationDefaultValidator.class);
	}

	@Override
	public Validator<? super FxBenchmarkObligationDefault> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxBenchmarkObligationDefault>create(FxBenchmarkObligationDefaultTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxBenchmarkObligationDefault> validator() {
		return new FxBenchmarkObligationDefaultValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxBenchmarkObligationDefault> typeFormatValidator() {
		return new FxBenchmarkObligationDefaultTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxBenchmarkObligationDefault, Set<String>> onlyExistsValidator() {
		return new FxBenchmarkObligationDefaultOnlyExistsValidator();
	}
}
