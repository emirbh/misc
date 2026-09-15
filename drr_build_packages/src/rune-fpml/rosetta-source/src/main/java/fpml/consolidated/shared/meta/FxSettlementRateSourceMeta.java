package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.FxSettlementRateSource;
import fpml.consolidated.shared.validation.FxSettlementRateSourceTypeFormatValidator;
import fpml.consolidated.shared.validation.FxSettlementRateSourceValidator;
import fpml.consolidated.shared.validation.datarule.FxSettlementRateSourceChoice;
import fpml.consolidated.shared.validation.exists.FxSettlementRateSourceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxSettlementRateSource.class)
public class FxSettlementRateSourceMeta implements RosettaMetaData<FxSettlementRateSource> {

	@Override
	public List<Validator<? super FxSettlementRateSource>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FxSettlementRateSource>create(FxSettlementRateSourceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxSettlementRateSource, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxSettlementRateSource> validator(ValidatorFactory factory) {
		return factory.<FxSettlementRateSource>create(FxSettlementRateSourceValidator.class);
	}

	@Override
	public Validator<? super FxSettlementRateSource> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxSettlementRateSource>create(FxSettlementRateSourceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxSettlementRateSource> validator() {
		return new FxSettlementRateSourceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxSettlementRateSource> typeFormatValidator() {
		return new FxSettlementRateSourceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxSettlementRateSource, Set<String>> onlyExistsValidator() {
		return new FxSettlementRateSourceOnlyExistsValidator();
	}
}
