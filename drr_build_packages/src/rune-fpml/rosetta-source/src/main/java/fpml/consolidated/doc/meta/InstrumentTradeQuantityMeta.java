package fpml.consolidated.doc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.InstrumentTradeQuantity;
import fpml.consolidated.doc.validation.InstrumentTradeQuantityTypeFormatValidator;
import fpml.consolidated.doc.validation.InstrumentTradeQuantityValidator;
import fpml.consolidated.doc.validation.datarule.InstrumentTradeQuantityChoice;
import fpml.consolidated.doc.validation.exists.InstrumentTradeQuantityOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=InstrumentTradeQuantity.class)
public class InstrumentTradeQuantityMeta implements RosettaMetaData<InstrumentTradeQuantity> {

	@Override
	public List<Validator<? super InstrumentTradeQuantity>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<InstrumentTradeQuantity>create(InstrumentTradeQuantityChoice.class)
		);
	}
	
	@Override
	public List<Function<? super InstrumentTradeQuantity, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super InstrumentTradeQuantity> validator(ValidatorFactory factory) {
		return factory.<InstrumentTradeQuantity>create(InstrumentTradeQuantityValidator.class);
	}

	@Override
	public Validator<? super InstrumentTradeQuantity> typeFormatValidator(ValidatorFactory factory) {
		return factory.<InstrumentTradeQuantity>create(InstrumentTradeQuantityTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super InstrumentTradeQuantity> validator() {
		return new InstrumentTradeQuantityValidator();
	}

	@Deprecated
	@Override
	public Validator<? super InstrumentTradeQuantity> typeFormatValidator() {
		return new InstrumentTradeQuantityTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InstrumentTradeQuantity, Set<String>> onlyExistsValidator() {
		return new InstrumentTradeQuantityOnlyExistsValidator();
	}
}
