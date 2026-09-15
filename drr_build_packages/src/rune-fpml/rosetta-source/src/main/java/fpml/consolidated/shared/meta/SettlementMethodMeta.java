package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.SettlementMethod;
import fpml.consolidated.shared.validation.SettlementMethodTypeFormatValidator;
import fpml.consolidated.shared.validation.SettlementMethodValidator;
import fpml.consolidated.shared.validation.exists.SettlementMethodOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=SettlementMethod.class)
public class SettlementMethodMeta implements RosettaMetaData<SettlementMethod> {

	@Override
	public List<Validator<? super SettlementMethod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SettlementMethod, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SettlementMethod> validator(ValidatorFactory factory) {
		return factory.<SettlementMethod>create(SettlementMethodValidator.class);
	}

	@Override
	public Validator<? super SettlementMethod> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SettlementMethod>create(SettlementMethodTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SettlementMethod> validator() {
		return new SettlementMethodValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SettlementMethod> typeFormatValidator() {
		return new SettlementMethodTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SettlementMethod, Set<String>> onlyExistsValidator() {
		return new SettlementMethodOnlyExistsValidator();
	}
}
