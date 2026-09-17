package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.SettlementRateSource;
import fpml.consolidated.shared.validation.SettlementRateSourceTypeFormatValidator;
import fpml.consolidated.shared.validation.SettlementRateSourceValidator;
import fpml.consolidated.shared.validation.datarule.SettlementRateSourceChoice;
import fpml.consolidated.shared.validation.exists.SettlementRateSourceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=SettlementRateSource.class)
public class SettlementRateSourceMeta implements RosettaMetaData<SettlementRateSource> {

	@Override
	public List<Validator<? super SettlementRateSource>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<SettlementRateSource>create(SettlementRateSourceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super SettlementRateSource, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SettlementRateSource> validator(ValidatorFactory factory) {
		return factory.<SettlementRateSource>create(SettlementRateSourceValidator.class);
	}

	@Override
	public Validator<? super SettlementRateSource> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SettlementRateSource>create(SettlementRateSourceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SettlementRateSource> validator() {
		return new SettlementRateSourceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SettlementRateSource> typeFormatValidator() {
		return new SettlementRateSourceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SettlementRateSource, Set<String>> onlyExistsValidator() {
		return new SettlementRateSourceOnlyExistsValidator();
	}
}
