package fpml.consolidated.doc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.TradeIdentifier;
import fpml.consolidated.doc.TradeIdentifierExtended;
import fpml.consolidated.doc.validation.TradeIdentifierExtendedTypeFormatValidator;
import fpml.consolidated.doc.validation.TradeIdentifierExtendedValidator;
import fpml.consolidated.doc.validation.datarule.TradeIdentifierChoice;
import fpml.consolidated.doc.validation.exists.TradeIdentifierExtendedOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=TradeIdentifierExtended.class)
public class TradeIdentifierExtendedMeta implements RosettaMetaData<TradeIdentifierExtended> {

	@Override
	public List<Validator<? super TradeIdentifierExtended>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<TradeIdentifier>create(TradeIdentifierChoice.class)
		);
	}
	
	@Override
	public List<Function<? super TradeIdentifierExtended, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TradeIdentifierExtended> validator(ValidatorFactory factory) {
		return factory.<TradeIdentifierExtended>create(TradeIdentifierExtendedValidator.class);
	}

	@Override
	public Validator<? super TradeIdentifierExtended> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TradeIdentifierExtended>create(TradeIdentifierExtendedTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TradeIdentifierExtended> validator() {
		return new TradeIdentifierExtendedValidator();
	}

	@Deprecated
	@Override
	public Validator<? super TradeIdentifierExtended> typeFormatValidator() {
		return new TradeIdentifierExtendedTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeIdentifierExtended, Set<String>> onlyExistsValidator() {
		return new TradeIdentifierExtendedOnlyExistsValidator();
	}
}
