package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.UnitQuantityRef;
import fpml.consolidated.business.events.validation.UnitQuantityRefTypeFormatValidator;
import fpml.consolidated.business.events.validation.UnitQuantityRefValidator;
import fpml.consolidated.business.events.validation.exists.UnitQuantityRefOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=UnitQuantityRef.class)
public class UnitQuantityRefMeta implements RosettaMetaData<UnitQuantityRef> {

	@Override
	public List<Validator<? super UnitQuantityRef>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super UnitQuantityRef, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super UnitQuantityRef> validator(ValidatorFactory factory) {
		return factory.<UnitQuantityRef>create(UnitQuantityRefValidator.class);
	}

	@Override
	public Validator<? super UnitQuantityRef> typeFormatValidator(ValidatorFactory factory) {
		return factory.<UnitQuantityRef>create(UnitQuantityRefTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super UnitQuantityRef> validator() {
		return new UnitQuantityRefValidator();
	}

	@Deprecated
	@Override
	public Validator<? super UnitQuantityRef> typeFormatValidator() {
		return new UnitQuantityRefTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super UnitQuantityRef, Set<String>> onlyExistsValidator() {
		return new UnitQuantityRefOnlyExistsValidator();
	}
}
