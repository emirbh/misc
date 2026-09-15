package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.TradeId;
import fpml.consolidated.shared.validation.TradeIdTypeFormatValidator;
import fpml.consolidated.shared.validation.TradeIdValidator;
import fpml.consolidated.shared.validation.exists.TradeIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=TradeId.class)
public class TradeIdMeta implements RosettaMetaData<TradeId> {

	@Override
	public List<Validator<? super TradeId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradeId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TradeId> validator(ValidatorFactory factory) {
		return factory.<TradeId>create(TradeIdValidator.class);
	}

	@Override
	public Validator<? super TradeId> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TradeId>create(TradeIdTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TradeId> validator() {
		return new TradeIdValidator();
	}

	@Deprecated
	@Override
	public Validator<? super TradeId> typeFormatValidator() {
		return new TradeIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeId, Set<String>> onlyExistsValidator() {
		return new TradeIdOnlyExistsValidator();
	}
}
