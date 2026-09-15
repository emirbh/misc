package fpml.consolidated.doc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.InstrumentTradePrincipal;
import fpml.consolidated.doc.validation.InstrumentTradePrincipalTypeFormatValidator;
import fpml.consolidated.doc.validation.InstrumentTradePrincipalValidator;
import fpml.consolidated.doc.validation.exists.InstrumentTradePrincipalOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=InstrumentTradePrincipal.class)
public class InstrumentTradePrincipalMeta implements RosettaMetaData<InstrumentTradePrincipal> {

	@Override
	public List<Validator<? super InstrumentTradePrincipal>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super InstrumentTradePrincipal, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super InstrumentTradePrincipal> validator(ValidatorFactory factory) {
		return factory.<InstrumentTradePrincipal>create(InstrumentTradePrincipalValidator.class);
	}

	@Override
	public Validator<? super InstrumentTradePrincipal> typeFormatValidator(ValidatorFactory factory) {
		return factory.<InstrumentTradePrincipal>create(InstrumentTradePrincipalTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super InstrumentTradePrincipal> validator() {
		return new InstrumentTradePrincipalValidator();
	}

	@Deprecated
	@Override
	public Validator<? super InstrumentTradePrincipal> typeFormatValidator() {
		return new InstrumentTradePrincipalTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InstrumentTradePrincipal, Set<String>> onlyExistsValidator() {
		return new InstrumentTradePrincipalOnlyExistsValidator();
	}
}
