package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.CashflowFixing;
import fpml.consolidated.business.events.validation.CashflowFixingTypeFormatValidator;
import fpml.consolidated.business.events.validation.CashflowFixingValidator;
import fpml.consolidated.business.events.validation.exists.CashflowFixingOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CashflowFixing.class)
public class CashflowFixingMeta implements RosettaMetaData<CashflowFixing> {

	@Override
	public List<Validator<? super CashflowFixing>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CashflowFixing, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CashflowFixing> validator(ValidatorFactory factory) {
		return factory.<CashflowFixing>create(CashflowFixingValidator.class);
	}

	@Override
	public Validator<? super CashflowFixing> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CashflowFixing>create(CashflowFixingTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CashflowFixing> validator() {
		return new CashflowFixingValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CashflowFixing> typeFormatValidator() {
		return new CashflowFixingTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CashflowFixing, Set<String>> onlyExistsValidator() {
		return new CashflowFixingOnlyExistsValidator();
	}
}
