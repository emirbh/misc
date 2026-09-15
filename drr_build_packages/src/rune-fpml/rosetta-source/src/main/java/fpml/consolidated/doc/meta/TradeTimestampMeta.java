package fpml.consolidated.doc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.TradeTimestamp;
import fpml.consolidated.doc.validation.TradeTimestampTypeFormatValidator;
import fpml.consolidated.doc.validation.TradeTimestampValidator;
import fpml.consolidated.doc.validation.exists.TradeTimestampOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=TradeTimestamp.class)
public class TradeTimestampMeta implements RosettaMetaData<TradeTimestamp> {

	@Override
	public List<Validator<? super TradeTimestamp>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradeTimestamp, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TradeTimestamp> validator(ValidatorFactory factory) {
		return factory.<TradeTimestamp>create(TradeTimestampValidator.class);
	}

	@Override
	public Validator<? super TradeTimestamp> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TradeTimestamp>create(TradeTimestampTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TradeTimestamp> validator() {
		return new TradeTimestampValidator();
	}

	@Deprecated
	@Override
	public Validator<? super TradeTimestamp> typeFormatValidator() {
		return new TradeTimestampTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeTimestamp, Set<String>> onlyExistsValidator() {
		return new TradeTimestampOnlyExistsValidator();
	}
}
