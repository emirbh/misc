package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.IssuerTradeId;
import fpml.consolidated.shared.validation.IssuerTradeIdTypeFormatValidator;
import fpml.consolidated.shared.validation.IssuerTradeIdValidator;
import fpml.consolidated.shared.validation.exists.IssuerTradeIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=IssuerTradeId.class)
public class IssuerTradeIdMeta implements RosettaMetaData<IssuerTradeId> {

	@Override
	public List<Validator<? super IssuerTradeId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super IssuerTradeId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super IssuerTradeId> validator(ValidatorFactory factory) {
		return factory.<IssuerTradeId>create(IssuerTradeIdValidator.class);
	}

	@Override
	public Validator<? super IssuerTradeId> typeFormatValidator(ValidatorFactory factory) {
		return factory.<IssuerTradeId>create(IssuerTradeIdTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super IssuerTradeId> validator() {
		return new IssuerTradeIdValidator();
	}

	@Deprecated
	@Override
	public Validator<? super IssuerTradeId> typeFormatValidator() {
		return new IssuerTradeIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super IssuerTradeId, Set<String>> onlyExistsValidator() {
		return new IssuerTradeIdOnlyExistsValidator();
	}
}
