package fpml.consolidated.doc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.TradeProcessingTimestamps;
import fpml.consolidated.doc.validation.TradeProcessingTimestampsTypeFormatValidator;
import fpml.consolidated.doc.validation.TradeProcessingTimestampsValidator;
import fpml.consolidated.doc.validation.exists.TradeProcessingTimestampsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=TradeProcessingTimestamps.class)
public class TradeProcessingTimestampsMeta implements RosettaMetaData<TradeProcessingTimestamps> {

	@Override
	public List<Validator<? super TradeProcessingTimestamps>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradeProcessingTimestamps, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TradeProcessingTimestamps> validator(ValidatorFactory factory) {
		return factory.<TradeProcessingTimestamps>create(TradeProcessingTimestampsValidator.class);
	}

	@Override
	public Validator<? super TradeProcessingTimestamps> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TradeProcessingTimestamps>create(TradeProcessingTimestampsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TradeProcessingTimestamps> validator() {
		return new TradeProcessingTimestampsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super TradeProcessingTimestamps> typeFormatValidator() {
		return new TradeProcessingTimestampsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeProcessingTimestamps, Set<String>> onlyExistsValidator() {
		return new TradeProcessingTimestampsOnlyExistsValidator();
	}
}
