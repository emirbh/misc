package fpml.consolidated.doc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.TradeHeader;
import fpml.consolidated.doc.validation.TradeHeaderTypeFormatValidator;
import fpml.consolidated.doc.validation.TradeHeaderValidator;
import fpml.consolidated.doc.validation.datarule.TradeHeaderChoice;
import fpml.consolidated.doc.validation.exists.TradeHeaderOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=TradeHeader.class)
public class TradeHeaderMeta implements RosettaMetaData<TradeHeader> {

	@Override
	public List<Validator<? super TradeHeader>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<TradeHeader>create(TradeHeaderChoice.class)
		);
	}
	
	@Override
	public List<Function<? super TradeHeader, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TradeHeader> validator(ValidatorFactory factory) {
		return factory.<TradeHeader>create(TradeHeaderValidator.class);
	}

	@Override
	public Validator<? super TradeHeader> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TradeHeader>create(TradeHeaderTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TradeHeader> validator() {
		return new TradeHeaderValidator();
	}

	@Deprecated
	@Override
	public Validator<? super TradeHeader> typeFormatValidator() {
		return new TradeHeaderTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeHeader, Set<String>> onlyExistsValidator() {
		return new TradeHeaderOnlyExistsValidator();
	}
}
